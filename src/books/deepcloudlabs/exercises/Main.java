package books.deepcloudlabs.exercises;

import books.deepcloudlabs.dao.*;
import books.deepcloudlabs.domain.*;
import books.deepcloudlabs.pair.ContinentCityPair;
import books.deepcloudlabs.pair.CountryCityCountPair;
import books.deepcloudlabs.pair.DirectorGenrePair;
import books.deepcloudlabs.pair.DirectorGenresPair;
import books.deepcloudlabs.service.InMemoryDataService;
import books.deepcloudlabs.service.MovieService;
import util.PrintUtil;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

public class Main {
    private static final MovieService movieService = InMemoryDataService.getInstance();
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        //Ex. 1  Find the number of movies of each director

        final Collection<Movie> movies = movieService.findAllMovies();
        Map<String, Long> dirMovCounts = movies.stream()
                .map(Movie::getDirectors)
                .flatMap(Collection::stream)
                .collect(groupingBy(Director::getName, counting()));


        //Ex. 2 Find the most populated city of each continent
        //expected result <String, List<City>>

        //map data to List<ContinentCityPair>
        //Stream<ContinentCityPair>
        //ContinentCityPair[continent=Oceania, city=City [id=3494, name=Auckland, population=381800, countryCode=NZL]]

        var highPopulatedCityOfEachContinent = countryDao.findAllCountries().stream()
                .map(country -> country.getCities().stream()
                        .map(city -> new ContinentCityPair(country.getContinent(), city))
                        //.peek(System.out::println)
                        .toList()

                )
                .flatMap(Collection::stream)
                .collect(groupingBy(ContinentCityPair::continent,
                        maxBy(ContinentCityPair::compareTo)));

        //highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);


        //Ex. 3 Find the number of genres of each director's movies
        Map<Director, Map<Genre, Long>>  directorGenreNumbers =
                movieService.findAllMovies()
                        .stream()
                        .map( movie -> movie.getDirectors().stream()
                                .map(director -> new DirectorGenresPair(director, movie.getGenres())).toList())
                        //.peek(System.out::println) //List<Director, List<Genres>>
                        .flatMap(Collection::stream)
                        .map( directorGenres -> directorGenres.genres().stream()
                                .map( genre -> new DirectorGenrePair(directorGenres.director(), genre) ).toList())
                        //.peek(s-> System.out.println(s +"\n")) //List<Director, Genres>
                        .flatMap(Collection::stream)
                        .collect(
                                groupingBy(DirectorGenrePair::director,
                                        groupingBy(DirectorGenrePair::genre,counting())));


//        directorGenreNumbers.forEach(( director, genreCounts)->{
//            System.out.printf("%s\n",director.getName());
//
//            genreCounts.forEach( (genre,count) -> System.out.printf("\t%s: %s\n",genre.getName(),count));
//        });


        //Ex. 4 Find the highest populated capital city

        var highPopulatedCapitalCity2 =
                countryDao.findAllCountries()
                        .stream()
                        .map(Country::getCapitalID)
                        .map(cityDao::findCityById) //relate by ID with CityDao!
                        //.peek(System.out::println)
                        .filter(Objects::nonNull)
                        .max(Comparator.comparing(City::getPopulation));

        //highPopulatedCapitalCity2.ifPresent(System.out::println);

        //Ex. 5

        // Find the highest populated capital city of each continent
        Function<ContinentCityPair, City> extractCity = ContinentCityPair::city;
        var highPopulatedNOTCapitalCityOfEachContinent = countryDao.findAllCountries().stream()
                .map(country -> country.getCities().stream()
                        .map(city -> new ContinentCityPair(country.getContinent(), city)).toList())
                .flatMap(Collection::stream)
                .filter(pair -> Objects.nonNull(pair.city()))
                //.peek(System.out::println)
                .collect(groupingBy(
                        ContinentCityPair::continent,
                        maxBy(Comparator.comparingInt(continentCityPair -> continentCityPair.city().getPopulation()))));

        var highPopulatedCapitalCityOfEachContinent1 =
                countryDao.findAllCountries()
                        .stream()
                        .map(country -> new ContinentCityPair(country.getContinent(), cityDao.findCityById(country.getCapitalID())))
                        .filter(pair -> Objects.nonNull(pair.city()))
                        .collect(groupingBy(ContinentCityPair::continent,
                                maxBy(Comparator.comparing(extractCity.andThen(City::getPopulation)))));


        var highPopulatedCapitalCityOfEachContinent3 =
                countryDao.findAllCountries()
                        .stream()
                        .map(country -> new ContinentCityPair(country.getContinent(), cityDao.findCityById(country.getCapitalID())))
                        .filter(pair -> Objects.nonNull(pair.city()))
                        .collect(groupingBy(
                                ContinentCityPair::continent,
                                maxBy(Comparator.comparingInt(continentCityPair -> continentCityPair.city().getPopulation()))));


        //Ex. 6 Sort the countries by number of their cities in descending order
        var countriesWithCityCountInDescOrder = countryDao.findAllCountries().stream()
                .map(country -> new CountryCityCountPair(country, country.getCities().size()))
                .sorted(Comparator.comparingInt(CountryCityCountPair::count).reversed())
                .distinct()
                .toList();

        //Ex. 7 Find the list of movies having the genres "Drama" and "Comedy" only
        var listOfGenreNames = List.of("Drama", "Comedy");
        var listOfGenres = listOfGenreNames.stream().map(movieService::findGenreByName).toList();


        var moviesInDramaAndComedyOnly = movieService.findAllMovies().stream()
                .filter( movie -> movie.getGenres().size() == 2)
                .filter( movie -> movie.getGenres().containsAll(listOfGenres))
                .toList();


        //Ex. 8 Group the movies by the year and list them
        var moviesByYear = movieService.findAllMovies().stream()
                .collect(groupingBy(Movie::getYear));

        //Ex. 9 Sort the countries by their population densities in descending order ignoring zero population countries
        var countries = worldDao.findAllCountries();
        Predicate<Country> countryPredicate = country -> country.getPopulation() == 0;


        var countriesSortedByPopulationDensityDescOrder = countries.stream()
                .filter(countryPredicate.negate())
                .sorted(comparingDouble(country-> country.getPopulation() / country.getSurfaceArea()))
                .distinct();

        countriesSortedByPopulationDensityDescOrder.forEach(System.out::println);

        //Ex. 10
        //Ex. 11
        //Ex. 12
        //Ex. 13
        //Ex. 14
        //Ex. 15
        //Ex. 16
        //Ex. 17


    }

}


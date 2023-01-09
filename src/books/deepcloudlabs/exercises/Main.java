package books.deepcloudlabs.exercises;

import books.deepcloudlabs.dao.*;
import books.deepcloudlabs.domain.*;
import books.deepcloudlabs.service.InMemoryDataService;
import books.deepcloudlabs.service.MovieService;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class Main {
    private static final MovieService movieService = InMemoryDataService.getInstance();
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();

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
                        .map(Country::getCapital)
                        .map(cityDao::findCityById) //relate by ID with CityDao
                        //.peek(System.out::println)
                        .filter(Objects::nonNull)
                        .max(Comparator.comparing(City::getPopulation));
        highPopulatedCapitalCity2.ifPresent(System.out::println);

        //Ex. 5
        //Ex. 6
        //Ex. 7
        //Ex. 8
        //Ex. 9
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


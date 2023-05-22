package books.deepcloudlabs.part_1.exercises;

import books.deepcloudlabs.part_1.dao.CityDao;
import books.deepcloudlabs.part_1.dao.CountryDao;
import books.deepcloudlabs.part_1.dao.InMemoryWorldDao;
import books.deepcloudlabs.part_1.dao.WorldDao;
import books.deepcloudlabs.part_1.service.InMemoryDataService;
import books.deepcloudlabs.part_1.service.MovieService;

public class DeepCloudsMain {
    private static final MovieService movieService = InMemoryDataService.getInstance();
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        //Ex. 1  Find the number of movies of each director

        //Ex. 2 Find the most populated city of each continent

        //Ex. 3 Find the number of genres of each director's movies

        //Ex. 4 Find the highest populated capital city

        //Ex. 5  Find the highest populated capital city of each continent

        //Ex. 6 Sort the countries by number of their cities in descending order

        //Ex. 7 Find the list of movies having the genres "Drama" and "Comedy" only

        //Ex. 8 Group the movies by the year and list them

        //Ex. 9 Sort the countries by their population densities in descending order ignoring zero population countries

        //Ex. 10 Find the richest country of each continent with respect to their GNP (Gross National Product) values.

        //Ex. 11 Find the minimum, the maximum and the average population of world countries

        //Ex. 12 Find the minimum, the maximum and the average population of each continent.

    }

}


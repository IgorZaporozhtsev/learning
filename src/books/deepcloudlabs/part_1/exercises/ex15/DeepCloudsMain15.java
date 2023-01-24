package books.deepcloudlabs.part_1.exercises.ex15;

import books.deepcloudlabs.part_1.dao.CountryDao;
import books.deepcloudlabs.part_1.dao.InMemoryWorldDao;
import books.deepcloudlabs.part_1.domain.Country;
import util.PrintUtil;

import java.util.Comparator;
import java.util.function.ToIntFunction;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class DeepCloudsMain15 {

    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Group the countries by continent, and then sort the countries in each continent by number of cities in each country.


        //Map<Continent, List<Country>>

        ToIntFunction<Country> compareByCityNumber = country -> country.getCities().size();


        var countriesByContinent =
                countryDao.findAllCountries().stream()
                        .sorted(Comparator.comparingInt(compareByCityNumber).reversed())
                        .collect(groupingBy(Country::getContinent, toList()));


        PrintUtil.printMapOfList(countriesByContinent);

    }
}

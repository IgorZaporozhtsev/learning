package books.deepcloudlabs.exercises.ex14;

import books.deepcloudlabs.dao.InMemoryWorldDao;
import books.deepcloudlabs.dao.WorldDao;
import books.deepcloudlabs.domain.Country;
import books.deepcloudlabs.util.CountrySummaryStatistics;
import util.PrintUtil;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class DeepCloudsMain14 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {


        //Ex. 14   Find the countries of each continent with the minimum and the maximum population
        BiConsumer<String, CountrySummaryStatistics> printEntry =
                (continent, statistics) -> System.out.printf("%s: %s\n", continent, statistics);

        BiConsumer<CountrySummaryStatistics, Country> accumulator = CountrySummaryStatistics::accept;

        BinaryOperator<CountrySummaryStatistics> combiner = (l, r) -> {
            l.combine(r);
            return l;
        };

        Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier =
                () -> new CountrySummaryStatistics(Comparator.comparingLong(Country::getPopulation));



        var continentStatistics =
                worldDao.findAllCountries()
                        .stream()
                        .collect(groupingBy(
                                Country::getContinent,
                                Collector.of(countrySummaryStatisticsSupplier, accumulator, combiner)));


        continentStatistics.forEach(printEntry);


    }
}

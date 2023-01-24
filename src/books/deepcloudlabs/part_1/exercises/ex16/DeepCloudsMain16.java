package books.deepcloudlabs.part_1.exercises.ex16;

import books.deepcloudlabs.part_1.dao.InMemoryWorldDao;
import books.deepcloudlabs.part_1.dao.WorldDao;
import books.deepcloudlabs.part_1.domain.Country;
import books.deepcloudlabs.part_1.util.CountryCitySummaryStatistics;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeepCloudsMain16 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
    private static final BiConsumer<CountryCitySummaryStatistics, Country> accumulator = CountryCitySummaryStatistics::accept;
    private static final BinaryOperator<CountryCitySummaryStatistics> combiner = (l, r) -> { l.combine(r); return l; };

    private static final BiConsumer<String, CountryCitySummaryStatistics> printEntry =
            (country,statistics) -> System.out.printf("%s: %s\n", country, statistics);

    public static void main(String[] args) {
        // Find the cities with the minimum and the maximum population in countries.
        //<String, CountryCitySummaryStatistics>


        var countryCityStatistics = worldDao.findAllCountries().stream()
                        .collect(Collectors.groupingBy(
                                Country::getCode,
                                Collector.of(CountryCitySummaryStatistics::new, accumulator, combiner)));


        countryCityStatistics.forEach(printEntry);
    }
}

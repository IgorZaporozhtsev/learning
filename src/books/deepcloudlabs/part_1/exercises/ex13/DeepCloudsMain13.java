package books.deepcloudlabs.part_1.exercises.ex13;

import books.deepcloudlabs.part_1.dao.InMemoryWorldDao;
import books.deepcloudlabs.part_1.dao.WorldDao;
import books.deepcloudlabs.part_1.util.CountrySummaryStatistics;

import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class DeepCloudsMain13 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        //Ex. 13
        // Find the countries with the minimum and the maximum population

        Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier =
                () -> new CountrySummaryStatistics();

        var countrySummaryStatistics = worldDao.findAllCountries().stream()
                .collect(
                        countrySummaryStatisticsSupplier,
                        CountrySummaryStatistics::accept,
                        CountrySummaryStatistics::combine);

        System.out.println(countrySummaryStatistics);


//---------------------------------for testing purpose-----------------------------------------------------

        Supplier<StringBuffer> supplier                 = StringBuffer::new;
        ObjIntConsumer<StringBuffer> accumulator        = StringBuffer::append;
        BiConsumer<StringBuffer, StringBuffer> combiner = StringBuffer::append;

        StringBuffer collect =
                IntStream.range(0, 10)
                        .collect(supplier, accumulator, combiner);

        //System.out.println("collect = " + collect);
    }

//-----------------------------------------------------------------------------------------------------
}

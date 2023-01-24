package books.deepcloudlabs.part_1.exercises.ex17;

import books.deepcloudlabs.part_1.dao.InMemoryWorldDao;
import books.deepcloudlabs.part_1.dao.WorldDao;
import books.deepcloudlabs.part_1.domain.Country;
import books.deepcloudlabs.part_1.util.DoubleSummaryGaussianStatistics;

public class DeepCloudsMain17 {

    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the minimum, the maximum, the average, and the standard deviation of GNP values.
        var gnpStatistics =
                worldDao.findAllCountries().stream()
                        .mapToDouble(Country::getGnp)
                        .collect(
                                DoubleSummaryGaussianStatistics::new,
                                DoubleSummaryGaussianStatistics::accept,
                                DoubleSummaryGaussianStatistics::combine);

        System.out.println(gnpStatistics);

    }
}

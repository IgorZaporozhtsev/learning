package books.deepcloudlabs.part_1.exercises.ex18;

import books.deepcloudlabs.part_1.domain.Movie;
import books.deepcloudlabs.part_1.service.InMemoryDataService;
import books.deepcloudlabs.part_1.service.MovieService;


import java.util.Map;

import static java.util.stream.Collectors.*;

public class DeepCloudsMain18 {

    private static final MovieService movieService = InMemoryDataService.getInstance();

    public static void main(String[] args) {
        // Find the year where the maximum number of movie is available

        var movies = movieService.findAllMovies();

        var maxMovieCountByYear2 =
                movies.stream()
                        .collect(groupingBy(Movie::getYear,counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue());

        maxMovieCountByYear2.ifPresent(System.out::println);
    }



}

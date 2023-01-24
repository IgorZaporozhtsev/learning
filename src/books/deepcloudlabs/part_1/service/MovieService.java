package books.deepcloudlabs.part_1.service;

import books.deepcloudlabs.part_1.domain.CriteriaBean;
import books.deepcloudlabs.part_1.domain.Director;
import books.deepcloudlabs.part_1.domain.Genre;
import books.deepcloudlabs.part_1.domain.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieService {
    Movie findMovieById(int id);

    Collection<Movie> findAllMovies();

    Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear);

    Collection<Movie> findAllMoviesByDirectorId(int directorId);

    Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre,
                                                       int fromYear, int toYear);

    Collection<Movie> findAllMoviesByGenre(String genre);
    Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria);

    Movie addMovie(int id, String title, int year, String imdb,
                   List<Genre> genres, List<Director> directors);

    Genre findGenreByName(String genre);

    Collection<Genre> findAllGenres();

    Collection<Director> findAllDirectors();
}

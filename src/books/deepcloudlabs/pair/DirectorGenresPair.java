package books.deepcloudlabs.pair;

import books.deepcloudlabs.domain.Director;
import books.deepcloudlabs.domain.Genre;

import java.util.List;

public record DirectorGenresPair(Director director, List<Genre> genres) { }
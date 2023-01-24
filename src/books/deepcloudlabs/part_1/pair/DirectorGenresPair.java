package books.deepcloudlabs.part_1.pair;

import books.deepcloudlabs.part_1.domain.Director;
import books.deepcloudlabs.part_1.domain.Genre;

import java.util.List;

public record DirectorGenresPair(Director director, List<Genre> genres) { }

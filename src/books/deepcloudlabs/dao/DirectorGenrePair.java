package books.deepcloudlabs.dao;

import books.deepcloudlabs.domain.Director;
import books.deepcloudlabs.domain.Genre;

public record DirectorGenrePair(Director director, Genre genre) { }

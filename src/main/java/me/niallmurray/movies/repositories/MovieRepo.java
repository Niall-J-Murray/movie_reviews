package me.niallmurray.movies.repositories;

import me.niallmurray.movies.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {

  Optional<Movie> findMovieByImdbId(String imdbId);
}

package me.niallmurray.movies.service;

import me.niallmurray.movies.domain.Movie;
import me.niallmurray.movies.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
  @Autowired
  private MovieRepo movieRepo;

  public List<Movie> findAllMovies() {
    return movieRepo.findAll();
  }

  public Optional<Movie> findMovieByid(Long id) {
    return movieRepo.findById(id);
  }

  public Optional<Movie> findMovieByImdbId(String imdbId) {
    return movieRepo.findMovieByImdbId(imdbId);
  }
}

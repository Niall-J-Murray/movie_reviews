package me.niallmurray.movies.service;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.tools.ApiUrl;
import me.niallmurray.movies.domain.Movie;
import me.niallmurray.movies.domain.Review;
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

  public void addReview(String imdbId, Review review) {
    Optional<Movie> movie = findMovieByImdbId(imdbId);
    if (movie.isPresent()) {
      movie.get().getReviewIds().add(review);
      movieRepo.save(movie.get());
    }
  }

  public MovieDb findFromDbByName() {
    TmdbMovies movies = new TmdbApi("1a1844a63992cd78d9abf85060e0e036").getMovies();
    ApiUrl apiUrl = new ApiUrl("movie/11");
    return movies.mapJsonResult(apiUrl, MovieDb.class);
  }

  public Movie findFromDbByNameAndMap() {
    TmdbMovies movies = new TmdbApi("1a1844a63992cd78d9abf85060e0e036").getMovies();
    ApiUrl apiUrl = new ApiUrl("movie/11?api_key=1a1844a63992cd78d9abf85060e0e036");
    return movies.mapJsonResult(apiUrl, Movie.class);
  }

  public MovieDb findFromTMDBAPi(int dbId) {
    TmdbMovies movies = new TmdbApi("1a1844a63992cd78d9abf85060e0e036").getMovies();
    return movies.getMovie(dbId, "en");
  }

}

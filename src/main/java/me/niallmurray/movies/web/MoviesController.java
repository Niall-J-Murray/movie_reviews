package me.niallmurray.movies.web;

import me.niallmurray.movies.domain.Movie;
import me.niallmurray.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
  }

//  @GetMapping("/{id}")
//  public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {
//    return new ResponseEntity<>(movieService.findMovieByid(id), HttpStatus.OK);
//  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
    return new ResponseEntity<>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
  }
}

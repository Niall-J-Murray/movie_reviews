package me.niallmurray.movies.web;

import info.movito.themoviedbapi.model.MovieDb;
import me.niallmurray.movies.domain.Movie;
import me.niallmurray.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/api/v1/movies")
public class MoviesController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
  }

    @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
    return new ResponseEntity<>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
  }


  @GetMapping("/dbm")
  public ResponseEntity<MovieDb> findFromDbByName() {
    return new ResponseEntity<>(movieService.findFromDbByName(), HttpStatus.OK);
  }

  @GetMapping("/dbmap")
  public ResponseEntity<Movie> findFromDbByNameAndMap() {
    return new ResponseEntity<>(movieService.findFromDbByNameAndMap(), HttpStatus.OK);
  }

    @GetMapping("/db/{dbId}")
  public ResponseEntity<MovieDb> getMovieFromAPIDB(@PathVariable int dbId) {
    ResponseEntity<MovieDb> responseEntity = new ResponseEntity<>(movieService.findFromTMDBAPi(dbId), HttpStatus.OK);
    System.out.println(responseEntity.getHeaders());
    return responseEntity;
  }

}

package me.niallmurray.movies.web;

import me.niallmurray.movies.domain.Review;
import me.niallmurray.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/api/v1/reviews")
public class ReviewController {
  @Autowired
  private ReviewService reviewService;

  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
    return new ResponseEntity<>
            (reviewService.createReview((payload.get("id")), payload.get("imdbId"), payload.get("reviewBody")), HttpStatus.CREATED);
  }

}

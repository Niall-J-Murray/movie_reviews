package me.niallmurray.movies.service;

import me.niallmurray.movies.domain.Review;
import me.niallmurray.movies.repositories.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
  @Autowired
  private ReviewRepo reviewRepo;
  @Autowired
  private MovieService movieService;

  public List<Review> findAllReviews() {
    return reviewRepo.findAll();
  }

  public Optional<Review> findReviewById(Long id) {
    return reviewRepo.findById(id);
  }

  public Review createReview(String id, String imdbId, String reviewBody) {
    Review review = new Review(imdbId, reviewBody);
    reviewRepo.save(review);
    System.out.println(review.getId());
    movieService.addReview(imdbId, review);
    return review;
  }
}

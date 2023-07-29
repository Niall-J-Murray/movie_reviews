package me.niallmurray.movies.repositories;

import me.niallmurray.movies.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}

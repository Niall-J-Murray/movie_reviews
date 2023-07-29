package me.niallmurray.movies.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
  @Id
  @GeneratedValue
  private Long id;
  private String imdbId;
  private String body;

  public Review(String imdbId, String reviewBody) {
    this.imdbId = imdbId;
    this.body = reviewBody;
  }
}

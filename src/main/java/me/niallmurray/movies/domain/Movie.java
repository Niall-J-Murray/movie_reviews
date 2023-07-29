package me.niallmurray.movies.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
  @Id
  @GeneratedValue
  private Long id;
  private String imdbId;
  private String title;
  private String releaseDate;
  private String trailerLink;
  @JdbcTypeCode(SqlTypes.JSON)
  private List<String> genres;
  private String poster;
  @JdbcTypeCode(SqlTypes.JSON)
  private List<String> backdrops;
  @JdbcTypeCode(SqlTypes.JSON)
  private List<Review> reviewIds;
}

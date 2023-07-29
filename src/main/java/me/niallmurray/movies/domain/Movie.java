package me.niallmurray.movies.domain;

import jakarta.persistence.*;
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
  //  @ManyToOne
  //  @JoinColumn
  @JdbcTypeCode(SqlTypes.JSON)
  //  @OneToMany(mappedBy="id", cascade={CascadeType.ALL})
  private List<Review> reviewIds;
}

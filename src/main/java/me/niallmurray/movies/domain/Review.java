package me.niallmurray.movies.domain;

import jakarta.persistence.*;
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
//  @ManyToOne
//  @JoinColumn(name="movieId", nullable=false)
  private Long id;
  private String body;
}

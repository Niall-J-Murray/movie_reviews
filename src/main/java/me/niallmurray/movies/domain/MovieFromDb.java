package me.niallmurray.movies.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.*;
import info.movito.themoviedbapi.model.core.MovieKeywords;
import info.movito.themoviedbapi.model.core.ResultsPage;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MovieFromDb {
  @JsonProperty("title")
  private String title;
  @JsonProperty("original_title")
  private String originalTitle;
  @JsonProperty("popularity")
  private float popularity;
  @JsonProperty("backdrop_path")
  private String backdropPath;
  @JsonProperty("poster_path")
  private String posterPath;
  @JsonProperty("release_date")
  private String releaseDate;
  @JsonProperty("adult")
  private boolean adult;
  @JsonProperty("belongs_to_collection")
  private Collection belongsToCollection;
  @JsonProperty("budget")
  private long budget;
  @JsonProperty("genres")
  private List<Genre> genres;
  @JsonProperty("homepage")
  private String homepage;
  @JsonProperty("overview")
  private String overview;
  @JsonProperty("imdb_id")
  private String imdbID;
  @JsonProperty("original_language")
  private String originalLanguage;
  @JsonProperty("production_companies")
  private List<ProductionCompany> productionCompanies;
  @JsonProperty("production_countries")
  private List<ProductionCountry> productionCountries;
  @JsonProperty("revenue")
  private long revenue;
  @JsonProperty("runtime")
  private int runtime;
  @JsonProperty("spoken_languages")
  private List<Language> spokenLanguages;
  @JsonProperty("tagline")
  private String tagline;
  @JsonProperty("rating")
  private float userRating;
  @JsonProperty("vote_average")
  private float voteAverage;
  @JsonProperty("vote_count")
  private int voteCount;
  @JsonProperty("status")
  private String status;
  @JsonProperty("alternative_titles")
  private MoviesAlternativeTitles alternativeTitles;
  @JsonProperty("credits")
  private Credits credits;
  @JsonProperty("images")
  private MovieImages images;
  @JsonProperty("keywords")
  private MovieKeywords keywords;
  @JsonProperty("release_dates")
  private TmdbMovies.ReleaseInfoResults releases;
  @JsonProperty("videos")
  private Video.Results videos;
  @JsonProperty("translations")
  private MovieTranslations translations;
  @JsonProperty("similar")
  private ResultsPage<info.movito.themoviedbapi.model.MovieDb> similarMovies;
  @JsonProperty("recommendations")
  private ResultsPage<info.movito.themoviedbapi.model.MovieDb> recommendedMovies;
  @JsonProperty("reviews")
  private ResultsPage<Reviews> reviews;
  @JsonProperty("lists")
  private ResultsPage<MovieList> lists;
}

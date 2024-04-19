package com.devsuperior.uri2611.entities;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "id_genres")
  private Genre genre;

  public Movie() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", genre=" + genre +
            '}';
  }
}

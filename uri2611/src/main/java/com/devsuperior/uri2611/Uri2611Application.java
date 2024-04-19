package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
  private final MovieRepository movieRepository;

  public Uri2611Application(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(Uri2611Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<MovieMinProjection> list = this.movieRepository.search1("Action");
    List<MovieMinDTO> result1 = list.stream().map(MovieMinDTO::new).collect(Collectors.toList());

    System.out.println("\n*** RESULTADO SQL RAÍZ: ");
    for (MovieMinDTO obj : result1) {
      System.out.println(obj);
    }

    System.out.println("\n"); // Quebras de linha.

    List<MovieMinDTO> result2 = this.movieRepository.search2("Action");
    System.out.println("\n*** RESULTADO JPQL: ");
    for (MovieMinDTO obj : result2) {
      System.out.println(obj);
    }

  }
}

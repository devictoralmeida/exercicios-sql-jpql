package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

  @Autowired
  private CategoryRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Uri2609Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<CategorySumProjection> list = this.repository.search1();
    List<CategorySumDTO> resul1 = list.stream().map(CategorySumDTO::new).collect(Collectors.toList());

    System.out.println("\n*** RESULTADO SQL RAÍZ: ");
    for (CategorySumDTO obj : resul1) {
      System.out.println(obj);
    }

    System.out.println("\n\n"); // Quebras de linha.

    List<CategorySumDTO> resul2 = this.repository.search2();
    System.out.println("\n*** RESULTADO JPQL: ");
    for (CategorySumDTO obj : resul2) {
      System.out.println(obj);
    }
  }
}

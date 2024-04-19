package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

  @Autowired
  private ProductRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Uri2621Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<ProductMinProjection> list = this.repository.search1(10, 20, "P");
    List<ProductMinDTO> result1 = list.stream().map(ProductMinDTO::new).collect(Collectors.toList());

    System.out.println("\n*** RESULTADO SQL RAÍZ: ");
    for (ProductMinDTO obj : result1) {
      System.out.println(obj);
    }

    System.out.println("\n\n"); // Quebras de linha.

    List<ProductMinDTO> result2 = this.repository.search2(10, 20, "P");
    System.out.println("\n*** RESULTADO JPQL: ");
    for (ProductMinDTO obj : result2) {
      System.out.println(obj);
    }
  }
}
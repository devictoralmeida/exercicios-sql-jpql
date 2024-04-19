package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

  @Autowired
  private EmpregadoRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Uri2990Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<EmpregadoDeptProjection> list = this.repository.search1();
    List<EmpregadoDeptDTO> result1 = list.stream().map(EmpregadoDeptDTO::new).collect(Collectors.toList());

    System.out.println("\n*** RESULTADO SQL RAÍZ: ");
    for (EmpregadoDeptDTO obj : result1) {
      System.out.println(obj);
    }

    System.out.println("\n\n"); // Quebras de linha.

    List<EmpregadoDeptDTO> result2 = this.repository.search2();
    System.out.println("\n*** RESULTADO JPQL: ");
    for (EmpregadoDeptDTO obj : result2) {
      System.out.println(obj);
    }
  }
}

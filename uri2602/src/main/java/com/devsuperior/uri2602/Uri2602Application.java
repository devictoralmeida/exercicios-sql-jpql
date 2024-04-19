package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.projections.CustomerNameProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
  private final CustomerRepository customerRepository;

  public Uri2602Application(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(Uri2602Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<CustomerNameProjection> list = this.customerRepository.search1("RS");
    List<CustomerNameDTO> resultSQL = list.stream().map(CustomerNameDTO::new).collect(Collectors.toList());

    System.out.println("\n*** RESULTADO SQL RAÍZ: ");
    for (CustomerNameDTO name : resultSQL) {
      System.out.println(name); // Aqui não usamos o getter oq criamos o método toString().
    }

    System.out.println("\n\n"); // Quebras de linha.

    System.out.println("\n*** RESULTADO JPQL: ");
    List<CustomerNameDTO> resultJPQL = this.customerRepository.search2("RS");
    for (CustomerNameDTO name : resultJPQL) {
      System.out.println(name);
    }
  }
}

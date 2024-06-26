package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // Query nativa com SQL Raiz
  @Query(nativeQuery = true, value = "SELECT name FROM customers WHERE UPPER(state) = UPPER(:state)")
  List<CustomerNameProjection> search1(String state);

  // Query com JPQL, não precisa da projection
  @Query("SELECT new com.devsuperior.uri2602.dto.CustomerNameDTO(obj.name) FROM Customer obj WHERE UPPER(obj.state) =" +
          " UPPER(:state)")
  List<CustomerNameDTO> search2(String state);
}

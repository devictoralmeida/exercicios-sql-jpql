package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  // Query SQL raiz:
  @Query(nativeQuery = true, value = "SELECT p.name FROM products p INNER JOIN providers p2 ON p.id_providers = p2.id" +
          " WHERE p.amount BETWEEN  :min AND :max AND p2.name LIKE CONCAT(:beginName, '%')")
  List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

  // Query JPQL:
  @Query(value =
          "SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) FROM Product obj WHERE " +
                  "obj.amount BETWEEN :min AND :max AND obj.provider.name LIKE CONCAT(:beginName, '%')")
  List<ProductMinDTO> search2(Integer min, Integer max, String beginName);

}

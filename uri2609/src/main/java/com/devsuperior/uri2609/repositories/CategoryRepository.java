package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  // Query SQL raíz:
  @Query(nativeQuery = true, value = "SELECT c.name, SUM(p.amount) FROM categories c INNER JOIN products p ON p.id_categories" +
          " = c.id GROUP BY c.name")
  List<CategorySumProjection> search1();

  // Query JPQL:
  // Aqui vamos iniciar pelo lado N da relação, pois fica mais fácil de acessar o outro lado, pois se partirmos da
  // categoria, não seria possível acessar uma Lista de produtos.
  @Query(value = "SELECT new  com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, SUM(obj.amount)) FROM " +
          "Product obj GROUP BY obj.category.name")
  List<CategorySumDTO> search2();
}

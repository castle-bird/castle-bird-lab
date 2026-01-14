package io.castlebird.lab.repository;

import io.castlebird.lab.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // JPQL
    @Query("SELECT f FROM Food f JOIN FETCH f.category")
    List<Food> findAllJPQL();
}

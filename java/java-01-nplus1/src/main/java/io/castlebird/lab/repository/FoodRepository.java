package io.castlebird.lab.repository;

import io.castlebird.lab.entity.Food;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // JPQL
    @Query("SELECT f FROM Food f JOIN FETCH f.category")
    List<Food> findAllJPQL();

    // @EntityGraph을 테스트할때는 주석 해제
    @Override
    @EntityGraph(attributePaths = {"category"})
    List<Food> findAll();
}

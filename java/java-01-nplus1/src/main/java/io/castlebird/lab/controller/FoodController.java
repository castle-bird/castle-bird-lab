package io.castlebird.lab.controller;

import io.castlebird.lab.dto.FoodDTO;
import io.castlebird.lab.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    // 기본 조회. N + 1 발생
    @GetMapping("/foods")
    public List<FoodDTO> getFoods() {

        return foodService.findAll();
    }

    // JPQL의 FETCH JOIN 사용 조회. N + 1 미발생
    @GetMapping("/foods/JPQL")
    public List<FoodDTO> getFoodsJPQL() {

        return foodService.findAllJPQL();
    }

    // @EntityGraph 사용. N + 1 미발생
    @GetMapping("/foods/EntityGraph")
    public List<FoodDTO> getFoodsEntityGraph() {

        return foodService.findAllEntityGraph();
    }
}

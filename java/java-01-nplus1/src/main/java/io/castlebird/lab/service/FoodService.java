package io.castlebird.lab.service;

import io.castlebird.lab.dto.FoodDTO;
import io.castlebird.lab.entity.Food;
import io.castlebird.lab.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    // Entity -> DTO
    public FoodDTO convertToDTO(Food food) {

        // 3. CategoryId, CategoryName에 접근 안한채 DTO 변환 시 N+1 발생 안함
        FoodDTO foodDTO = FoodDTO.builder()
                .id(food.getId())
                .foodName(food.getFoodName())
                .price(food.getPrice())
                .build();

        // 4. 이때 문제 발생.
        //  findAll()의 1번에서 확인했듯이 최초에는 Category를 조회하지 않았음.
        //  그러나 현재 getCategory()에 접급하는 순간 없던 Category를 조회하기 위해 추가 쿼리가 발생
        if (food.getCategory() != null) {
            foodDTO.setCategoryId(food.getCategory().getId());
            foodDTO.setCategoryName(food.getCategory().getCategoryName());
        }

        return foodDTO;
    }

    // 저장
    public void save(Food food) {
        foodRepository.save(food);
    }

    // 전체 조회 (N + 1) 발생
    public List<FoodDTO> findAll() {
        // 1. 이때 까진 카테고리 내용이 없는 순수 Food의 내용만 담겨있음
        List<Food> foods = foodRepository.findAll();

        // 2. 그러나 DTO변환시 convertToDTO내부 코드로인해 N + 1 발생 중!
        return foods.stream()
                .map(this::convertToDTO)
                .toList();
    }

    // 전체 조회 (N + 1) 미발생
    // JPQL의 FETCH JOIN 사용
    public List<FoodDTO> findAllJPQL() {
        List<Food> foods = foodRepository.findAllJPQL();

        return foods.stream()
                .map(this::convertToDTO)
                .toList();
    }

    // 전체 조회 (N + 1) 미발생
    // @EntityGraph 사용
    public List<FoodDTO> findAllEntityGraph() {
        List<Food> foods = foodRepository.findAll();

        return foods.stream()
                .map(this::convertToDTO)
                .toList();
    }
}

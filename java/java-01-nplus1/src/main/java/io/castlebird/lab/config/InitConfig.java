package io.castlebird.lab.config;

import io.castlebird.lab.entity.Category;
import io.castlebird.lab.entity.Food;
import io.castlebird.lab.repository.CategoryRepository;
import io.castlebird.lab.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitConfig implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final FoodRepository foodRepository;

    @Override
    public void run(String... args) throws Exception {

        // 초기 데이터 설정을 위함
        // 카테고리 등록. 한식, 일식, 중식
        Category c1 = Category.builder()
                .categoryName("한식")
                .build();

        Category c2 = Category.builder()
                .categoryName("일식")
                .build();

        Category c3 = Category.builder()
                .categoryName("중식")
                .build();

        Category c4 = Category.builder()
                .categoryName("양식")
                .build();
        Category c5 = Category.builder()
                .categoryName("디저트")
                .build();

        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);
        categoryRepository.save(c4);
        categoryRepository.save(c5);

        Food f1 = Food.builder().category(c1).foodName("불고기").price(10000).build();
        Food f2 = Food.builder().category(c1).foodName("잡채").price(12000).build();
        Food f3 = Food.builder().category(c1).foodName("삼계탕").price(10000).build();
        Food f4 = Food.builder().category(c1).foodName("삼겹살").price(15000).build();
        Food f5 = Food.builder().category(c1).foodName("김치").price(1000).build();
        Food f6 = Food.builder().category(c1).foodName("해물파전").price(12000).build();
        Food f7 = Food.builder().category(c1).foodName("막걸리").price(6000).build();

        Food f8 = Food.builder().category(c2).foodName("초밥").price(20000).build();
        Food f9 = Food.builder().category(c2).foodName("회").price(36000).build();
        Food f10 = Food.builder().category(c2).foodName("우동").price(8000).build();
        Food f11 = Food.builder().category(c2).foodName("오코노미야끼").price(15000).build();

        Food f12 = Food.builder().category(c3).foodName("짜장면").price(20000).build();
        Food f13 = Food.builder().category(c3).foodName("짬뽕").price(36000).build();
        Food f14 = Food.builder().category(c3).foodName("깐풍기").price(8000).build();
        Food f15 = Food.builder().category(c3).foodName("탕수육").price(15000).build();

        Food f16 = Food.builder().category(c4).foodName("파스타").price(12000).build();
        Food f17 = Food.builder().category(c4).foodName("피자").price(20000).build();
        Food f18 = Food.builder().category(c4).foodName("토마토스튜").price(10000).build();
        Food f19 = Food.builder().category(c4).foodName("스테이크").price(30000).build();

        Food f20 = Food.builder().category(c5).foodName("아이스아메리카노").price(2000).build();
        Food f21 = Food.builder().category(c5).foodName("아이스라때").price(3500).build();
        Food f22 = Food.builder().category(c5).foodName("카라멜마끼야또").price(4000).build();
        Food f23 = Food.builder().category(c5).foodName("딸기스무디").price(5000).build();

        foodRepository.saveAll(List.of(
                f1, f2, f3, f4, f5, f6, f7, f8, f9, f10,
                f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
                f21, f22, f23
        ));
    }
}

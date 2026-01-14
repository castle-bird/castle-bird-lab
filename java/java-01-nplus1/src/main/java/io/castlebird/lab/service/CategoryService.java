package io.castlebird.lab.service;

import io.castlebird.lab.entity.Category;
import io.castlebird.lab.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 저장
    public void save(Category category) {
        categoryRepository.save(category);
    }
}

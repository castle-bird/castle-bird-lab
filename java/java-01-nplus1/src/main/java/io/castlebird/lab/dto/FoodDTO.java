package io.castlebird.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class FoodDTO {
    private Long id;
    private String foodName;
    private Integer price;
    private Long categoryId;
    private String categoryName;
}

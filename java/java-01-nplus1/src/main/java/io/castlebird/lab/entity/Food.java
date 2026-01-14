package io.castlebird.lab.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_food")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                '}';
    }
}

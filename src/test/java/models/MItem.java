package models;

import lombok.*;

@Data
@NoArgsConstructor
public class MItem {
    private String brand, oldPrice, newPrice, discount;
}


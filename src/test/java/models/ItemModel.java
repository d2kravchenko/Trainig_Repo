package models;

import lombok.*;

@Data
@NoArgsConstructor
public class ItemModel {
    private String brand, oldPrice, newPrice, discount;
}


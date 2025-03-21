package com.jupiter.store.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductVariantDTO {
    private int price;
    private Integer quantity;
    private Long attributeId;
    private String attributeValue;
    private String imagePath;
}

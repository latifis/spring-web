package com.latif.web.product.dto.output;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOutput {
    private Long id;
    private String name;
    private String description;
    private Double price;
}

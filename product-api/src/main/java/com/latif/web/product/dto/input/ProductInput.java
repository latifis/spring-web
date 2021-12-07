package com.latif.web.product.dto.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductInput {

    @Pattern(regexp = "")
    private String name;

//    @NotBlank //ada isi tapi blank (" ")
//    @NotEmpty //bener" kosong ("")
//    @NotNull

    @NotBlank
    private String description;

    @NotBlank
    private Double price;
}

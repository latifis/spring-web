package com.latif.web.product.service;

import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;

import java.util.List;

public interface ProductService {
    ProductOutput getOne(Long id);

    List<ProductOutput> getAll();

    ProductOutput addOne(ProductInput input);

    void deleteOne(Long id);
}

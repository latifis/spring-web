package com.latif.web.product.controller;

import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;
import com.latif.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {          //pakai implements ProductService untuk create  get add and all
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutput> getOne(@PathVariable Long id) {  //jangan lupa add path variabel krn ada getmapping id
        ProductOutput output = productService.getOne(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping
    public List<ProductOutput> getAll() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Boolean> addOne(@RequestBody ProductInput input) {   //janganlupa request body karena harus req body
        productService.addOne(input);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(Boolean.TRUE);
    }
    //ResponEntity untuk memberikan respon entity 200 atau 400 dsb
}

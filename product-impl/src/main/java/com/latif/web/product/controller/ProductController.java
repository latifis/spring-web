package com.latif.web.product.controller;

import com.latif.web.dto.BaseResponse;
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
    //kalau ada 2 pakai
    //@autowired
    //@Qualifier("productServiceImpl")
    //private ProductService productService;
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductOutput>> getOne(@PathVariable Long id) {  //jangan lupa add path variabel krn ada getmapping id
        ProductOutput output = productService.getOne(id);
        return ResponseEntity.ok(new BaseResponse<>(output));
    }

    @GetMapping
    public ResponseEntity<List<ProductOutput>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Boolean>> addOne(@RequestBody ProductInput input) {   //janganlupa request body karena harus req body
        productService.addOne(input);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(Boolean.TRUE);
    }
    //ResponEntity untuk memberikan respon entity 200 atau 400 dsb
}

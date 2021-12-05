package com.latif.web.product.controller;

import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutput> getOne(@PathVariable Long id){ //path variabel tuh buat nandain id sebagai path variabel
        return ResponseEntity.ok(ProductOutput.builder().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductOutput>> getAll(){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductOutput> getOne(ProductInput productInput){ //path variabel tuh buat nandain id sebagai path variabel
        return ResponseEntity.ok(ProductOutput.builder().build());
    }
}

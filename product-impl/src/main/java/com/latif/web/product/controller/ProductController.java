package com.latif.web.product.controller;

import com.latif.web.dto.BaseResponse;
import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;
import com.latif.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<BaseResponse<Boolean>> addOne(@Valid @RequestBody ProductInput input) {   //janganlupa request body karena harus req body
        productService.addOne(input);                                                               //jangan lupa tambah @valid untuk validasi
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable Long id) {
        return ResponseEntity.ok(Boolean.TRUE);
    }
    //ResponEntity untuk memberikan respon entity 200 atau 400 dsb

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse<?> handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        return new BaseResponse<>(false, defaultMessage);
    }
}

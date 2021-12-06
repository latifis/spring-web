package com.latif.web.product.service;

import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;
import com.latif.web.product.model.Product;
import com.latif.web.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    //add product repository with this. or @autowired
    //autowired scr magic cari ada ProductRepository ga
    //autowired tricky wktu testing
    //@Autowired
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public ProductOutput getOne(Long id) {
        //optional tuh kayak nullable
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()){
            return null;
        }
        Product temp = product.get();
        return ProductOutput
                .builder()
                .id(temp.getId())
                .name(temp.getName())
                .description(temp.getDescription())
                .price(temp.getPrice())
                .build();
    }

    @Override
    public List<ProductOutput> getAll() {
        return null;
    }

    @Override
    public void addOne(ProductInput input) {
        Product product = Product
                .builder()
                .name(input.getName())
                .description(input.getDescription())
                .price(input.getPrice())
                .build();
        this.repository.save(product);
    }

    @Override
    public void deleteOne(Long id) {

    }
}

package com.latif.web.product.service;

import com.latif.web.product.dto.input.ProductInput;
import com.latif.web.product.dto.output.ProductOutput;
import com.latif.web.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<ProductOutput> getAll() {
        return null;
    }

    @Override
    public ProductOutput addOne(ProductInput input) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }
}
package com.shahsad.productservice.service;

import com.shahsad.productservice.dto.ProductRequest;
import com.shahsad.productservice.dto.ProductResponse;
import com.shahsad.productservice.model.Product;
import com.shahsad.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;



    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is Saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products = productRepository.findAll();
       ///       Replaced products.stream().map(product -> mapToProductResponse(product)) with lambda reference
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

package com.muazzam.sample.mapper;

import com.muazzam.sample.domain.ProductDto;
import com.muazzam.sample.model.Product;
import com.muazzam.sample.model.ProductType;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product mapToDomain(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setProductType(createProductType(productDto));
        return product;
    }

    private ProductType createProductType(ProductDto productDto) {
        ProductType productType = new ProductType();
        productType.setType(productDto.getType());
        return productType;
    }

    public Collection<ProductDto> mapToDto(Collection<Product> products) {
        return products.stream().map(this::createProductDto).collect(Collectors.toList());
    }

    private ProductDto createProductDto(Product product) {
        ProductDto productDto = new ProductDto(product.getName(), product.getProductType().getType(), product.getPrice());
        productDto.setId(product.getId());

        return productDto;
    }

}

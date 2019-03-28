package com.muazzam.sample.controller;

import com.muazzam.sample.domain.ProductDto;
import com.muazzam.sample.mapper.ProductMapper;
import com.muazzam.sample.model.Product;
import com.muazzam.sample.model.ProductType;
import com.muazzam.sample.service.ProductService;
import com.muazzam.sample.validator.ProductValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerRestTest {
    private static final String PRODUCT_TYPE = "Car";
    private static final int PRODUCT_ID = 1;
    @InjectMocks
    private ProductControllerRest productControllerRest;
    @Mock
    private ProductValidator productValidator;
    @Mock
    private ProductService productService;
    @Mock
    private ProductMapper productMapper;

    @Test
    public void shouldAddProducts() {
        List<ProductDto> productDtos = Collections.singletonList(buildProductDto("Ferari", "10000$", "Car"));
        Product product = buildProductDomain();
        when(productMapper.mapToDomain(productDtos.get(0))).thenReturn(product);

        ResponseEntity responseEntity = productControllerRest.addProducts(productDtos);

        verify(productValidator).validate(productDtos);
        verify(productMapper).mapToDomain(productDtos.get(0));
        verify(productService).add(Collections.singletonList(product));
        assertEquals(CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void shouldGetProducts() {
        List<Product> productList = Collections.singletonList(buildProductDomain());
        when(productService.get(PRODUCT_TYPE, PRODUCT_ID)).thenReturn(productList);
        List<ProductDto> expectedDto = Collections.singletonList(buildProductDto("Ferari", "10000$", "Car"));
        when(productMapper.mapToDto(productList)).thenReturn(expectedDto);

        Collection<ProductDto> actualProductDto = productControllerRest.getProducts(PRODUCT_TYPE, PRODUCT_ID);

        verify(productService).get(PRODUCT_TYPE, PRODUCT_ID);
        verify(productValidator).checkForEntityNotFound(productList);
        assertEquals(expectedDto, actualProductDto);
    }

    @Test
    public void shouldDeleteProduct() {

        ResponseEntity responseEntity = productControllerRest.removeProduct(PRODUCT_ID);

        verify(productService).remove(PRODUCT_ID);
        assertEquals(NO_CONTENT, responseEntity.getStatusCode());

    }


    private Product buildProductDomain() {
        Product product = new Product();
        product.setName("Ferari");
        product.setName("1000$");
        product.setProductType(getProductType());
        return product;
    }

    private ProductType getProductType() {
        ProductType productType = new ProductType();
        productType.setType("Car");
        return productType;
    }


    private ProductDto buildProductDto(String name, String price, String type) {
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setType(type);
        return productDto;
    }
}
package com.muazzam.sample.validator;

import com.muazzam.sample.domain.ProductDto;
import com.muazzam.sample.model.Product;
import com.muazzam.sample.exception.BadRequestException;
import com.muazzam.sample.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Objects.isNull;

@Component
public class ProductValidator {

    public void validate(Collection<ProductDto> products) {
        validateProductDto(products);

        for (ProductDto product : products) {
            validateProductAttributes(product);
        }
    }

    private void checkProductName(Collection<ProductDto> productDto) {
        if (productDto.isEmpty()) {
            throw new BadRequestException("The requested URL could not be processed because of bad request");
        }
    }

    private void validateProductDto(Collection<ProductDto> productDto) {
        if (productDto.isEmpty()) {
            throw new BadRequestException("The requested URL could not be processed because of bad request");
        }
    }

    private void validateProductAttributes(ProductDto productDto) {
        String productName = productDto.getName();
        String productType = productDto.getType();

        if (isNull(productName) || productName.trim().isEmpty()) {
            throw new BadRequestException("The requested URL could not be processed because of bad request");
        }
        if (isNull(productType) || productType.trim().isEmpty()) {
            throw new BadRequestException("The requested URL could not be processed because of bad request");
        }
    }

    public void checkForEntityNotFound(Collection<Product> products) {
        if (products.isEmpty()) {
            throw new EntityNotFoundException();
        }

    }


}

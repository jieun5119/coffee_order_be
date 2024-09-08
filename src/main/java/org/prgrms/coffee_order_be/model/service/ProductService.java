package org.prgrms.coffee_order_be.model.service;

import org.prgrms.coffee_order_be.model.dto.OrderDTO;
import org.prgrms.coffee_order_be.model.dto.ProductDTO;
import org.prgrms.coffee_order_be.model.entity.ProductEntity;
import org.prgrms.coffee_order_be.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //1. 제품 생성
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    //2. 모든 제품 조회
    public List<ProductEntity> productList() {
        return productRepository.findAll();
    }

    //3. 제품 상세 조회
    public ProductEntity findProductByProductName(String productName) {
        return productRepository.findByProductName(productName)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
    }

    //4. 제품 수정
    public ProductEntity updateProduct(UUID productId, ProductDTO updatedProduct) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다.~"));

        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        return productRepository.save(product);
    }

    //5. 제품 삭제
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }


}

package org.prgrms.coffee_order_be.model.dto;

import org.prgrms.coffee_order_be.model.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ProductDTO {
    private UUID productId;
    private String productName;
    private String category;
    private Long price;
    private String description;

    public ProductDTO() {
    }
    // ProductEntity -> ProductDTO 변환
    public static ProductDTO toProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setCategory(productEntity.getCategory());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        return productDTO;
    }

    // ProductDTO -> ProductEntity 변환
    public static ProductEntity toProductEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setCategory(productDTO.getCategory());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        return productEntity;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
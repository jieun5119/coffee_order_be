package org.prgrms.coffee_order_be.Controller;

import org.prgrms.coffee_order_be.model.dto.ProductDTO;
import org.prgrms.coffee_order_be.model.entity.ProductEntity;
import org.prgrms.coffee_order_be.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping // 제품 생성기능
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductEntity productEntity = ProductDTO.toProductEntity(productDTO);
        ProductEntity createdProduct = productService.createProduct(productEntity);
        ProductDTO responseDTO = ProductDTO.toProductDTO(createdProduct);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping // 제품 조회 (전체 제품)
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductEntity> products = productService.productList();
        List<ProductDTO> dtos = products.stream()
                .map(ProductDTO::toProductDTO)
                .toList();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{productName}") // 제품이름으로 상세 조회
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String productName){
        ProductEntity productEntity = productService.findProductByProductName(productName);
        ProductDTO dtos = ProductDTO.toProductDTO(productEntity);
        return ResponseEntity.ok().body(dtos);
    }

    @PutMapping("/{productId}") // 제품 수정기능
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID productId, @RequestBody ProductDTO productDTO) {
        ProductEntity updatedProduct = productService.updateProduct(productId, productDTO);
        ProductDTO dto = ProductDTO.toProductDTO(updatedProduct);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{productId}") // 제품 삭제 기능
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.codesoom.assignment.application;

import com.codesoom.assignment.domain.Product;
import com.codesoom.assignment.domain.ProductRepository;
import com.codesoom.assignment.domain.ProductSaveRequest;
import com.codesoom.assignment.domain.ProductUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 상품 변경 담당
 */
@Transactional
@Service
public class ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 상품 저장 후 반환합니다.
     */
    public Product saveProduct(final ProductSaveRequest productSaveRequest) {

        final Product product = productSaveRequest.toProduct();

        return productRepository.save(product);
    }

    /**
     * 상품 교체 후 반환합니다.
     *
     * @param product       교체 대상 상품
     * @param replaceSource 교체될 상품 데이터
     */
    public Product replaceProduct(final Product product, final ProductUpdateRequest replaceSource) {

        return replaceSource.replaceProduct(product);
    }

    /**
     * 상품 변경 후 반환합니다.
     *
     * @param product      변경 대상 상품
     * @param updateSource 변경할 상품 데이터
     */
    public Product updateProduct(final Product product, final ProductUpdateRequest updateSource) {

        return updateSource.updateProduct(product);
    }

    /**
     * 상품을 삭제합니다.
     *
     * @param product 삭제할 상품
     */
    public void deleteProduct(final Product product) {
        productRepository.delete(product);
    }
}
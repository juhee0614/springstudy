package com.kh.productapp.product.svc;

import java.util.List;

import com.kh.productapp.product.dto.ProductDTO;

public interface ProductSVC {
	
	/**
	 * 상품등록
	 * @param productDTO
	 * @return 등록된상품
	 */
	ProductDTO createProduct(ProductDTO productDTO);
	
	/**
	 * 상품조회
	 * @param pid
	 * @return 조회된상품
	 */
	ProductDTO findProduct(String pid);
	
	/**
	 * 상품목록
	 * @return 상품전체목록
	 */
	List<ProductDTO> findAll();
}

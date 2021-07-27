package com.kh.productapp.product.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.productapp.product.dao.ProductDAO;
import com.kh.productapp.product.dto.ProductDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {

	private final ProductDAO productDAO;
	
	//상품등록
	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		return productDAO.createProduct(productDTO);
	}
	//상품전체목록
	@Override
	public List<ProductDTO> findAll() {
		return productDAO.findAll();
	}
	//상품조회
	@Override
	public ProductDTO findProduct(String pid) {
		return productDAO.findProduct(pid);
	}
}

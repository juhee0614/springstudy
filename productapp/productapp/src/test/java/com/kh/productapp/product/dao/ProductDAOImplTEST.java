package com.kh.productapp.product.dao;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.kh.productapp.product.dto.ProductDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional //테스트하고 데이터값이 등록안됨! rollback됨
@Slf4j
public class ProductDAOImplTEST {
	
//	@Autowired
//	private JdbcTemplate jt;
	@Autowired
	private ProductDAOImpl productImpl;
	
	@Test
	@DisplayName("상품등록")
	@Disabled
	void createProduct() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPid("pro-06");
		productDTO.setPname("의자2");
		productDTO.setPcount(6);
		productDTO.setPprice(500000);
		
	ProductDTO storedProductDTO = productImpl.createProduct(productDTO);
	
	Assertions.assertThat(productDTO).isEqualToComparingFieldByField(storedProductDTO);
	}
	
	
	@Test
	@DisplayName("상품목록")
	void findAll() {
		
		List<ProductDTO> list = productImpl.findAll();
		
		for(ProductDTO item : list) {
			log.info(item.toString());
		}
		
		
	}
}

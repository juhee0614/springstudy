package com.kh.productapp.product.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.productapp.product.dto.ProductDTO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ProductDAOImpl implements ProductDAO {

	
	private final JdbcTemplate jdbcTemplate; //변수선언
	
//	@Autowired
//	public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//	allargsconstructor해주면 위 생성자 안만들어도됨!
	
	//상품등록
	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
	
		StringBuffer sql= new StringBuffer();
		sql.append("insert into product values(?,?,?,?)" );
		
		jdbcTemplate.update(sql.toString(), 
												productDTO.getPid(),
												productDTO.getPname(),
												productDTO.getPcount(),
												productDTO.getPprice());
		
		return findProduct(productDTO.getPid());
	}

	//상품조회
	@Override
	public ProductDTO findProduct(String pid) {
		StringBuffer sql = new StringBuffer();
		sql.append("select pid,pname,pcount,pprice ");
		sql.append("from product ");
		sql.append("where pid =? ");
		
	ProductDTO productDTO =jdbcTemplate.queryForObject(sql.toString(), 
												new BeanPropertyRowMapper<>(ProductDTO.class),
												pid); 
		

		
		return productDTO;
	}
	
	//상품전체목록
	@Override
	public List<ProductDTO> findAll() {
	 
		StringBuffer sql = new StringBuffer();
		
		sql.append("select pid,pname,pcount,pprice ");
		sql.append("from product");
		
		List<ProductDTO> list = jdbcTemplate.query(sql.toString(),
											new BeanPropertyRowMapper<>(ProductDTO.class));
		
		return list;
	}
}

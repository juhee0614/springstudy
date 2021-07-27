package com.kh.productapp.product.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //디폴트생성자 만들어줌
@AllArgsConstructor//모든매개변수로 생성자 만들어줌
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDTO {
	
	private String pid;
	private String pname;
	private Integer pcount;
	private Integer pprice;
	
	
}

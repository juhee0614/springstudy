package com.kh.productapp.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.productapp.product.dto.ProductDTO;
import com.kh.productapp.product.svc.ProductSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductSVC productSVC;
	//private final static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	//상품목록
	@GetMapping("/productList")
	public String productList(Model model) {
		log.info("상품목록");
		
		List<ProductDTO> list = productSVC.findAll();
		model.addAttribute("pList",list);
		return "product/productList";
	}
	//상품등록폼출력
	@GetMapping("/productForm")
	public String productForm() {
		
		return "product/productForm";
	}
	//상품등록
	//@PostMapping("")
	public String product(
			@RequestParam("pid") String pid,
			@RequestParam("pname") String pname,
			@RequestParam("pcount") Integer pcount,
			@RequestParam("pprice")Integer pprice) {
		
		//trace,debug,info,warn,error
		log.info("pid:{},pname:{},pcount:{},pprice:{}",pid,pname,pcount,pprice);
		
		return "product/productDetail";
	}
	
	//@PostMapping("")
	public String product2(//파라미터 이름과 매개변수 이름이 같으면 생략가능!
			@RequestParam String pid,
			@RequestParam String pname,
			@RequestParam Integer pcount,
			@RequestParam Integer pprice) {
		
		//trace,debug,info,warn,error
		log.info("pid:{},pname:{},pcount:{},pprice:{}",pid,pname,pcount,pprice);
		
		return "product/productDetail";
	}
	
	@PostMapping("")
	public String product3(
							@ModelAttribute ProductDTO productDTO,
							Model model) {
		//trace,debug,info,warn,error
		log.info("pid:{},pname:{},pcount:{},pprice:{}",
				productDTO.getPid(),productDTO.getPname(),
				productDTO.getPcount(),productDTO.getPprice());
		//log.info("productdto:{}",productDTO.toString());
		
		ProductDTO storedProductDTO = productSVC.createProduct(productDTO);
		model.addAttribute("product", storedProductDTO);
		return "product/productDetail";
	}
	
	//상품상세
	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("pid")String pid, 
															Model model) {
		
		ProductDTO productDTO = productSVC.findProduct(pid);
		model.addAttribute("productDTO",productDTO);
		return "product/productDetail";
	}
	
	//상품상세
	@GetMapping("/productDetail/{pid}")
	public String productDetail2(@PathVariable("pid") String pid, 
																Model model) {
		
		ProductDTO productDTO = productSVC.findProduct(pid);
		model.addAttribute("productDTO",productDTO);
		return "product/productDetail";
	}
	
	//상품수정폼출력
	@GetMapping("/modifyProductForm")
	public String modify() {
		return "product/modifyProductForm";
	}
}

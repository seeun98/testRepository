package com.hyundai.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyundai.domain.Criteria;
import com.hyundai.domain.PageDTO;
import com.hyundai.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product/*")
@AllArgsConstructor
public class ProductController {
	private ProductService productService;
	
	//product 전체상품	
	@GetMapping("/productList")
	public String productList(Criteria cri, @RequestParam("pageNum") Integer pageNum, @RequestParam("amount") Integer amount, Model model) throws Exception {
		
		System.out.println("@@@@@@@@@@@@@@@CRI넘어온 pageNUM" + pageNum);
		System.out.println("@@@@@@@@@@@@@@@CRI넘어온 Amount" + amount);
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		int total = productService.getTotalCount();
		System.out.print(total);
		model.addAttribute("productList", productService.getListWithPaging(cri));
		PageDTO pageDTO = new PageDTO(cri, total);
		System.out.println(pageDTO.getEndPage());
		model.addAttribute("pageMaker", pageDTO);
		return "product/productList";
	}
	
	//product Category
	@GetMapping("/productCategory")
	public String productCategory(Criteria cri, @RequestParam("productCategory") String productCategory, @RequestParam("pageNum") Integer pageNum, @RequestParam("amount") Integer amount, Model model) throws Exception {
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		int total = productService.getCategoryTotalCount(productCategory);
		System.out.println(total);
		model.addAttribute("productList", productService.getCategoryListWithPaging(cri, productCategory));
		PageDTO pageDTO = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageDTO);
		
		return "product/productList";
	}
	
	//product NewBest
	@GetMapping("/productNewBest")
	public String productNewBest(Criteria cri, @RequestParam("pageNum") Integer pageNum, @RequestParam("amount") Integer amount, Model model) {
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		int total = productService.getNewBestTotalCount();
		System.out.println("newbest 개수 ??? " + total);
		model.addAttribute("productList", productService.getNewBestListWithPaging(cri));
		PageDTO pageDTO = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageDTO);
		
		return "product/productNewBest";
	}
	
	
	//product NEWBESTTEST
	@GetMapping("/newBest")
	public String newBestTest() {
		return "product/productNewBest";
	}
}
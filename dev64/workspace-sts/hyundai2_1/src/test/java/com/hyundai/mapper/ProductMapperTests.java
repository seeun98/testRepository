package com.hyundai.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyundai.domain.Criteria;
import com.hyundai.domain.PageDTO;
import com.hyundai.domain.productDetailVO;
import com.hyundai.domain.productVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@NoArgsConstructor
public class ProductMapperTests {
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	
	//product 전체 조회
	@Test 
	public void testGetListWithPaging() {
		log.info("getListWith paging");
		int count = mapper.getTotalCount();
		Criteria cri = new Criteria(2,9);
		PageDTO pageDTO = new PageDTO(cri, count);
		List<productVO> list = mapper.getListWithPaging(cri);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	//product 전체 개수
	@Test
	public void testGetTotalCount() {
		log.info("getTotalCount");
		int count = mapper.getTotalCount();
		System.out.println(count);
	}
	
	//product Category 조회
	@Test
	public void testCategoryListWithPaging() {
		log.info("getCategoryListWith paging");
		List<productVO> list = mapper.getCategoryListWithPaging(new Criteria(), "스킨케어");
		for(int i = 0; i < list.size(); i++) {
			log.info(list.get(i));
		}
	}
	
	//product Category 전체 개수
	@Test
	public void testCategoryTotalCount() {
		log.info("getCategoryListWith paging");
		int count = mapper.getCategoryTotalCount("스킨케어");
		log.info(count);
	}
	
	
	//product newBest 조회
	@Test
	public void testNewBestListWithPaging() {
		log.info("getNewBestWith Paging");
		
		List<productVO> list = mapper.getNewBestListWithPaging(new Criteria());
		for(int i = 0; i < list.size(); i++) {
			log.info(list.get(i));
		}
	}
	
	//product Detail 조회
	@Test
	public void testGetProductDetail() {
		System.out.println("getProductDetail");
		
		List<productDetailVO> list = mapper.getProductDetail(1L);
		for(int i = 0; i < list.size(); i++) {
			log.info(list.get(i));
		}
	}
	
	//productDetailClick +1
	@Test
	public void testGetProductDetailCount() throws Exception {
		log.info("getProductDetailCount");
		int count = mapper.getProductDetailCount(1L);
		log.info(count);
	}
}

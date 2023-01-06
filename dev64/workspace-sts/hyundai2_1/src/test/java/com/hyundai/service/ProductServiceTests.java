package com.hyundai.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyundai.domain.Criteria;
import com.hyundai.domain.productVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private ProductService service;
	
	@Test
	public void testGetPagingList() throws Exception {
		
		List<productVO> list = service.getListWithPaging(new Criteria(1,9));
	
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testGetTotalCount() throws Exception {
		int count = service.getTotalCount();
		System.out.print(count);
	}
	
	@Test
	public void testGetCategoryList() {

		List<productVO> list = service.getCategoryListWithPaging(new Criteria(1,9), "스킨케어");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testCategoryCount() {
		System.out.println(service.getCategoryTotalCount("스킨케어"));
		
	}
	
	@Test
	public void testNewBestList() {
		List<productVO> list = service.getNewBestListWithPaging(new Criteria(1,9));
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
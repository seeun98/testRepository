package com.hyundai.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyundai.domain.Criteria;
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
	
	@Test 
	public void testGetListWithPaging() {
		log.info("getListWith paging");
		List<productVO> list = mapper.getListWithPaging(new Criteria(1, 9));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testGetTotalCount() {
		log.info("getTotalCount");
		int count = mapper.getTotalCount();
		System.out.println(count);
	}
}

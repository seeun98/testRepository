package com.hyundai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hyundai.domain.Criteria;
import com.hyundai.domain.productDetailVO;
import com.hyundai.domain.productVO;

public interface ProductMapper {
	
	public List<productVO> getListWithPaging(Criteria cri); // 파라미터 받아서 페이징 보여줌 -> xml 부를 것
	
	public int getTotalCount();
	
	public List<productVO> getCategoryListWithPaging(@Param("cri") Criteria cri, @Param("productCategory") String productCategory);
	
	public int getCategoryTotalCount(@Param("productCategory") String productCategory);
	
	public List<productVO> getNewBestListWithPaging(Criteria cri);
	
	public int getNewBestTotalCount();
	
	public List<productDetailVO> getProductDetail(@Param("productId") Long productId);
	
	public int getProductDetailCount(Long productId);
}

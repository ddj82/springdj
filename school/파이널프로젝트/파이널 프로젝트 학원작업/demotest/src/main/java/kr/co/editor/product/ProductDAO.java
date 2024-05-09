package kr.co.editor.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public int getPnoMaxNum() {
		return mybatis.selectOne("ProductMapper.getPnoMaxNum");
	}
	
	public int insertProduct(ProductVO vo) {
		return mybatis.insert("ProductMapper.insertProduct", vo);
	}
	
	public List<ProductVO> getProductList(){
		return mybatis.selectList("ProductMapper.getProductList");
	}
	
	public ProductVO getProductOne(int pno){
		return mybatis.selectOne("ProductMapper.getProductOne", pno);
	}

}

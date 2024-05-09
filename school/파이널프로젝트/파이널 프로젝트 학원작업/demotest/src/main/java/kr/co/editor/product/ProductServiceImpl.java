package kr.co.editor.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO dao;

	@Override
	public int getPnoMaxNum() {
		return dao.getPnoMaxNum();
	}

	@Override
	public int insertProduct(ProductVO vo) {
		return dao.insertProduct(vo);
	}

	@Override
	public List<ProductVO> getProductList() {
		return dao.getProductList();
	}

	@Override
	public ProductVO getProductOne(int pno) {
		return dao.getProductOne(pno);
	}

}

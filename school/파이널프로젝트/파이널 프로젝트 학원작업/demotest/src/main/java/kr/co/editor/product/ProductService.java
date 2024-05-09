package kr.co.editor.product;

import java.util.List;

public interface ProductService {
	public int getPnoMaxNum();
	public int insertProduct(ProductVO vo);
	public List<ProductVO> getProductList();
	public ProductVO getProductOne(int pno);
}

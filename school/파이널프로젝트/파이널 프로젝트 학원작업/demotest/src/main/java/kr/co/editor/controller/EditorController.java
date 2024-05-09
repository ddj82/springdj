package kr.co.editor.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.editor.product.ProductService;
import kr.co.editor.product.ProductVO;

@Controller
public class EditorController {
	
	@Autowired
	ProductService svc;
	
	@RequestMapping("/proDetailInsert.ko")
	public String fileWriter(ProductVO vo) throws IllegalStateException, IOException {
		MultipartFile uplodFile = vo.getUploadFile();
		//상대 경로 추가 시 realPath 추가
	    //realPath = request.getSession().getServletContext().getRealPath("/img/");
		if(!(uplodFile == null || uplodFile.isEmpty())) {
			String thumbnail = uplodFile.getOriginalFilename(); 
			vo.setPthumbnail(thumbnail);
			uplodFile.transferTo(new File("C:/swork/demotest/src/main/webapp/resources/thumbnail/"+thumbnail));
		}
		
		int pno = svc.getPnoMaxNum();
		String filename = "pno" + pno +".jsp";
		vo.setP_no(pno);
		vo.setPfilename(filename);
		
		File file = new File("C:/swork/demotest/src/main/webapp/WEB-INF/product");
		if(!file.exists()) {file.mkdirs();}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file+"/"+filename);
			fw.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\" %>");
			fw.write(vo.getPdetail());
			fw.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		svc.insertProduct(vo);
		
		System.out.println("파일에 저장되었습니다.");
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/productList.ko")
	public String pList(Model model) {
		model.addAttribute("pList", svc.getProductList());
		return "product/productList";
	}
	
	@RequestMapping("/updateForm.ko")
	public String pUpdateForm(@RequestParam int pno , Model model) {
		model.addAttribute("pOne", svc.getProductOne(pno));
		return "product/productUpdate";
	}
	
	@RequestMapping("/productDetail.ko")
	public String pOne(@RequestParam int pno ,Model model) {
		model.addAttribute("pOne", svc.getProductOne(pno));
		return "product/productOne";
	}
	
	@RequestMapping("/productDetailpage.ko")
	public String productDetailpage(@RequestParam int p_no) {
		return "product/pno"+p_no;
	}

}

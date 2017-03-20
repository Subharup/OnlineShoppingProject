package com.niit.shopping.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shopping.dao.CategoryDao;
import com.niit.shopping.dao.ProductDao;
import com.niit.shopping.model.Category;
import com.niit.shopping.model.Product;

@Controller
public class ProductController {
	@Autowired
	CategoryDao categoryDao;
	@Autowired
    ProductDao  productDao;
    
	@RequestMapping("/header")  
	public ModelAndView viewusers(){  
	    List<Category> list=categoryDao.getAllCatagory();
	    return new ModelAndView("header","categoryList",list);  
	}  

	@RequestMapping("/showProducts/{subCategoryId}")  
	public ModelAndView showProducts(@PathVariable("subCategoryId")  int subCategoryId){  
	    List<Product> list=productDao.getProductBySubCategory(subCategoryId);
	    return new ModelAndView("showProducts","productList",list);  
	}  
	@RequestMapping("/viewProduct/{productId}")  
	public ModelAndView viewProduct(@PathVariable("productId")  int productId){  
	    Product pr=productDao.getProductByProductId(productId);
	    return new ModelAndView("viewProduct","product",pr);  
	}  
	@RequestMapping("/AdminManageProduct")
	public ModelAndView AdminManageProduct(){
		ModelAndView CartDetails=new ModelAndView("AdminManageProduct");
		return CartDetails;
	}
	@RequestMapping("/AdminViewProduct")
	public ModelAndView AdminViewProduct(@PathVariable("productId")  int productId){
		ModelAndView AdminViewProduct=new ModelAndView("AdminViewProduct");
		return AdminViewProduct;
	}
	
	@RequestMapping(value="/AdminAddProduct",method = RequestMethod.POST) 
    public ModelAndView save(@ModelAttribute("product") Product product , HttpServletRequest request, 
    			@RequestParam("file") MultipartFile file){  


    	
    		byte fileBytes[];
    		FileOutputStream fos = null;
    		
    		String fileName = "";
    		String productImage = "";
    		ServletContext context = request.getServletContext();
    		String realContextPath = context.getRealPath("/");
    		String un = product.getProductName();
    		if (file != null){
    			fileName = realContextPath + "/resources/img/" + un + ".jpg";
    			productImage = "resources/img/" + un + ".jpg";
    			System.out.println("===" + fileName + "===");
    			File fileobj = new File(fileName);
    			try{
    				fos = new FileOutputStream(fileobj);
    				fileBytes = file.getBytes();
    				fos.write(fileBytes);
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
   
    		product.setProductImage(productImage);
        	productDao.addProduct(product);
            return new ModelAndView("redirect:/AdminViewProduct");//will redirect to AdminViewProduct request mapping  
      
    }  
	@RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.POST)  
	public ModelAndView delete(@PathVariable int id){ 
		System.out.println("delete is called");
	   productDao.deleteProduct(id);
	    return new ModelAndView("redirect:/AdminViewProduct");  
	}

}

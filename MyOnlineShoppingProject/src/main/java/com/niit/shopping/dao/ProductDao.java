package com.niit.shopping.dao;
import java.util.List;

import com.niit.shopping.model.*;
public interface ProductDao {

	List<Product>   getProductBySubCategory(int subCategoruId);
	Product getProductByProductId(int productId);
	public void addProduct(Product product1);
	void deleteProduct(int id);
}

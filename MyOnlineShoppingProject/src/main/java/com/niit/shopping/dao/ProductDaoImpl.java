package com.niit.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.Category;
import com.niit.shopping.model.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	public List<Product> getProductBySubCategory(int subCategoryId) {
		// TODO Auto-generated method stub
		
		Session session = getSession();

		Query query = session.createQuery("from Product where  productSubCategory.subcategoryId=?");
		
		query.setInteger(0, subCategoryId);
		List<Product> productList = query.list();

		return productList;
		
	}
	
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		
		Session session = getSession();

		Query query = session.createQuery("from Product where productId=?");
		
		query.setInteger(0, productId);
	List<Product> product = query.list();
	
	if (product!=null &&  ! product.isEmpty())
	

		return product.get(0);
	
	else return null;
		
	}

	public void addProduct(Product product1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String s = product1.getProductName();

		session.save(product1);

		session.flush();

		session.close();

		
	}	
}

package com.rudra.jdbcdemo.dao;

import java.util.List;

import com.rudra.jdbcdemo.model.Product;

public interface ProductRepository {
	Product findById(int i);

	List<Product> findAll();

	boolean delete(Product Product);

	boolean update(Product Product);

	boolean create(Product Product);

	boolean createWithNamedParameters(Product product);

	boolean createWithJdbcInsert(Product product);

	Product getProductUsingStoredProcedure(int id);
}

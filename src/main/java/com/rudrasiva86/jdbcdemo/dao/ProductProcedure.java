package com.rudrasiva86.jdbcdemo.dao;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.rudrasiva86.jdbcdemo.model.Product;

public class ProductProcedure extends StoredProcedure {
	public ProductProcedure(DataSource dataSource, String procedureName) {
	      super(dataSource,procedureName);
	      declareParameter(new SqlParameter("id_i", Types.INTEGER));
	      declareParameter(new SqlOutParameter("name_o", Types.VARCHAR));
	      declareParameter(new SqlOutParameter("desc_o", Types.VARCHAR));
	      compile();
	   }
	   public Product execute(Integer id){
	      Map<String, Object> out = super.execute(id);
	      Product product = new Product();
	      product.setId(id);
	      product.setName((String) out.get("name_o"));
	      product.setDescription((String)out.get("desc_o"));
	      return product;  	
	   }
}

package com.ecom.mybio.services;

import java.util.List;

import com.ecom.mybio.entites.Category;

public interface CategoryMetier {
	public Category addCategory(Category cat);

	public List<Category> listCategory();

}

package com.ecom.mybio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.mybio.entites.Category;
import com.ecom.mybio.repository.CategoryRepository;

@Service
public class CategoryMetierImpl implements CategoryMetier {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category cat) {
		Category newCat = categoryRepository.save(cat);
		return newCat;
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}

}

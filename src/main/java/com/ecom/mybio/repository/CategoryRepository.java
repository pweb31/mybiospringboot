package com.ecom.mybio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.mybio.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

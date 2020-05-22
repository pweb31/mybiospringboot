package com.ecom.mybio.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.mybio.entites.Category;
import com.ecom.mybio.entites.Product;
import com.ecom.mybio.services.CategoryMetier;
import com.ecom.mybio.services.ProductMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PhotoController {
	@Autowired
	private CategoryMetier catMetier;
	@Autowired
	private ProductMetier prodMetier;

	@GetMapping("/category/{idCategory}")
	public ResponseEntity photoCharacter(@PathVariable Long idCategory) {
		if (idCategory == null) {
			return ResponseEntity.badRequest().body("Cannot get category picture with null ID");
		}
		Category categ = catMetier.recupererCategoryParSonId(idCategory);
		if (categ == null) {
			return ResponseEntity.notFound().build();
		}
		if (categ.getImgCategory() == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF).contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(new ByteArrayInputStream(categ.getImgCategory())));
	}

	@GetMapping("/user/{idUser}")
	public ResponseEntity photoUser(@PathVariable Long idProduit) {
		if (idProduit == null) {
			return ResponseEntity.badRequest().body("Cannot get product picture with null ID");
		}
		Product prod = prodMetier.recupererProduitParSonId(idProduit);
		if (prod == null) {
			return ResponseEntity.notFound().build();
		}
		if (prod.getImgProduit() == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF).contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(new ByteArrayInputStream(prod.getImgProduit())));
	}
}

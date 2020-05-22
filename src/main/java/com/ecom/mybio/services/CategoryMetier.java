package com.ecom.mybio.services;

import java.util.List;

import com.ecom.mybio.entites.Category;
import com.ecom.mybio.entites.Product;

public interface CategoryMetier {

	// Ajouter une category
	public Category ajouterCategory(Category c);

	// Lister toutes les categories
	public List<Category> listCategories();

	// Recupérer une categorie par son id
	public Category recupererCategoryParSonId(Long id);

	// Recupérer une categorie
	public Category recupererCategory(Category c);

	// Modifier une categorie
	public Category modifierCategory(Category categorieDetail);

	// Supprimer une categorie
	public void SupprimerCategory(Category c);

	// Recuperer tous les produits d'une catégorie
	public List<Product> recuperProduitsCategorie(Category cat);

}

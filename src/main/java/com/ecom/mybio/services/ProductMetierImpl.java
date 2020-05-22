package com.ecom.mybio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.mybio.entites.Product;
import com.ecom.mybio.repository.ProductRepository;

@Service
public class ProductMetierImpl implements ProductMetier {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product ajouterProduit(Product p) {
		return productRepository.save(p);
	}

	@Override
	public List<Product> listProduits() {
		return productRepository.findAll();
	}

	@Override
	public Product recupererProduitParSonId(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public Product recupererProduit(Product p) {
		return productRepository.getOne(p.getId());
	}

	@Override
	public Product modifierProduit(Product produitDetail) {
		Product prod = recupererProduit(produitDetail);

		prod.setNom(produitDetail.getNom());
		prod.setPrix(produitDetail.getPrix());
		prod.setDescription(produitDetail.getDescription());

		Product produitUpdate = ajouterProduit(prod);

		return produitUpdate;
	}

	@Override
	public void SupprimerProduit(Product p) {
		productRepository.deleteById(p.getId());

	}

}

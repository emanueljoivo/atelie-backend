package br.edu.ufcg.ccc.daca.backend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.ccc.daca.backend.entity.Product;
import br.edu.ufcg.ccc.daca.backend.repository.ProductRepository;

import javax.validation.constraints.NotNull;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}


	@Override
	public Collection<Product> listAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
    public Optional<Product> findProductById(Long id) { return this.productRepository.findById(id); }

    @Override
	@NotNull
    public Collection<Product> findProductsByCategory(String category) {
		return this.productRepository.findAllByCategory(category).get();
    }

	@Override
	public boolean hasProduct(Long id) {
		return this.productRepository.existsById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		if (hasProduct(id))
			this.productRepository.deleteById(id);
	}
}
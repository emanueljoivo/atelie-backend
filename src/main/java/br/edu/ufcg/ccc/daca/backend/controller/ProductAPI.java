package br.edu.ufcg.ccc.daca.backend.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import br.edu.ufcg.ccc.daca.backend.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ufcg.ccc.daca.backend.entity.Product;
import br.edu.ufcg.ccc.daca.backend.service.ProductService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/product")
public class ProductAPI {

	private ProductService productService;

	@Autowired
	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<Collection<Product>> getProductByCategory(@RequestParam String category) {
		Collection<Product> productsAboveCategory = this.productService.findProductsByCategory(category);

		if (productsAboveCategory.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productsAboveCategory);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductById(@PathVariable String id) {
		final Long productId;

		try { productId = Long.parseLong(id); } catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false,
					"The product ID is invalid."));
		}

		Optional<Product> p = this.productService.findProductById(productId);

		if (!p.isPresent()) {ResponseEntity.notFound().build();}

		return ResponseEntity.ok(new ApiResponse(true, "Sucess! Product found."));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Collection<Product>> listAllProducts() {
		Collection<Product> allProducts = this.productService.listAllProducts();

		if (allProducts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<>(allProducts, OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {

	    if (product.getId() != null) return ResponseEntity.unprocessableEntity().body(new ApiResponse(false,
				"The format of this product is invalid.", METHOD_NOT_ALLOWED.value()));

        try { this.productService.saveProduct(product); } catch (Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false,
					"Product not saved", INTERNAL_SERVER_ERROR.value()));
        }

		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true,
				"Product created successfully!"));
	}

	@PostMapping(value = "/save-all")
	public ResponseEntity<List<Product>> saveAllProducts(@RequestBody List<Product> products) {

		try {
			this.productService.saveAllProducts(products);
		} catch (Exception e){
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(products);
	}

	@PutMapping(value = "/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        if ((product.getId() == null) ||
                (!this.productService.hasProduct(product.getId()))) {
            return ResponseEntity.notFound().build();
        }

        try {
            this.productService.saveProduct(product);
        } catch (Exception e) { return ResponseEntity.unprocessableEntity().body(
        		new ApiResponse(false, "Product not saved",
						INTERNAL_SERVER_ERROR.value())
		); }

		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true,
				"Product updated successfully!", CREATED.value()));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        final Long productId;

        try { productId = Long.parseLong(id); } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false,
					"The product ID is invalid."));
        }

        if (!this.productService.hasProduct(productId)) {
            return ResponseEntity.notFound().build();
        }

        try { this.productService.deleteProduct(productId); } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false,
					"Product could not be deleted.", INTERNAL_SERVER_ERROR.value()));
        }

        return ResponseEntity.ok(new ApiResponse(true, "Product deleted successfully!"));
    }
}
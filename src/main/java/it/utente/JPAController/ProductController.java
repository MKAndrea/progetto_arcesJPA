package it.utente.JPAController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.utente.crud.ProductCrud;
import it.utente.entity.Product;
import it.utente.repository.ProductRepository;
@RestController
@RequestMapping("/api")
public class ProductController {
	 @Autowired
	    private ProductCrud productcrud;
	
	
	@GetMapping(value="/allProduct",produces="application/json")
	    public List<Product> getAllProducts() {
	        return productcrud.getAllProducts();
	    }

	    @GetMapping("/findProduct/{id}")
	    public Product getProductById(@PathVariable int id) {
	        return productcrud.getProductById(id);
	    }

	    @PostMapping("/upsertProduct")
	    public Product upsertProduct(@RequestBody Product product) {
	        return productcrud.upsertProduct(product);
	    }

	    @DeleteMapping("/DeleteProduct/{id}")
	    public void deleteProduct(@PathVariable int id) {
	    	productcrud.deleteProduct(id);
	    }
//	 @GetMapping(value="/allProduct",produces="application/json")
//	 public List<Product> allProduct() throws Exception {
//		 return repository.findAll();
//	 }
//	
//	 @GetMapping(value="/findproduct/{id}",produces="application/json")
//	public Optional<Product> findproductbyId(@PathVariable("id") Integer id) throws Exception {
//	return  repository.findById(id);
//	}
}

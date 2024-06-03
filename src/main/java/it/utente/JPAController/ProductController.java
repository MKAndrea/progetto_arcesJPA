package it.utente.JPAController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.utente.entity.Product;
import it.utente.repository.ProductRepository;
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	 private ProductRepository repository;
	 
	 @RequestMapping(value="/findproduct",method=RequestMethod.GET,produces="application/json")
	 public ResponseEntity<List<Product>> findproduct() throws Exception {
		 List<Product> productList = repository.findAll();
		  if(productList.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    } else {
		        return new ResponseEntity<>(productList, HttpStatus.OK);
		    }
	 }
	
	@RequestMapping(value="/findproduct/{id}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Product>  findproduct(@PathVariable("id") Integer id) throws Exception {
	 Optional<Product> res=repository.findById(id);
	 return res.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
	           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

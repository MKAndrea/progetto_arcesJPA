package it.utente.JPAController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import it.utente.entity.Shop;
import it.utente.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;




@RestController
@RequestMapping("/api")
public class DeliveryController {
 @Autowired
 private ShopRepository repository;
 
 @GetMapping(value="/allShops",produces="application/json")
 public List<Shop> allShops() throws Exception {
	 return repository.findAll();
 }
 
 @GetMapping(value="/findShops/{id}",produces="application/json")
	public Optional<Shop> findShopById(@PathVariable("id") Integer id) throws Exception {
	return  repository.findById(id);
	}
}

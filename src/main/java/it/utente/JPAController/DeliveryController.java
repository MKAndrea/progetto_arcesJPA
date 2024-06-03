package it.utente.JPAController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.utente.entity.Shop;
import it.utente.repository.ShopRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api")
public class DeliveryController {
 @Autowired
 private ShopRepository repository;
 
@RequestMapping(value="/findshop/{id}",method=RequestMethod.GET,produces="application/json")
public ResponseEntity<Shop>  findShop(@PathVariable("id") Integer id) throws Exception {
 Optional<Shop> res=repository.findById(id);
 return res.map(shop -> new ResponseEntity<>(shop, HttpStatus.OK))
           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
}

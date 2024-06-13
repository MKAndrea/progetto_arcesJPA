package it.utente.JPAController;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import it.utente.crud.ShopCrud;
import it.utente.entity.Shop;
import it.utente.entity.Utente;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("/api")
public class DeliveryController {
	
 @Autowired
 private ShopCrud shopcrud;
 
 
 @GetMapping(value="/allShop",produces="application/json")
 public List<Shop> getAllProducts() {
     return shopcrud.getAllShops();
 }

 @GetMapping("/findShop/{id}")
 public Shop getShopById(@PathVariable int id) {
     return shopcrud.getShopById(id);
 }

 @PostMapping("/upsertShop")
 public Shop upsertShop(@RequestBody Shop shop) {
     return shopcrud.upsertShop(shop);
 }
 
 //@DeleteMapping uso il delete se voglio cancellare con postman
 @GetMapping("/DeleteShop/{id}")
 public void deleteShop(@PathVariable int id) {
	 shopcrud.deleteShop(id);
 }
 
}

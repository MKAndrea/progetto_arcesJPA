package it.utente.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.utente.entity.Shop;
import it.utente.repository.ShopRepository;

@Service
public class ShopCrud {
	  @Autowired
	    private ShopRepository repository;
	  
	public List<Shop> getAllShops() {
      return repository.findAll();
  }

  public Shop getShopById(int id) {
      return repository.findById(id).orElse(null);
  }

  // Metodo upsert
  public Shop upsertShop(Shop shop) {
      Optional<Shop> existingShop = repository.findById(shop.getId());

      if (existingShop.isPresent()) {
          // Aggiorna il prodotto esistente
    	  Shop updateShop = existingShop.get();
    	  updateShop.setDenominazione(shop.getDenominazione());
    	  updateShop.setIndirizzo(shop.getIndirizzo());
          return repository.save(updateShop);
      } else {
          // Inserisce un nuovo prodotto
          return repository.save(shop);
      }
  }

  public void deleteShop(int id) {
  	repository.deleteById(id);
  }
}

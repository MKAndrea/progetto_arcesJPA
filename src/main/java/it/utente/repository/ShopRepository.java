package it.utente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.utente.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

	 // Adjusted method name to follow Spring Data naming conventions
    List<Shop> findByDenominazione(String denominazione);

    // Corrected native query syntax
    @Query(value = "SELECT * FROM shops WHERE denominazione LIKE :de", nativeQuery = true)
    List<Shop> findByNameLike(@Param("de") String denominazione);
}

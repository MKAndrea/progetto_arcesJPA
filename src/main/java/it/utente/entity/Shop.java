package it.utente.entity;

import jakarta.persistence.*;

@Entity
@Table(name="shops")
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idshops")
	private int id;
	@Column(name="denominazione")
	private String denominazione;
	@Column(name="indirizzo")
	private String indirizzo;

	public Shop() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}

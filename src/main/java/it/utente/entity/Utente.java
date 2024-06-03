package it.utente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class Utente {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)	
@Column(name="idutente")
private int id;	
@Column(name="nome")
private String nome;
@Column(name="cognome")
private String cognome;
@Column(name="username")
private String username;
@Column(name="cellulare")
private String cellulare;
@Column(name="indirizzo")
private String indirizzo;
@Column(name="eta")
private int eta;
@Column(name="password")
private String password;


public Utente() {}

public int getId() {
	return id;
}

public String getNome() {
	return nome;
}
public String getCognome() {
	return cognome;
}
public String getUsername() {
	return username;
}
public String getCellulare() {
	return cellulare;
}
public String getIndirizzo() {
	return indirizzo;
}
public int getEta() {
	return eta;
}

public void setId(int id) {
	this.id = id;
}

public void setNome(String nome) {
	this.nome = nome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public void setUsername(String username) {
	this.username = username;
}

public void setCellulare(String cellulare) {
	this.cellulare = cellulare;
}

public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
}

public void setEta(int eta) {
	this.eta = eta;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}

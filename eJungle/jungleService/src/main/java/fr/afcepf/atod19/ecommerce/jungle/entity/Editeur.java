//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Editeur.java
//  @ Date : 27/12/2013
//  @ Author : 
//
//



package fr.afcepf.atod19.ecommerce.jungle.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Editeur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nom;
	@ManyToOne
	@JoinColumn(name="ref_adresseEditeur")
	private Adresse adresseEditeur;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="editeur")
	private List<Livre> livres;
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Adresse getAdresseEditeur() {
		return adresseEditeur;
	}
	public void setAdresseEditeur(Adresse adresseEditeur) {
		this.adresseEditeur = adresseEditeur;
	}
	
}

package fr.afcepf.atod19.ecommerce.jungle.dao.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Commande;

public interface IDaoCommande extends IGenericDao {
	List<Commande> findCommandeByClient(String userName);
	//List<Commande> findCommandeByAdresse(Long idAdresse);
	void addCommande(Commande uneCommande);
	List<Commande> findAll();
	Commande findCommandeByKey(Long idCommande);
}

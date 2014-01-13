package fr.afcepf.atod19.ecommerce.jungle.services.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Commande;
import fr.afcepf.atod19.ecommerce.jungle.entity.EtatCommande;

public interface IGestionCommande {
	List<Commande> findAll();
	List<Commande> CommandesSelonClient(String userName);
	//List<Commande> commandesSelonAdresse(Long idAdresse);
	void createCommande(Commande uneCommande);
	Commande rechercherCommande(Long idCommande);
	Commande modiferEtatCommande(Commande commande,EtatCommande etat);
}

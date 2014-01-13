package fr.afcepf.atod19.ecommerce.jungle.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoCommande;
import fr.afcepf.atod19.ecommerce.jungle.entity.Commande;
import fr.afcepf.atod19.ecommerce.jungle.entity.EtatCommande;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCommande;

public class GestionCommande implements IGestionCommande {
	@Autowired
	IDaoCommande daoCommande;

	@Override
	public List<Commande> findAll() {
		return daoCommande.findAll();
	}

	@Override
	public List<Commande> CommandesSelonClient(String userName) {
		
		return daoCommande.findCommandeByClient(userName);
	}

	/*@Override
	public List<Commande> commandesSelonAdresse(Long idAdresse) {
		
		return daoCommande.findCommandeByAdresse(idAdresse);
	}*/

	@Override
	public void createCommande(Commande uneCommande) {
		daoCommande.addCommande(uneCommande);

	}

	@Override
	public Commande rechercherCommande(Long idCommande) {
		
		return daoCommande.findCommandeByKey(idCommande);
	}

	@Override
	public Commande modiferEtatCommande(Commande commande, EtatCommande etat) {
		commande.setEtatCommande(etat);
		return daoCommande.updateEntity(commande);
	}

}

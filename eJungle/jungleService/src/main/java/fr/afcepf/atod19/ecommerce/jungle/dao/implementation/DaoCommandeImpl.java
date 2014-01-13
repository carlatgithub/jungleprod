package fr.afcepf.atod19.ecommerce.jungle.dao.implementation;

import java.util.List;




import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoCommande;

import fr.afcepf.atod19.ecommerce.jungle.entity.Client;
import fr.afcepf.atod19.ecommerce.jungle.entity.Commande;


@Component
public class DaoCommandeImpl extends GenericDaoImpl implements IDaoCommande {

	@Override
	public List<Commande> findCommandeByClient(String userName) {
		Client unClient = getEntityManager().find(Client.class, userName);
		return unClient.getCommandes();
	}
	
	@Override
	public Commande findCommandeByKey(Long idCommande) {
		return getEntityByPk(Commande.class, idCommande);
	}

	/*@Override
	public List<Commande> findCommandeByAdresse(Long idAdresse) {
		Adresse adresse = getEntityByPk(Adresse.class, idAdresse);
		return null;
	}*/

	@Override
	public void addCommande(Commande uneCommande) {
		persistNewEntity(uneCommande.getLignesCommande());
		persistNewEntity(uneCommande.getClient());
		persistNewEntity(uneCommande);
		
	}

	@Override
	public List<Commande> findAll() {
		TypedQuery<Commande> query = getEntityManager().createQuery("From Commande ", Commande.class);
		return query.getResultList();
	}
	
	
}

package fr.afcepf.atod19.ecommerce.jungle.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoClient;
import fr.afcepf.atod19.ecommerce.jungle.entity.Client;
import fr.afcepf.atod19.ecommerce.jungle.entity.Commande;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionClient;
@Component
@Transactional
public class GestionClient implements IGestionClient {
	@Autowired
	IDaoClient daoClient;
	
	@Override
	public Client login(String userName, String pwd) {
		return daoClient.findByName(userName, pwd);
	}

	public IDaoClient getDaoClient() {
		return daoClient;
	}

	public void setDaoClient(IDaoClient daoClient) {
		this.daoClient = daoClient;
	}

	@Override
	public List<Client> clientsSelonAdresse(Long idAdresse) {
		return daoClient.findClientByAdresse(idAdresse);
	}

	@Override
	public void ajouterClient(Client unClient) {
		daoClient.persistNewEntity(unClient.getAdresseClient());
		for(Commande uneCommande:unClient.getCommandes())
			daoClient.persistNewEntity(uneCommande);
		daoClient.persistNewEntity(unClient);
		
	}
	
	

}

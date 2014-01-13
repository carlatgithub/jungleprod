package fr.afcepf.atod19.ecommerce.jungle.services.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Client;

public interface IGestionClient {
	Client login(String userName,String pwd);
	List<Client> clientsSelonAdresse(Long idAdresse);
	void ajouterClient(Client unClient);
}

package fr.afcepf.atod19.ecommerce.jungle.dao.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Client;

public interface IDaoClient extends IGenericDao {
	List<Client> findClientByAdresse(Long idAdresse);
	Client findByName(String userName,String pwd);
}

package fr.afcepf.atod19.ecommerce.jungle.dao.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;

public interface IDaoCategorie extends IGenericDao {
	
	List<Categorie> findAllCategorie(); 
	
}

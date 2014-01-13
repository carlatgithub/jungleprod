package fr.afcepf.atod19.ecommerce.jungle.services.implementation;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoCategorie;
import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCategorie;
@Component
@Transactional
public class GestionCategorie implements IGestionCategorie,Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IDaoCategorie daoCategorie;
	@Override
	public List<Categorie> allCategorie() {
		
		return daoCategorie.findAllCategorie();
	}

}

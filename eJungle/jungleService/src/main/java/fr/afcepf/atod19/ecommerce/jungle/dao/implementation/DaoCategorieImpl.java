package fr.afcepf.atod19.ecommerce.jungle.dao.implementation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoCategorie;
import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;

@Component
public class DaoCategorieImpl extends GenericDaoImpl implements IDaoCategorie,Serializable {

	
	private static final long serialVersionUID = 1L;

	@Override
	public List<Categorie> findAllCategorie() {
		TypedQuery<Categorie> query = getEntityManager().createQuery("From Categorie ", Categorie.class);
		List<Categorie> mesCategorie = query.getResultList();
		for(Categorie uneCategorie:mesCategorie)
		{
			uneCategorie.getLivres().size();
		}
		return mesCategorie;
	}



}

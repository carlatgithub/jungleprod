package fr.afcepf.atod19.ecommerce.jungle.dao.implementation;

import java.io.Serializable;
import java.util.List;



import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import fr.afcepf.atod19.ecommerce.jungle.dao.interfaces.IDaoLivre;
import fr.afcepf.atod19.ecommerce.jungle.entity.Auteur;
import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;
import fr.afcepf.atod19.ecommerce.jungle.entity.Editeur;
import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;
@Component
public class DaoLivreImpl extends GenericDaoImpl implements IDaoLivre,Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public List<Livre> getLivreByCategorie(Long idCategorie) {
		Categorie cat = getEntityByPk(Categorie.class, idCategorie);
		cat.getLivres().size();
		return cat.getLivres();
	}

	@Override
	public List<Livre> getLivreByEditeur(Long idEditeur) {
		Editeur edit = getEntityByPk(Editeur.class, idEditeur);
		edit.getLivres().size();
		return edit.getLivres();
	}

	@Override
	public List<Livre> getLivreByAuteur(Long idAuteur) {
		Auteur aut = getEntityByPk(Auteur.class, idAuteur);
		aut.getLivres().size();
		return aut.getLivres();
	}

	@Override
	public Livre getLivreByKey(String numeroISBN) {
		System.out.println("ISBN : " + numeroISBN);
		System.out.println("em : " + getEntityManager());
		Livre unLivre = getEntityManager().find(Livre.class, numeroISBN);
		return unLivre;
	}
	
	@Override
	public List<Livre> rechercheLivreSelonTitre(String titre) {
		System.out.println("titre :" + titre);
		System.out.println("em :" + getEntityManager());
		
		TypedQuery<Livre> query = getEntityManager().createQuery("From Livre as l where l.titre = :nc", Livre.class);
		query.setParameter("nc", titre);
		return query.getResultList();
	}

	@Override
	public List<Livre> getAllLivre() {
		TypedQuery<Livre> query = getEntityManager().createQuery("From Livre ", Livre.class);
		return query.getResultList();
	}

	@Override
	public void creerLivre(Livre unLivre) {
		if(null != unLivre.getCategorie() && null == unLivre.getCategorie().getId())
		{
			persistNewEntity(unLivre.getCategorie());
		}
		if((null != unLivre.getEditeur() && null != unLivre.getEditeur().getAdresseEditeur())
				&& null == unLivre.getEditeur().getAdresseEditeur().getId())
		{
			persistNewEntity(unLivre.getEditeur().getAdresseEditeur());
		}
		if(null != unLivre.getEditeur() && null == unLivre.getEditeur().getId())
		{
			persistNewEntity(unLivre.getEditeur());
		}
		
		for(Auteur unAuteur:unLivre.getAuteurs())
		{
			if(null == unAuteur.getId())
			{
				persistNewEntity(unAuteur);
			}
			
		}
			
		persistNewEntity(unLivre);
		
	}
	
	
	
}

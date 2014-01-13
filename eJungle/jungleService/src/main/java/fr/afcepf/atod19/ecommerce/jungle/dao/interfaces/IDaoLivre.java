package fr.afcepf.atod19.ecommerce.jungle.dao.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;

public interface IDaoLivre extends IGenericDao {
	
	List<Livre> getLivreByCategorie(Long idCategorie);
	List<Livre> getLivreByEditeur(Long idEditeur);
	List<Livre> getLivreByAuteur(Long idAuteur);
	Livre getLivreByKey(String numeroISBN); 
	List<Livre> getAllLivre();
	void creerLivre(Livre unLivre);
	List<Livre> rechercheLivreSelonTitre(String titre);

}

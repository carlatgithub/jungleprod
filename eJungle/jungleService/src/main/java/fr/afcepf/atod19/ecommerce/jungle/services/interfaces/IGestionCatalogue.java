package fr.afcepf.atod19.ecommerce.jungle.services.interfaces;

import java.util.List;

import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;

public interface IGestionCatalogue {
	List<Livre> livresSelonEditeur(Long idEditeur);
	List<Livre> livresSelonAuteur(Long idAuteur);
	List<Livre> livreSelonCategorie(Long idCategorie);
	Livre livreSelonISBN(String numeroIBSN);
	void ajouterLivre(Livre unLivre);
	List<Livre> allLivre();
	List<Livre> rechercherSelonTitre(String titre);
}

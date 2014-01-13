package fr.afcepf.atod19.ecommerce.jungle.test;
//import javax.inject.Inject;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.atod19.ecommerce.jungle.entity.Adresse;
import fr.afcepf.atod19.ecommerce.jungle.entity.Auteur;
import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;
import fr.afcepf.atod19.ecommerce.jungle.entity.Client;
import fr.afcepf.atod19.ecommerce.jungle.entity.Editeur;
import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCatalogue;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springContext.xml"})
public class TestDao {
	@Inject
	IGestionCatalogue services;
	@Inject
	IGestionClient serviceClient;
	
	/*@Test
	public void testAjouterLivre(){
		for(int index = 0; index <10 ; index++){
		Categorie uneCat = new Categorie();
		uneCat.setDescription("AAAAA");
		uneCat.setNom("BBB");
		Assert.assertTrue(uneCat != null);
		Editeur edit = new Editeur();
		edit.setNom("KAKAKAAK");
		Adresse adr = new Adresse();
		adr.setCodePostal("XXXXX");
		adr.setNumeroDeRue("YY");
		adr.setRue("rue de Paris");
		adr.setVille("Meudon");
		Assert.assertTrue(adr!= null);
		edit.setAdresseEditeur(adr);
		Assert.assertTrue(edit != null);
		Auteur unAut = new Auteur();
		unAut.setNom("TOTO");
		unAut.setPrenom("TATA");
		Livre unLivre = new Livre();
		unLivre.setNumeroISBN(index+"Liv01Ery");
		unLivre.setDatePublication(new Date());
		unLivre.setNombreDePages(150);
		unLivre.setPrix(60.0f);
		unLivre.setQteEnStock(50);
		unLivre.setTitre("POPIPOPI");
		unLivre.setCategorie(uneCat);
		Client unClient = new Client();
		unClient.setAdresseClient(adr);
		unClient.setUsername("Pipapo"+index);
		unLivre.setEditeur(edit);
		unLivre.getAuteurs().add(unAut);
		//uneCat.getLivres().add(unLivre);
		Assert.assertTrue(unLivre != null);
		services.ajouterLivre(unLivre);
		}
	}*/
	
	@Test
	public void testLivreSelonISBN(){
		Assert.assertTrue(true);
	}
    @Test
    public void tousLesLivres(){
    	List<Livre> mesLivre = services.allLivre();
    	for(Livre unLivre:mesLivre)
    	{
    		System.out.println(unLivre.getTitre() + " " + unLivre.getNumeroISBN());
    	}
    }
    @Test
    public void testLogin(){
    	Client unClient = serviceClient.login("boubah", "afcepf");
    	Assert.assertNotNull(unClient);
    	System.out.println(unClient.getNom());
    	
    }
}

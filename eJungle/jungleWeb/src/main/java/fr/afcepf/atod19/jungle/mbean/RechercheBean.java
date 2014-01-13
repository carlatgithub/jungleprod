package fr.afcepf.atod19.jungle.mbean;


import java.io.Serializable;  
import java.util.List;  

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCatalogue;


@ManagedBean(name="rechercheBean")
@SessionScoped
public class RechercheBean implements Serializable {
	
	  private static final long serialVersionUID = 1L;
	  
	   @ManagedProperty(value = "#{gestionCatalogue}")
	   private IGestionCatalogue serviceGestionCatalogue;
	 
       private List<Livre> livres; // results  
	   private Livre selectedLivre;
	   private String pattern; // pattern to search for in Livre titles
	   
	   public RechercheBean() {  
	    }
	   
	   public String search() {
		  livres = serviceGestionCatalogue.rechercherSelonTitre(this.pattern);
		  System.out.println(livres.size());
		  return "resultatsRecherche";
	   }
	      
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

		public IGestionCatalogue getServiceGestionCatalogue() {
			return serviceGestionCatalogue;
		}

		  public void setServiceGestionCatalogue(IGestionCatalogue serviceGestionCatalogue) {
			this.serviceGestionCatalogue = serviceGestionCatalogue;
		  } 
	      public Livre getSelectedLivre() {  
	        return selectedLivre;  
	      }  
	  
	     public void setSelectedLivre(Livre selectedLivre) {  
	        this.selectedLivre = selectedLivre;  
	     }  
	  
	    public List<Livre> getLivres() {  
	        return livres;  
	    }
	
	}
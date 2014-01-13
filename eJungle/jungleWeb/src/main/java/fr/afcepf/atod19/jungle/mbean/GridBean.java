package fr.afcepf.atod19.jungle.mbean;



import java.io.Serializable;  
import java.util.ArrayList;
import java.util.List;  

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.afcepf.atod19.ecommerce.jungle.entity.LigneCommande;
import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCatalogue;
  
@ManagedBean(name="gridBean")
@SessionScoped
public class GridBean implements Serializable {
	
	   @ManagedProperty(value = "#{gestionCatalogue}")
	   private IGestionCatalogue serviceGestionCatalogue;
	   private int qteCde;
	   private static final long serialVersionUID = 1L;
       private List<Livre> livres;  
	   private Livre selectedLivre;
	   private List<LigneCommande> monpanier;
	   
	 public List<LigneCommande> getMonpanier() {
		return monpanier;
	}

	public void setMonpanier(List<LigneCommande> monpanier) {
		this.monpanier = monpanier;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@PostConstruct
	   public void init()
	   {
		   livres = serviceGestionCatalogue.allLivre();  
		   
		   for(Livre unLivre:livres)
		   {
			   System.out.println(unLivre.getTitre() + " " + unLivre.getNumeroISBN());
		   }
	   }
	  
	   public GridBean() {  
	    	monpanier = new ArrayList<LigneCommande>();
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

		public int getQteCde() {
			return qteCde;
		}

		public void setQteCde(int qteCde) {
			this.qteCde = qteCde;
		}  
	  
		public void ajouter(ActionEvent event){
			LigneCommande lCde = new LigneCommande();
			String numIsbn = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("livreSelected");
			selectedLivre = new Livre();
			selectedLivre = serviceGestionCatalogue.livreSelonISBN(numIsbn);
			lCde.setLivre(selectedLivre);
			lCde.setQuantite(qteCde);
			monpanier.add(lCde);
		}
	}  

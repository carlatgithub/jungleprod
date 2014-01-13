package fr.afcepf.atod19.jungle.mbean;

import java.io.Serializable;
import java.util.List;





import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.afcepf.atod19.ecommerce.jungle.entity.Categorie;
import fr.afcepf.atod19.ecommerce.jungle.entity.Livre;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCatalogue;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionCategorie;

@ManagedBean(name = "categoryMenuBean")
@SessionScoped
public class CategoryMenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{gestionCategorie}")
	private IGestionCategorie serviceGestionCategorie;
	
	@ManagedProperty(value="#{gestionCatalogue}")
	private IGestionCatalogue serviceCatalogue;
	private List<Livre> lesLivres; 
	
    public void setLivreByCategorie(Long idCategorie){
		   setLesLivres(serviceCatalogue.livreSelonCategorie(idCategorie));
	   }
	public IGestionCatalogue getServiceCatalogue() {
		return serviceCatalogue;
	}
	public void setServiceCatalogue(IGestionCatalogue serviceCatalogue) {
		this.serviceCatalogue = serviceCatalogue;
	}
	public List<Livre> getLesLivres() {
		return lesLivres;
	}
	public void setLesLivres(List<Livre> lesLivres) {
		this.lesLivres = lesLivres;
	}
	@ManagedProperty(value="#{gridBean}")
	private GridBean grid;
	
	
	public GridBean getGrid() {
		return grid;
	}

	public void setGrid(GridBean grid) {
		this.grid = grid;
	}

	private List<Categorie> categories;
	

	
	@PostConstruct
	public void init()
	{
		categories = serviceGestionCategorie.allCategorie();
		  lesLivres = serviceCatalogue.allLivre();  

   }
	
	public IGestionCategorie getServiceGestionCategorie() {
		return serviceGestionCategorie;
	}

	public void setServiceGestionCategorie(IGestionCategorie serviceGestionCategorie) {
		this.serviceGestionCategorie = serviceGestionCategorie;
	}

	public CategoryMenuBean() {
		
	}


	
	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public void changeCategory(ActionEvent event)
	{
		String test = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("categorieChoisie");
		this.setLivreByCategorie(Long.parseLong(test));
		
	}
	
	
}

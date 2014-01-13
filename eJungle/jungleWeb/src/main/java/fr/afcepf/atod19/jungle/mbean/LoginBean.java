package fr.afcepf.atod19.jungle.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.afcepf.atod19.ecommerce.jungle.entity.Client;
import fr.afcepf.atod19.ecommerce.jungle.services.interfaces.IGestionClient;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	@ManagedProperty(value="#{gestionClient}")
	IGestionClient servicesClient;
	
	private String userName;
	private String password;
	private Client unClient;
	
	public IGestionClient getServicesClient() {
		return servicesClient;
	}
	public void setServicesClient(IGestionClient servicesClient) {
		this.servicesClient = servicesClient;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client getUnClient() {
		return unClient;
	}
	public void setUnClient(Client unClient) {
		this.unClient = unClient;
	}
	
	public String login(){
		if(userName != null && password != null)
		{
			System.out.println("j'y passe");
		  unClient = servicesClient.login(userName, password);	
		  System.out.println(unClient.getNom());
		}
		return null;
	}
	
}

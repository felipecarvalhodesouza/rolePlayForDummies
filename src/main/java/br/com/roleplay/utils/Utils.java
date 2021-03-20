package br.com.roleplay.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public static String applicationResources = "br.com.roleplay.messages.messages";
	
	public static EntityManager JpaEntityManager() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();

		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		return (EntityManager) request.getAttribute("entityManager");
	}

	// MOSTRAR MENSAGEM
	public static void message(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage("Alert", message));
	}

	// MOSTRAR MENSAGEM
	public static void warningMessage(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, getLocaleName("label.warning"), message));
	}

	// MOSTRAR MENSAGEM
	public static void infoMessage(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", message));
	}
	
	public static Locale getLocaleContext() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	
	public static ResourceBundle getResouceBundle() {
		return ResourceBundle.getBundle(applicationResources, getLocaleContext());
	}
	
	public static String getLocaleName(String key) {
		return getResouceBundle().getString(key);
	}

	public static String replaceSpecialChars(String string) {
		return string.replaceAll("[^a-zA-Z]", "");
	}
}

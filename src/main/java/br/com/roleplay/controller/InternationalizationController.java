package br.com.roleplay.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "internationalizationController", eager = true)
@SessionScoped
public class InternationalizationController implements Serializable{

	private static final long serialVersionUID = 8490356184216802842L;

	private Locale locale;

	public Map<String, Object> countries  = new LinkedHashMap<String, Object>();
	
	@PostConstruct
	public void init(){
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		
		countries.put("English", Locale.ENGLISH);
		countries.put("Brazil", new Locale("pt", "BR"));
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, Object> countries) {
		this.countries = countries;
	}

	public void localeChanged(Locale e) {
		String newLocaleValue = e.toString();

		for (Map.Entry<String, Object> entry : countries.entrySet()) {

			if (entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
				locale = (Locale) entry.getValue();
			}
		}
	}

}

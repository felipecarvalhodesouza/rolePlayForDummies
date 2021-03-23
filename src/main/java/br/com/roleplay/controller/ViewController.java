package br.com.roleplay.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "viewController")
@SessionScoped
public class ViewController {

	private final String defaultModeTheme = "saga";
	private final String darkModeTheme = "arya";
	private boolean darkMode;
	private String applicationTheme = defaultModeTheme;

	public boolean isDarkMode() {
		return darkMode;
	}

	public void setDarkMode(boolean darkMode) {
		this.darkMode = darkMode;
	}

	public void changeView(boolean isDarkMode) {
		setApplicationTheme(isDarkMode ? darkModeTheme : defaultModeTheme);
	}

	public String getApplicationTheme() {
		return applicationTheme;
	}

	public void setApplicationTheme(String applicationTheme) {
		this.applicationTheme = applicationTheme;
	}

}

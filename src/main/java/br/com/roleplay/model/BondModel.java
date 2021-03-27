package br.com.roleplay.model;

import java.util.Locale;

public class BondModel {

	private long id;
	private int value;
	private String descriptionEn;
	private String descriptionPt;
	private BackgroundModel background;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	
	public String getDescriptionPt() {
		return descriptionPt;
	}

	public void setDescriptionPt(String descriptionPt) {
		this.descriptionPt = descriptionPt;
	}

	public BackgroundModel getBackground() {
		return background;
	}

	public void setBackground(BackgroundModel background) {
		this.background = background;
	}
	
	public String getLocaleDescription(Locale locale) {
		return locale.getLanguage().equalsIgnoreCase("en") ? getDescriptionEn() : getDescriptionPt();
	}
}

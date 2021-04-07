package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Gender implements EnumLocation{

	MALE(1,"label.enum.gender.male"),
	FEMALE(2,"label.enum.gender.female");
	
	private int cod;
	private String description;
	
	private Gender(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return getLocaleDescription();
	}
	
}

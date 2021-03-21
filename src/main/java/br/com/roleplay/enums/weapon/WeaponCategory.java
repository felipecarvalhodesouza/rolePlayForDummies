package br.com.roleplay.enums.weapon;

import br.com.roleplay.interfaces.EnumLocation;

public enum WeaponCategory implements EnumLocation{

	SIMPLE(1, "label.enum.weapon.category.simple"),
	MARTIAL(2, "label.enum.weapon.category.martial");

	private Integer cod;
	private String description;

	private WeaponCategory(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

package br.com.roleplay.enums.weapon;

import br.com.roleplay.interfaces.EnumLocation;

public enum WeaponProperty implements EnumLocation{

	AMMUNITION(1, "label.enum.weapon.property.ammunition"),
	FINESSE(2, "label.enum.weapon.property.finesse"),
	HEAVY(3, "label.enum.weapon.property.heavy"),
	LIGTH(4, "label.enum.weapon.property.light"),
	LOADING(5, "label.enum.weapon.property.loading"),
	RANGE(6, "label.enum.weapon.property.range"),
	REACH(7, "label.enum.weapon.property.reach"),
	THROWN(8, "label.enum.weapon.property.thrown"),
	TWO_HANDED(9, "label.enum.weapon.property.two_handed"),
	VERSATILE(10, "label.enum.weapon.property.versatile");

	private Integer cod;
	private String description;

	private WeaponProperty(Integer cod, String description) {
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

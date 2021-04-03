package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum ArmorType implements EnumLocation {

	LIGHT_ARMOR(1, "label.enum.armor.type.light"),
	MEDIUM_ARMOR(2, "label.enum.armor.type.medium"),
	HEAVY_ARMOR(3, "label.enum.armor.type.heavy"),
	SHIELD(4, "label.enum.armor.type.shield");

	private ArmorType(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	private Integer cod;
	private String description;

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

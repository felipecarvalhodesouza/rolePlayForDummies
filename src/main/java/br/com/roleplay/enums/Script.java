package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Script implements EnumLocation {
	COMMON   (1, "label.language.script.commom"),
	DWARVISH (2, "label.language.script.dwarvish"),
	ELVISH   (3, "label.language.script.elvish"),
	INFERNAL (4, "label.language.script.infernal"),
	CELESTIAL(5, "label.language.script.celestial"),
	DRACONIC (6, "label.language.script.draconic"),
	NONE     (7, "label.language.script.none");

	private Integer cod;
	private String description;

	Script(Integer cod, String description) {
		this.setCod(cod);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	private void setCod(Integer cod) {
		this.cod = cod;
	}
}

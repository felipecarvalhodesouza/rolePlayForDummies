package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum LanguageType implements EnumLocation{
	STANDARD(1, "label.language.type.description.standard"),
	EXOTIC(2, "label.language.type.description.exotic"),
	SECRET(3, "label.language.type.description.secret");

	private Integer cod;
	private String description;

	LanguageType(Integer cod, String description) {
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

package br.com.roleplay.enums;

public enum LanguageType {
	STANDARD(1, "Stardard"), EXOTIC(2, "Exotic"), SECRET(3, "Secret");

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

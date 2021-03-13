package br.com.roleplay.enums;

public enum Script {
	COMMOM(1, "Commom"), DWARVISH(2, "Dwarvish"), ELVISH(3, "Elvish"), INFERNAL(4, "Infernal"), CELESTIAL(5, "Celestial"),
	DRACONIC(6, "Draconic"), NONE(7, "None");
	
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

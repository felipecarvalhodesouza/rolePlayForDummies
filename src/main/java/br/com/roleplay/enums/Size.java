package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Size implements EnumLocation{
	SMALL(1, "label.enum.size.small"),
	MEDIUM(2, "label.enum.size.medium");
	
	private Integer cod;
	private String description;
	
	private Size(Integer cod, String description) {
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

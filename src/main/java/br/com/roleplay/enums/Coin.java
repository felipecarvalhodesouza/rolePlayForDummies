package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Coin implements EnumLocation {

	CP(1, "label.enum.coin.copper", 1),
	SP(2, "label.enum.coin.silver", 10),
	EP(3, "label.enum.coin.gold", 50),
	GP(4, "label.enum.coin.copper", 100),
	PP(5, "label.enum.coin.platinum", 1000);
	
	private Integer cod;
	private String description;
	private int value;
	
	private Coin(Integer cod, String description, int value) {
		this.cod = cod;
		this.description = description;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

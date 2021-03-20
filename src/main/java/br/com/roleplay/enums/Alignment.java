package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Alignment implements EnumLocation{

	LAWFUL_GOOD(1, "label.enum.alignment.lawful.good"),
	LAWFUL_NEUTRAL(2, "label.enum.alignment.lawful.neutral"),
	LAWFUL_EVIL(3, "label.enum.alignment.lawful.evil"),
	NEUTRAL_GOOD(4, "label.enum.alignment.neutral.good"),
	TRUE_NEUTRAL(5, "label.enum.alignment.true.neutral"),
	NEUTRAL_EVIL(6, "label.enum.alignment.neutral.evil"),
	CHAOTIC_GOOD(7, "label.enum.alignment.chaotic.good"),
	CHAOTIC_NEUTRAL(8, "label.enum.alignment.chaotic.neutral"),
	CHAOTIC_EVIL(9, "label.enum.alignment.chaotic.evil");

	private int cod;
	private String description;
	
	private Alignment(int cod, String description) {
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

}

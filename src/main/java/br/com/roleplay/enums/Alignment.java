package br.com.roleplay.enums;

public enum Alignment {

	LAWFUL_GOOD(1, "Lawful good"), LAWFUL_NEUTRAL(2, "Lawful neutral"), LAWFUL_EVIL(3, "Lawful evil"),
	NEUTRAL_GOOD(4, "Neutral good"), TRUE_NEUTRAL(5, "True neutral"), NEUTRAL_EVIL(6, "Neutral evil"),
	CHAOTIC_GOOD(7, "Chaotic good"), CHAOTIC_NEUTRAL(8, "Chaotic good"), CHAOTIC_EVIL(9, "Chaotic evil");


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

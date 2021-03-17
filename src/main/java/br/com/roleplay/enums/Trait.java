package br.com.roleplay.enums;

public enum Trait {
	STRENGTH(1, "Strength"),
	DEXTERITY(2, "Dexterity"),
	CONSTITUTION(3, "Constitution"),
	INTELLIGENCE(4, "Intelligence"),
	WISDOM(5, "Wisdom"),
	CHARISMA(6, "Charisma"),
	ANY(7, "Any");
	
	private int cod;
	private String description;
	
	private Trait(int cod, String description) {
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
	
	public static Trait getTraitByCod(int cod) {
		for(Trait trait: Trait.values()) {
			if(trait.getCod() == cod) {
				return trait;
			}
		}
		return null;
	}
}

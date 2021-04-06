package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Trait implements EnumLocation{
	
	STRENGTH(1, "label.enum.trait.strength"),
	DEXTERITY(2, "label.enum.trait.dexterity"),
	CONSTITUTION(3, "label.enum.trait.constitution"),
	INTELLIGENCE(4, "label.enum.trait.intelligence"),
	WISDOM(5, "label.enum.trait.wisdom"),
	CHARISMA(6, "label.enum.trait.charisma"),
	ANY(7, "label.enum.trait.any");
	
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
	
	@Override
	public String toString() {
		return getLocaleDescription();
	}
}

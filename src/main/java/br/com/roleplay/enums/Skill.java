package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum Skill implements EnumLocation {
	
	ATHLETICS(1, Trait.STRENGTH, "label.enum.skill.athletics"),
	ACROBATICS(2, Trait.DEXTERITY, "label.enum.skill.acrobatics"),
	SLEIGHT_OF_HAND(3, Trait.DEXTERITY, "label.enum.skill.sleight.of.hand"),
	STEALTH(4, Trait.DEXTERITY, "label.enum.skill.stealth"),
	ARCANA(5, Trait.INTELLIGENCE, "label.enum.skill.arcana"),
	HISTORY(6, Trait.INTELLIGENCE, "label.enum.skill.history"),
	INVESTIGATION(7, Trait.INTELLIGENCE, "label.enum.skill.investigation"),
	NATURE(8, Trait.INTELLIGENCE, "label.enum.skill.nature"),
	RELIGION(9, Trait.INTELLIGENCE, "label.enum.skill.religion"),
	ANIMAL_HANDLING(10, Trait.WISDOM, "label.enum.skill.animal.handling"),
	INSIGHT(11, Trait.WISDOM, "label.enum.skill.insight"),
	MEDICINE(12, Trait.WISDOM, "label.enum.skill.medicine"),
	PERCEPTION(13, Trait.WISDOM, "label.enum.skill.perception"),
	SURVIVAL(14, Trait.WISDOM, "label.enum.skill.survival"),
	DECEPTION(15, Trait.CHARISMA, "label.enum.skill.deception"),
	INTIMIDATION(16, Trait.CHARISMA, "label.enum.skill.intimidation"),
	PERFORMANCE(17, Trait.CHARISMA, "label.enum.skill.performance"),
	PERSUASION(18, Trait.CHARISMA, "label.enum.skill.persuasion");
	
	private Integer cod;
	private Trait trait;
	private String description;
	
	private Skill(Integer cod, Trait trait, String description) {
		this.cod = cod;
		this.setTrait(trait);
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Trait getTrait() {
		return trait;
	}

	public void setTrait(Trait trait) {
		this.trait = trait;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return getLocaleDescription();
	}

}

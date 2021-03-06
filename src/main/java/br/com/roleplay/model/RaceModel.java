package br.com.roleplay.model;

import java.util.List;
import java.util.Set;

import br.com.roleplay.enums.Alignment;
import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Size;

public class RaceModel {

	private long id;

	private String name;

	private Integer age;

	private Set<LanguageModel> languages;
	private List<AbilityBonusModel> abilityBonus;

	private Integer movement;

	private Double baseHeight;
	private Double baseWeight;
	
	private List<Dice> heightModifier;
	private List<Dice> weightModifier;

	private Alignment alignment;
	
	private Size size;

	public RaceModel() {}
	
	public RaceModel(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageModel> languages) {
		this.languages = languages;
	}

	public Integer getMovement() {
		return movement;
	}

	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<AbilityBonusModel> getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(List<AbilityBonusModel> abilityBonus) {
		this.abilityBonus = abilityBonus;
	}

	public Double getBaseHeight() {
		return baseHeight;
	}

	public void setBaseHeight(Double baseHeight) {
		this.baseHeight = baseHeight;
	}

	public Double getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(Double baseWeight) {
		this.baseWeight = baseWeight;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public List<Dice> getHeightModifier() {
		return heightModifier;
	}

	public void setHeightModifier(List<Dice> heightModifier) {
		this.heightModifier = heightModifier;
	}

	public List<Dice> getWeightModifier() {
		return weightModifier;
	}

	public void setWeightModifier(List<Dice> weightModifier) {
		this.weightModifier = weightModifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaceModel other = (RaceModel) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

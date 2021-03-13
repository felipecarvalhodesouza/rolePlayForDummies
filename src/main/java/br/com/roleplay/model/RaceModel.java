package br.com.roleplay.model;

import java.util.List;
import java.util.Set;

import br.com.roleplay.enums.Alignment;

public class RaceModel {

	private long id;

	private String name;

	private Integer age;

	private Set<LanguageModel> languages;
	private List<AbilityBonusModel> abilityBonus;

	private Integer movement;
	private Integer speed;

	private Double baseHeight;
	private Double baseWeight;

	private Alignment alignment;

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

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
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

}

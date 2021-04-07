package br.com.roleplay.model;

import java.util.List;
import java.util.Set;

import br.com.roleplay.enums.Alignment;
import br.com.roleplay.enums.Gender;
import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.background.BondModel;
import br.com.roleplay.model.background.FlawModel;
import br.com.roleplay.model.background.IdealModel;
import br.com.roleplay.model.background.PersonalityModel;
import br.com.roleplay.model.items.ArmorModel;
import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.model.items.WeaponModel;

public class CharacterModel {

	private long id;

	private Gender gender;

	private RaceModel race;

	private String name;

	private BackgroundModel background;
	private IdealModel ideals;
	private BondModel bonds;
	private FlawModel flaws;
	private PersonalityModel personality;

	private ClassModel classModel;

	private Double height;
	private Double weight;
	private String appearance;

	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;

	private Integer proficiencyBonus;

	private Integer strengthModifier;
	private Integer dexterityModifier;
	private Integer constitutionModifier;
	private Integer intelligenceModifier;
	private Integer wisdomModifier;
	private Integer charismaModifier;

	private Integer healthPoints;

	private Alignment alignment;

	private Integer level;
	private Integer experiencePoints;

	private Set<LanguageModel> languages;
	private List<ItemModel> items;
	private List<ArmorModel> armors;
	private List<WeaponModel> weapons;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public RaceModel getRace() {
		return race;
	}

	public void setRace(RaceModel race) {
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BackgroundModel getBackground() {
		return background;
	}

	public void setBackground(BackgroundModel background) {
		this.background = background;
	}

	public IdealModel getIdeals() {
		return ideals;
	}

	public void setIdeals(IdealModel ideals) {
		this.ideals = ideals;
	}

	public BondModel getBonds() {
		return bonds;
	}

	public void setBonds(BondModel bonds) {
		this.bonds = bonds;
	}

	public FlawModel getFlaws() {
		return flaws;
	}

	public void setFlaws(FlawModel flaws) {
		this.flaws = flaws;
	}

	public PersonalityModel getPersonality() {
		return personality;
	}

	public void setPersonality(PersonalityModel personality) {
		this.personality = personality;
	}

	public ClassModel getClassModel() {
		return classModel;
	}

	public void setClassModel(ClassModel classModel) {
		this.classModel = classModel;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getAppearance() {
		return appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public Integer getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(Integer proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}

	public Integer getStrengthModifier() {
		return strengthModifier;
	}

	public void setStrengthModifier(Integer strengthModifier) {
		this.strengthModifier = strengthModifier;
	}

	public Integer getDexterityModifier() {
		return dexterityModifier;
	}

	public void setDexterityModifier(Integer dexterityModifier) {
		this.dexterityModifier = dexterityModifier;
	}

	public Integer getConstitutionModifier() {
		return constitutionModifier;
	}

	public void setConstitutionModifier(Integer constitutionModifier) {
		this.constitutionModifier = constitutionModifier;
	}

	public Integer getIntelligenceModifier() {
		return intelligenceModifier;
	}

	public void setIntelligenceModifier(Integer intelligenceModifier) {
		this.intelligenceModifier = intelligenceModifier;
	}

	public Integer getWisdomModifier() {
		return wisdomModifier;
	}

	public void setWisdomModifier(Integer wisdomModifier) {
		this.wisdomModifier = wisdomModifier;
	}

	public Integer getCharismaModifier() {
		return charismaModifier;
	}

	public void setCharismaModifier(Integer charismaModifier) {
		this.charismaModifier = charismaModifier;
	}

	public Integer getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(Integer experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public Set<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageModel> languages) {
		this.languages = languages;
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}

	public List<ArmorModel> getArmors() {
		return armors;
	}

	public void setArmors(List<ArmorModel> armors) {
		this.armors = armors;
	}

	public List<WeaponModel> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<WeaponModel> weapons) {
		this.weapons = weapons;
	}

}

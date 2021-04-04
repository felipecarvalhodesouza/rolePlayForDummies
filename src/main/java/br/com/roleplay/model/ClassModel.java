package br.com.roleplay.model;

import java.util.List;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Trait;
import br.com.roleplay.interfaces.PHBClass;

public class ClassModel implements PHBClass {

	private long id;
	private String name;
	private String descriptionEn;
	private String descriptionPt;
	private Dice hitDie;
	private Trait primaryAbility;
	private List<Trait> savingThrows;
	private List<ProficiencyModel> proficiencies;

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

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	
	public String getDescriptionPt() {
		return descriptionPt;
	}

	public void setDescriptionPt(String descriptionPt) {
		this.descriptionPt = descriptionPt;
	}

	public Dice getHitDie() {
		return hitDie;
	}

	public void setHitDie(Dice hitDie) {
		this.hitDie = hitDie;
	}

	public Trait getPrimaryAbility() {
		return primaryAbility;
	}

	public void setPrimaryAbility(Trait primaryAbility) {
		this.primaryAbility = primaryAbility;
	}

	public List<Trait> getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(List<Trait> savingThrows) {
		this.savingThrows = savingThrows;
	}

	public List<ProficiencyModel> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<ProficiencyModel> proficiencies) {
		this.proficiencies = proficiencies;
	}

}

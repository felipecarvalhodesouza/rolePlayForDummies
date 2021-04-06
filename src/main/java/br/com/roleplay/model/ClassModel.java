package br.com.roleplay.model;

import java.util.List;
import java.util.Locale;

import org.primefaces.model.DefaultStreamedContent;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Trait;
import br.com.roleplay.interfaces.PHBClass;
import br.com.roleplay.utils.Utils;

public class ClassModel implements PHBClass {

	private long id;
	private String name;
	private String descriptionEn;
	private String descriptionPt;
	private Dice hitDice;
	private Trait primaryAbility;
	private List<Trait> savingThrows;
	private List<ProficiencyModel> proficiencies;
	private String image;

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

	public Dice getHitDice() {
		return hitDice;
	}

	public void setHitDice(Dice hitDice) {
		this.hitDice = hitDice;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public DefaultStreamedContent getRenderedClassImage() {
		return Utils.renderImageFromString(image);
	}
	
	public String getLocaleDescription(Locale locale) {
		return locale.getLanguage().equalsIgnoreCase("en") ? getDescriptionEn() : getDescriptionPt();
	}

}

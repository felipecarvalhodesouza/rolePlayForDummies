package br.com.roleplay.model.background;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import br.com.roleplay.enums.Skill;
import br.com.roleplay.interfaces.Equipment;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.items.OptionalItemModel;

public class BackgroundModel {

	private long id;
	private String name;
	private Set<Skill> skillProficiencies;
	private List<LanguageModel> languages;
	private List<Equipment> itens;
	private List<OptionalItemModel> optionalItens;
	private String featureDescriptionEn;
	private String featureDescriptionPt;
	private String characteristicsDescriptionEn;
	private String characteristicsDescriptionPt;
	
	public BackgroundModel() {
		
	}
	
	public BackgroundModel(long id, String name) {
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

	public Set<Skill> getSkillProficiencies() {
		return skillProficiencies;
	}

	public void setSkillProficiencies(Set<Skill> skillProficiencies) {
		this.skillProficiencies = skillProficiencies;
	}

	public List<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageModel> languages) {
		this.languages = languages;
	}

	public String getFeatureDescriptionEn() {
		return featureDescriptionEn;
	}

	public void setFeatureDescriptionEn(String featureDescriptionEn) {
		this.featureDescriptionEn = featureDescriptionEn;
	}

	public String getFeatureDescriptionPt() {
		return featureDescriptionPt;
	}

	public void setFeatureDescriptionPt(String featureDescriptionPt) {
		this.featureDescriptionPt = featureDescriptionPt;
	}

	public String getCharacteristicsDescriptionEn() {
		return characteristicsDescriptionEn;
	}

	public void setCharacteristicsDescriptionEn(String characteristicsDescriptionEn) {
		this.characteristicsDescriptionEn = characteristicsDescriptionEn;
	}

	public String getCharacteristicsDescriptionPt() {
		return characteristicsDescriptionPt;
	}

	public void setCharacteristicsDescriptionPt(String characteristicsDescriptionPt) {
		this.characteristicsDescriptionPt = characteristicsDescriptionPt;
	}

	public List<Equipment> getItens() {
		return itens;
	}

	public void setItens(List<Equipment> itens) {
		this.itens = itens;
	}

	public List<OptionalItemModel> getOptionalItens() {
		return optionalItens;
	}

	public void setOptionalItens(List<OptionalItemModel> optionalItens) {
		this.optionalItens = optionalItens;
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
		BackgroundModel other = (BackgroundModel) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String getLocaleFeatureDescription(Locale locale) {
		return locale.getLanguage().equalsIgnoreCase("en") ? getFeatureDescriptionEn() : getFeatureDescriptionPt();
	}
	
	public String getLocaleCharacteristicsDescription(Locale locale) {
		return locale.getLanguage().equalsIgnoreCase("en") ? getCharacteristicsDescriptionEn() : getCharacteristicsDescriptionPt();
	}
	
}

package br.com.roleplay.entity.background;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.items.ItemEntity;
import br.com.roleplay.entity.items.OptionalItemEntity;
import br.com.roleplay.enums.Skill;

@Entity
@Table(name = "background")
public class BackgroundEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@ElementCollection(fetch = FetchType.EAGER, targetClass = Skill.class)
	@CollectionTable(name = "background_skill_proficiency",
	joinColumns = @JoinColumn(name = "background_id", referencedColumnName = "id"))
	@Column(name = "skill_proficiency", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<Skill> skillProficiencies;

	@ManyToMany
	@JoinTable(name = "background_language",
	joinColumns = @JoinColumn(name = "background_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id"))
	private List<LanguageEntity> languages;
	
	@ManyToMany
	@JoinTable(name = "background_item",
	joinColumns = @JoinColumn(name = "background_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	private List<ItemEntity> items;
	
	@ManyToMany
	@JoinTable(name = "background_optional_item",
	joinColumns = @JoinColumn(name = "background_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "optional_item_id", referencedColumnName = "id"))
	private List<OptionalItemEntity> optionalItems;

	@Column(name = "feature_description_en", length = 1000)
	private String featureDescriptionEn;

	@Column(name = "feature_description_pt", length = 1000)
	private String featureDescriptionPt;

	@Column(name = "characteristics_description_en", length = 1000)
	private String characteristicsDescriptionEn;

	@Column(name = "characteristics_description_pt", length = 1000)
	private String characteristicsDescriptionPt;

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

	public List<LanguageEntity> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageEntity> languages) {
		this.languages = languages;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public List<OptionalItemEntity> getOptionalItems() {
		return optionalItems;
	}

	public void setOptionalItems(List<OptionalItemEntity> optionalItems) {
		this.optionalItems = optionalItems;
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
}

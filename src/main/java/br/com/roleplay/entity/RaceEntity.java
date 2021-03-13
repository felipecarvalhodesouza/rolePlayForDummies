package br.com.roleplay.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.roleplay.enums.Alignment;

@Entity
@Table(name = "race")
public class RaceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@ManyToMany
	@JoinColumn(name = "id")
	private Set<LanguageEntity> languages;
	
	@ManyToMany
	@JoinColumn(name = "id")
	private List<AbilityBonusEntity> abilityBonus;
	
	@Column(name = "movement")
	private Integer movement;
	
	@Column(name = "speed")
	private Integer speed;
	
	@Column(name = "baseHeight")
	private Double baseHeight;
	
	@Column(name = "baseWeight")
	private Double baseWeight;
	
	@Column(name = "alignment")
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

	public Set<LanguageEntity> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageEntity> languages) {
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

	public List<AbilityBonusEntity> getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(List<AbilityBonusEntity> abilityBonus) {
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
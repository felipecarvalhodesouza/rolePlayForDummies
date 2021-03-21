package br.com.roleplay.entity;

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
import javax.persistence.Table;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.weapon.DamageType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.enums.weapon.WeaponProperty;

@Entity
@Table(name = "weapon")
public class WeaponEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private Integer cost;
	
	@Column(name = "weight")
	private Double weight;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = WeaponProperty.class)
	@CollectionTable(name = "weapon_property",
	joinColumns = @JoinColumn(name="weapon_id", referencedColumnName="id"))
	@Column(name = "property", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<WeaponProperty> weaponProperties;
	
	@Column(name="weaponCategory")
	@Enumerated(EnumType.STRING)
	private WeaponCategory weaponCategory;
	
	@ElementCollection
	@JoinTable(name = "weapon_damage")
	private List<Dice> damage;
	
	@Column(name="damageType")
	@Enumerated(EnumType.STRING)
	private DamageType damageType;
	
	@Column(name="minRange")
	private Integer minRange;
	
	@Column(name="maxRange")
	private Integer maxRange;

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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Set<WeaponProperty> getWeaponProperties() {
		return weaponProperties;
	}

	public void setWeaponProperties(Set<WeaponProperty> weaponProperties) {
		this.weaponProperties = weaponProperties;
	}

	public WeaponCategory getWeaponCategory() {
		return weaponCategory;
	}

	public void setWeaponCategory(WeaponCategory weaponCategory) {
		this.weaponCategory = weaponCategory;
	}

	public List<Dice> getDamage() {
		return damage;
	}

	public void setDamage(List<Dice> damage) {
		this.damage = damage;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	public Integer getMinRange() {
		return minRange;
	}

	public void setMinRange(Integer minRange) {
		this.minRange = minRange;
	}

	public Integer getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
}

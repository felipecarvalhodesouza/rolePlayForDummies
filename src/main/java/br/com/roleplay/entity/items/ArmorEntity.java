package br.com.roleplay.entity.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.Trait;

@Entity
@Table(name = "armor")
public class ArmorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ds_name")
	private String name;
	
	@Column(name = "ds_armor_type")
	@Enumerated(EnumType.STRING)	
	private ArmorType armorType;
	
	@Column(name = "vl_cost")
	private Integer cost;
	
	@Column(name = "ds_coin")
	@Enumerated(EnumType.STRING)
	private Coin coin;
	
	@Column(name = "vl_armor_class_value")
	private int armorClassValue;
	
	@Column(name = "ds_armor_class_modifier")
	private Trait armorClassModifier;
	
	@Column(name = "vl_max_armor_class_modifier")
	private int maxArmorClassModifier;
	
	@Column(name = "vl_strength")
	private int strength;
	
	@Column(name = "ic_stealth_disvantage")
	private boolean stealthDisvantage;
	
	@Column(name = "vl_weight")
	private Double weight;

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

	public ArmorType getArmorType() {
		return armorType;
	}

	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public int getArmorClassValue() {
		return armorClassValue;
	}

	public void setArmorClassValue(int armorClassValue) {
		this.armorClassValue = armorClassValue;
	}

	public Trait getArmorClassModifier() {
		return armorClassModifier;
	}

	public void setArmorClassModifier(Trait armorClassModifier) {
		this.armorClassModifier = armorClassModifier;
	}

	public int getMaxArmorClassModifier() {
		return maxArmorClassModifier;
	}

	public void setMaxArmorClassModifier(int maxArmorClassModifier) {
		this.maxArmorClassModifier = maxArmorClassModifier;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public boolean isStealthDisvantage() {
		return stealthDisvantage;
	}

	public void setStealthDisvantage(boolean stealthDisvantage) {
		this.stealthDisvantage = stealthDisvantage;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getValue() {
		StringBuffer sb = new StringBuffer();
		return sb.append(getCost()).append(getCoin().getLocaleDescription()).toString();
	}
}

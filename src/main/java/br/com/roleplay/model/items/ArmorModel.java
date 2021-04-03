package br.com.roleplay.model.items;

import java.util.Locale;

import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.Trait;

public class ArmorModel {

	private long id;
	private String name;
	private ArmorType armorType;
	private Integer cost;
	private Coin coin;
	private int armorClassValue;
	private Trait armorClassModifier;
	private int maxArmorClassModifier;
	private int strength;
	private boolean stealthDisvantage;
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
	
	public String getCA(Locale locale) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getArmorClassValue());
		
		boolean hasArmorClassModifier = getArmorClassModifier() != null;
		if(locale.getLanguage().equals("en")) {
			if(hasArmorClassModifier) {
				buffer.append(" + ").append(getArmorClassModifier().getLocaleDescription()).append(" modifier");
			}
			if(getMaxArmorClassModifier() != 0) {
				buffer.append(" (max ").append(getMaxArmorClassModifier()).append(")");
			}
		} else {
			if(hasArmorClassModifier) {
				buffer.append(" + modificador de ").append(getArmorClassModifier().getLocaleDescription());
			}
			if(getMaxArmorClassModifier() != 0) {
				buffer.append(" (máximo ").append(getMaxArmorClassModifier()).append(")");
			}
		}

		return buffer.toString();
	}
}

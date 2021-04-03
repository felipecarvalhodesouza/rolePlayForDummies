package br.com.roleplay.model.items;

import java.util.List;
import java.util.Set;

import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.weapon.DamageType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.enums.weapon.WeaponProperty;

public class WeaponModel {

	private long id;
	private String name;
	private Integer cost;
	private Coin coin;
	private Double weight;
	private Set<WeaponProperty> weaponProperties;
	private WeaponCategory weaponCategory;
	private List<Dice> damage;
	private DamageType damageType;
	private int minRange;
	private int maxRange;

	public WeaponModel() {
	}

	public WeaponModel(long id, String name) {
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

	public int getMinRange() {
		return minRange;
	}

	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public String getRange() {
		StringBuffer sb = new StringBuffer();
		return sb.append(getMinRange()).append(" - ").append(getMaxRange()).toString();
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public String getValue() {
		StringBuffer sb = new StringBuffer();
		return sb.append(getCost()).append(getCoin().getLocaleDescription()).toString();
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
		WeaponModel other = (WeaponModel) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}
}

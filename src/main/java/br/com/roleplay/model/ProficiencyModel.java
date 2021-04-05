package br.com.roleplay.model;

import java.util.List;

import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.model.items.WeaponModel;

public class ProficiencyModel {

	private long id;
	private Integer cod;
	private List<ArmorType> armorTypeList;
	private List<WeaponCategory> weaponCategoryList;
	private List<WeaponModel> weaponList;

	public ProficiencyModel() {}
	
	public ProficiencyModel(long id, int cod) {
		this.id = id;
		this.cod = cod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public List<ArmorType> getArmorTypeList() {
		return armorTypeList;
	}

	public void setArmorTypeList(List<ArmorType> armorTypeList) {
		this.armorTypeList = armorTypeList;
	}

	public List<WeaponCategory> getWeaponCategoryList() {
		return weaponCategoryList;
	}

	public void setWeaponCategoryList(List<WeaponCategory> weaponCategoryList) {
		this.weaponCategoryList = weaponCategoryList;
	}

	public List<WeaponModel> getWeaponList() {
		return weaponList;
	}

	public void setWeaponList(List<WeaponModel> weaponList) {
		this.weaponList = weaponList;
	}

	@Override
	public String toString() {
		return "[" + armorTypeList + ", " + weaponCategoryList + ", " + weaponList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		ProficiencyModel other = (ProficiencyModel) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}

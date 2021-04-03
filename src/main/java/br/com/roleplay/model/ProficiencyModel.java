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
}

package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.weapon.DamageType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.enums.weapon.WeaponProperty;
import br.com.roleplay.model.WeaponModel;
import br.com.roleplay.utils.Utils;

@Named(value = "weaponController")
@RequestScoped
public class WeaponController {

	@Inject
	private WeaponModel weaponModel;

	Set<DamageType> damageTypes = new HashSet<DamageType>();
	Set<WeaponCategory> weaponCategories = new HashSet<WeaponCategory>();
	Set<WeaponProperty> weaponProperties = new HashSet<WeaponProperty>();
	private List<Dice> dices = new ArrayList<Dice>();

	@PostConstruct
	public void init() {

		for (DamageType damageType : DamageType.values()) {
			damageTypes.add(damageType);
		}

		for (WeaponCategory weaponCategory : WeaponCategory.values()) {
			weaponCategories.add(weaponCategory);
		}

		for (WeaponProperty weaponProperty : WeaponProperty.values()) {
			weaponProperties.add(weaponProperty);
		}

		for (Dice dice : Dice.values()) {
			getDices().addAll(Arrays.asList(dice, dice));
		}

	}

	public WeaponModel getWeaponModel() {
		return weaponModel;
	}

	public void setWeaponModel(WeaponModel weaponModel) {
		this.weaponModel = weaponModel;
	}

	public Set<DamageType> getDamageTypes() {
		return damageTypes;
	}

	public void setDamageTypes(Set<DamageType> damageTypes) {
		this.damageTypes = damageTypes;
	}

	public Set<WeaponCategory> getWeaponCategories() {
		return weaponCategories;
	}

	public void setWeaponCategories(Set<WeaponCategory> weaponCategories) {
		this.weaponCategories = weaponCategories;
	}

	public Set<WeaponProperty> getWeaponProperties() {
		return weaponProperties;
	}

	public void setWeaponProperties(Set<WeaponProperty> weaponProperties) {
		this.weaponProperties = weaponProperties;
	}

	public List<Dice> getDices() {
		return dices;
	}

	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}

	public void insertNewWeapon() {

		Utils.infoMessage("Record succesfully inserted.");
	}

}
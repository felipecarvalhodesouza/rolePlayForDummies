package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
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
import br.com.roleplay.repository.WeaponRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "weaponController")
@RequestScoped
public class WeaponController {

	@Inject
	private WeaponModel weaponModel;
	
	@Inject
	private WeaponRepository weaponRepository;

	Set<DamageType> damageTypes = new LinkedHashSet<DamageType>();
	Set<WeaponCategory> weaponCategories = new LinkedHashSet<WeaponCategory>();
	Set<WeaponProperty> weaponProperties = new LinkedHashSet<WeaponProperty>();
	private List<Dice> dices = new ArrayList<Dice>();
	
	private final int minRange = 0;
	private final int maxRange = 600;

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

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void insertNewWeapon() {
		
		weaponRepository.insertWeapon(this.weaponModel);

		this.weaponModel = new WeaponModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));
		
	}

}
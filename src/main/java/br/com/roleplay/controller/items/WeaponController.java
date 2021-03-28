package br.com.roleplay.controller.items;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.weapon.DamageType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.enums.weapon.WeaponProperty;
import br.com.roleplay.model.items.WeaponModel;
import br.com.roleplay.repository.items.WeaponRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "weaponController")
@RequestScoped
public class WeaponController {

	@Inject
	private WeaponModel weaponModel;

	@Inject
	private WeaponRepository weaponRepository;

	private Set<DamageType> damageTypes = new LinkedHashSet<DamageType>();
	private Set<WeaponCategory> weaponCategories = new LinkedHashSet<WeaponCategory>();
	private Set<WeaponProperty> weaponProperties = new LinkedHashSet<WeaponProperty>();
	private List<Dice> dices = new ArrayList<Dice>();
	private List<Coin> coins = new ArrayList<Coin>();

	private Set<WeaponModel> weapons = new LinkedHashSet<WeaponModel>();

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
			getDices().add(dice);
		}
		
		for (Coin coin : Coin.values()) {
			getCoins().add(coin);
		}
		
		weapons = weaponRepository.getAllWeapons();
	}

	public void openUpdateDialog(WeaponModel weaponModel) {
		this.weaponModel = weaponModel;
	}
	
	public void updateWeapon(WeaponModel weaponModel) {
		weaponRepository.updateWeapon(weaponModel);
		
		this.init();
		
		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
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

	public Set<WeaponModel> getWeapons() {
		return weapons;
	}

	public void setWeapons(Set<WeaponModel> weapons) {
		this.weapons = weapons;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public void insertNewWeapon() {

		weaponRepository.insertWeapon(this.weaponModel);
		
		weapons.add(weaponModel);

		this.weaponModel = new WeaponModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}
	
	public void deleteWeapon(WeaponModel weaponModel) {

		weaponRepository.deleteWeapon(weaponModel.getId());
		this.weapons.remove(weaponModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
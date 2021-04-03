package br.com.roleplay.controller.items;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.Trait;
import br.com.roleplay.model.items.ArmorModel;
import br.com.roleplay.repository.items.ArmorRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "armorController")
@RequestScoped
public class ArmorController {

	@Inject
	private ArmorModel armorModel;

	@Inject
	private ArmorRepository armorRepository;

	private List<Coin> coins = new ArrayList<Coin>();
	private List<ArmorType> armorTypes = new ArrayList<ArmorType>();
	private List<Trait> armorClassModifiers = new ArrayList<Trait>();

	private Set<ArmorModel> armors = new LinkedHashSet<ArmorModel>();

	@PostConstruct
	public void init() {
		
		for(ArmorType type: ArmorType.values()) {
			getArmorTypes().add(type);
		}
		
		for(Trait trait: Trait.values()) {
			getArmorClassModifiers().add(trait);
		}
		
		for (Coin coin : Coin.values()) {
			getCoins().add(coin);
		}

		armors = armorRepository.getAllArmors();
	}

	public void openUpdateDialog(ArmorModel armorModel) {
		this.armorModel = armorModel;
	}

	public void updateArmor(ArmorModel armorModel) {
		armorRepository.updateArmor(armorModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public ArmorModel getArmorModel() {
		return armorModel;
	}

	public void setArmorModel(ArmorModel armorModel) {
		this.armorModel = armorModel;
	}

	public Set<ArmorModel> getArmors() {
		return armors;
	}

	public void setArmors(Set<ArmorModel> armors) {
		this.armors = armors;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public List<ArmorType> getArmorTypes() {
		return armorTypes;
	}

	public void setArmorTypes(List<ArmorType> armorTypes) {
		this.armorTypes = armorTypes;
	}

	public List<Trait> getArmorClassModifiers() {
		return armorClassModifiers;
	}

	public void setArmorClassModifiers(List<Trait> armorClassModifiers) {
		this.armorClassModifiers = armorClassModifiers;
	}

	public void insertNewArmor() {

		armorRepository.insertArmor(this.armorModel);

		armors.add(armorModel);

		this.armorModel = new ArmorModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteArmor(ArmorModel armorModel) {

		armorRepository.deleteArmor(armorModel.getId());
		this.armors.remove(armorModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
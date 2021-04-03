package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.weapon.WeaponCategory;
import br.com.roleplay.model.ProficiencyModel;
import br.com.roleplay.model.items.WeaponModel;
import br.com.roleplay.repository.ProficiencyRepository;
import br.com.roleplay.repository.items.WeaponRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "proficiencyController")
@RequestScoped
public class ProficiencyController {

	@Inject
	private	ProficiencyModel proficiencyModel;

	@Inject
	ProficiencyRepository proficiencyRepository;
	
	@Inject
	WeaponRepository weaponRepository;

	private List<ProficiencyModel> proficiencies = new ArrayList<ProficiencyModel>();
	private Set<WeaponModel> weapons = new LinkedHashSet<WeaponModel>();
	private List<WeaponCategory> weaponCategories = new ArrayList<WeaponCategory>();
	private List<ArmorType> armorTypes = new ArrayList<ArmorType>();

	@PostConstruct
	public void init() {
		
		for(WeaponCategory category: WeaponCategory.values()) {
			getWeaponCategories().add(category);
		}
		
		for(ArmorType armorType: ArmorType.values()) {
			getArmorTypes().add(armorType);
		}
		
		proficiencies = proficiencyRepository.getAllProficiencies();
		weapons = weaponRepository.getAllWeapons();
	}

	public void insertNewProficiency() {

		proficiencyRepository.insertProficiency(this.getProficiencyModel());
		
		proficiencies.add(getProficiencyModel());

		this.setProficiencyModel(new ProficiencyModel());

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));
	}
	
	public void openUpdateDialog(ProficiencyModel proficiencyModel) {
		this.proficiencyModel = proficiencyModel;
	}

	public void updateProficiency(ProficiencyModel proficiencyModel) {
		proficiencyRepository.updateProficiency(proficiencyModel);
		
		this.init();
		
		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}
	
	public void deleteProficiency(ProficiencyModel proficiencyModel) {

		proficiencyRepository.deleteProficiency(proficiencyModel.getId());
		this.proficiencies.remove(proficiencyModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

	public ProficiencyModel getProficiencyModel() {
		return proficiencyModel;
	}

	public void setProficiencyModel(ProficiencyModel proficiencyModel) {
		this.proficiencyModel = proficiencyModel;
	}

	public List<ProficiencyModel> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencys(List<ProficiencyModel> proficiencies) {
		this.proficiencies = proficiencies;
	}

	public Set<WeaponModel> getWeapons() {
		return weapons;
	}

	public void setWeapons(Set<WeaponModel> weapons) {
		this.weapons = weapons;
	}

	public List<WeaponCategory> getWeaponCategories() {
		return weaponCategories;
	}

	public void setWeaponCategories(List<WeaponCategory> weaponCategories) {
		this.weaponCategories = weaponCategories;
	}

	public List<ArmorType> getArmorTypes() {
		return armorTypes;
	}

	public void setArmorTypes(List<ArmorType> armorTypes) {
		this.armorTypes = armorTypes;
	}

	public void setProficiencies(List<ProficiencyModel> proficiencies) {
		this.proficiencies = proficiencies;
	}
}
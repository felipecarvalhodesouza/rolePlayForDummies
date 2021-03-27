package br.com.roleplay.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.roleplay.entity.AbilityBonusEntity;
import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.RaceEntity;
import br.com.roleplay.entity.ToolEntity;
import br.com.roleplay.entity.WeaponEntity;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.model.ToolModel;
import br.com.roleplay.model.WeaponModel;

public class UtilsConverter {

	public static <T> Set<T> getSetFromList(List<T> list) {

		Set<T> set = new LinkedHashSet<T>();

		for (T t : list) {
			set.add(t);
		}

		return set;
	}

	public static <T> List<T> getListFromSet(Set<T> set) {

		List<T> list = new ArrayList<T>();

		for (T t : set) {
			list.add(t);
		}

		return list;
	}

	public static Set<LanguageModel> getLanguageModelSetFromLanguageEntitySet(Set<LanguageEntity> languageEntitySet) {

		Set<LanguageModel> languagelModelSet = new LinkedHashSet<LanguageModel>();

		for (LanguageEntity languageEntity : languageEntitySet) {
			LanguageModel model = new LanguageModel();
			model.setId(languageEntity.getId());
			model.setLanguageType(languageEntity.getLanguageType());
			model.setScript(languageEntity.getScript());
			model.setName(languageEntity.getName());
			model.setTypicalSpeakers(getSetRaceModelFromSetRaceEntity(languageEntity.getTypicalSpeakers()));
			languagelModelSet.add(model);
		}

		return languagelModelSet;
	}

	public static Set<LanguageEntity> getLanguageEntitySetFromLanguageModelSet(Set<LanguageModel> languageModelSet) {

		Set<LanguageEntity> languagelEntitySet = new LinkedHashSet<LanguageEntity>();

		for (LanguageModel languageModel : languageModelSet) {
			LanguageEntity entity = new LanguageEntity();
			entity.setId(languageModel.getId());
			entity.setLanguageType(languageModel.getLanguageType());
			entity.setScript(languageModel.getScript());
			entity.setName(languageModel.getName());
			entity.setTypicalSpeakers(getRaceEntitySetFromRaceModelSet(languageModel.getTypicalSpeakers()));
			languagelEntitySet.add(entity);
		}

		return languagelEntitySet;
	}

	public static Set<RaceModel> getSetRaceModelFromSetRaceEntity(Set<RaceEntity> raceEntitySet) {

		Set<RaceModel> raceModelSet = new LinkedHashSet<RaceModel>();

		for (RaceEntity raceEntity : raceEntitySet) {
			RaceModel raceModel = new RaceModel();
			raceModel.setId(raceEntity.getId());
			raceModel.setName(raceEntity.getName());
			raceModel.setAge(raceEntity.getAge());
			raceModel.setAbilityBonus(getAbilityBonusModelListFromAbilityBonusEntityList(raceEntity.getAbilityBonus()));
			raceModel.setMovement(raceEntity.getMovement());
			raceModel.setBaseHeight(raceEntity.getBaseHeight());
			raceModel.setBaseWeight(raceEntity.getBaseWeight());
			raceModel.setAlignment(raceEntity.getAlignment());
			raceModel.setSize(raceEntity.getSize());
			raceModel.setHeightModifier(raceEntity.getHeightModifier());
			raceModel.setWeightModifier(raceEntity.getWeightModifier());
			raceModelSet.add(raceModel);
		}
		return raceModelSet;
	}

	public static Set<RaceEntity> getRaceEntitySetFromRaceModelSet(Set<RaceModel> raceModelSet) {

		Set<RaceEntity> raceEntitySet = new LinkedHashSet<RaceEntity>();

		for (RaceModel raceModel : raceModelSet) {
			RaceEntity raceEntity = new RaceEntity();
			raceEntity.setId(raceModel.getId());
			raceEntity.setName(raceModel.getName());
			raceEntity.setAge(raceModel.getAge());
			raceEntity.setAbilityBonus(getAbilityBonusEntityListFromAbilityBonusModelList(raceModel.getAbilityBonus()));
			raceEntity.setMovement(raceModel.getMovement());
			raceEntity.setBaseHeight(raceModel.getBaseHeight());
			raceEntity.setBaseWeight(raceModel.getBaseWeight());
			raceEntity.setAlignment(raceModel.getAlignment());
			raceEntity.setSize(raceModel.getSize());
			raceEntity.setHeightModifier(raceModel.getHeightModifier());
			raceEntity.setWeightModifier(raceModel.getWeightModifier());
			raceEntitySet.add(raceEntity);
		}
		return raceEntitySet;
	}

	public static List<AbilityBonusModel> getAbilityBonusModelListFromAbilityBonusEntityList(
			List<AbilityBonusEntity> list) {

		List<AbilityBonusModel> modelList = new ArrayList<AbilityBonusModel>();

		for (AbilityBonusEntity abilityBonuEntity : list) {
			AbilityBonusModel model = new AbilityBonusModel();
			model.setId(abilityBonuEntity.getId());
			model.setModifier(abilityBonuEntity.getModifier());
			model.setTrait(abilityBonuEntity.getTrait());
			modelList.add(model);
		}

		return modelList;
	}

	public static List<AbilityBonusEntity> getAbilityBonusEntityListFromAbilityBonusModelList(
			List<AbilityBonusModel> list) {

		List<AbilityBonusEntity> entityList = new ArrayList<AbilityBonusEntity>();

		for (AbilityBonusModel abilityBonuModel : list) {
			AbilityBonusEntity entity = new AbilityBonusEntity();
			entity.setId(abilityBonuModel.getId());
			entity.setModifier(abilityBonuModel.getModifier());
			entity.setTrait(abilityBonuModel.getTrait());
			entityList.add(entity);
		}

		return entityList;
	}

	public static Set<WeaponModel> getWeaponModelSetFromWeaponEntitySet(Set<WeaponEntity> weaponEntitySet) {

		Set<WeaponModel> weaponModelSet = new LinkedHashSet<WeaponModel>();

		for (WeaponEntity weaponEntity : weaponEntitySet) {
			weaponModelSet.add(getWeaponModelFromWeaponEntity(weaponEntity));
		}
		return weaponModelSet;
	}

	public static Set<WeaponEntity> getWeaponEntitySetFromWeaponModelSet(Set<WeaponModel> weaponModelSet) {

		Set<WeaponEntity> weaponEntitySet = new LinkedHashSet<WeaponEntity>();

		for (WeaponModel weaponModel : weaponModelSet) {
			weaponEntitySet.add(getWeaponEntityFromWeaponModel(weaponModel));
		}
		return weaponEntitySet;
	}

	public static WeaponEntity getWeaponEntityFromWeaponModel(WeaponModel weaponModel) {
		WeaponEntity weaponEntity = new WeaponEntity();
		weaponEntity.setName(weaponModel.getName());
		weaponEntity.setCost(weaponModel.getCost());
		weaponEntity.setCoin(weaponModel.getCoin());
		weaponEntity.setWeight(weaponModel.getWeight());
		weaponEntity.setWeaponProperties(weaponModel.getWeaponProperties());
		weaponEntity.setWeaponCategory(weaponModel.getWeaponCategory());
		weaponEntity.setDamage(weaponModel.getDamage());
		weaponEntity.setDamageType(weaponModel.getDamageType());
		weaponEntity.setMinRange(weaponModel.getMinRange());
		weaponEntity.setMaxRange(weaponModel.getMaxRange());
		return weaponEntity;
	}

	public static WeaponModel getWeaponModelFromWeaponEntity(WeaponEntity weaponEntity) {
		WeaponModel weaponModel = new WeaponModel();
		weaponModel.setId(weaponEntity.getId());
		weaponModel.setName(weaponEntity.getName());
		weaponModel.setCost(weaponEntity.getCost());
		weaponModel.setCoin(weaponEntity.getCoin());
		weaponModel.setWeight(weaponEntity.getWeight());
		weaponModel.setWeaponProperties(weaponEntity.getWeaponProperties());
		weaponModel.setWeaponCategory(weaponEntity.getWeaponCategory());
		weaponModel.setDamage(weaponEntity.getDamage());
		weaponModel.setDamageType(weaponEntity.getDamageType());
		weaponModel.setMinRange(weaponEntity.getMinRange());
		weaponModel.setMaxRange(weaponEntity.getMaxRange());
		return weaponModel;
	}

	public static ToolModel getToolModelFromToolEntity(ToolEntity toolEntity) {
		ToolModel toolModel = new ToolModel();
		toolModel.setId(toolEntity.getId());
		toolModel.setName(toolEntity.getName());
		toolModel.setToolType(toolEntity.getToolType());
		toolModel.setCost(toolEntity.getCost());
		toolModel.setCoin(toolEntity.getCoin());
		toolModel.setWeight(toolEntity.getWeight());
		toolModel.setDescription(toolEntity.getDescription());
		return toolModel;
	}

	public static ToolEntity getToolEntityFromToolModel(ToolModel toolModel) {
		ToolEntity toolEntity = new ToolEntity();
		toolEntity.setId(toolModel.getId());
		toolEntity.setName(toolModel.getName());
		toolEntity.setToolType(toolModel.getToolType());
		toolEntity.setCost(toolModel.getCost());
		toolEntity.setCoin(toolModel.getCoin());
		toolEntity.setWeight(toolModel.getWeight());
		toolEntity.setDescription(toolModel.getDescription());
		return toolEntity;
	}

	public static Set<ToolModel> getToolModelSetFromToolEntitySet(Set<ToolEntity> toolEntitySet) {
		Set<ToolModel> toolModelSet = new LinkedHashSet<ToolModel>();

		for (ToolEntity toolEntity : toolEntitySet) {
			toolModelSet.add(getToolModelFromToolEntity(toolEntity));
		}
		return toolModelSet;
	}	
}

package br.com.roleplay.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import br.com.roleplay.entity.AbilityBonusEntity;
import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.RaceEntity;
import br.com.roleplay.entity.ToolEntity;
import br.com.roleplay.entity.background.BackgroundEntity;
import br.com.roleplay.entity.background.BondEntity;
import br.com.roleplay.entity.background.FlawEntity;
import br.com.roleplay.entity.background.IdealEntity;
import br.com.roleplay.entity.background.PersonalityEntity;
import br.com.roleplay.entity.items.ArmorEntity;
import br.com.roleplay.entity.items.ItemEntity;
import br.com.roleplay.entity.items.OptionalItemEntity;
import br.com.roleplay.entity.items.WeaponEntity;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.model.ToolModel;
import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.background.BondModel;
import br.com.roleplay.model.background.FlawModel;
import br.com.roleplay.model.background.IdealModel;
import br.com.roleplay.model.background.PersonalityModel;
import br.com.roleplay.model.items.ArmorModel;
import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.model.items.OptionalItemModel;
import br.com.roleplay.model.items.WeaponModel;

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
			if(!isNullOrEmptyCollection(languageModel.getTypicalSpeakers())) {
				entity.setTypicalSpeakers(getRaceEntitySetFromRaceModelSet(languageModel.getTypicalSpeakers()));
			}
			languagelEntitySet.add(entity);
		}

		return languagelEntitySet;
	}

	private static <T> boolean isNullOrEmptyCollection(Collection<T> collection) {
		return collection == null || collection.isEmpty();
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
		copyProperties(weaponEntity, weaponModel);
		return weaponEntity;
	}

	public static WeaponModel getWeaponModelFromWeaponEntity(WeaponEntity weaponEntity) {
		WeaponModel weaponModel = new WeaponModel();
		copyProperties(weaponModel, weaponEntity);
		return weaponModel;
	}

	public static ToolModel getToolModelFromToolEntity(ToolEntity toolEntity) {
		ToolModel toolModel = new ToolModel();
		copyProperties(toolModel, toolEntity);
		return toolModel;
	}

	public static ToolEntity getToolEntityFromToolModel(ToolModel toolModel) {
		ToolEntity toolEntity = new ToolEntity();
		copyProperties(toolEntity, toolModel);
		return toolEntity;
	}

	public static Set<ToolModel> getToolModelSetFromToolEntitySet(Set<ToolEntity> toolEntitySet) {
		Set<ToolModel> toolModelSet = new LinkedHashSet<ToolModel>();

		for (ToolEntity toolEntity : toolEntitySet) {
			toolModelSet.add(getToolModelFromToolEntity(toolEntity));
		}
		return toolModelSet;
	}	
	
	public static void copyProperties(Object to, Object from){
		try {
			BeanUtils.copyProperties(to, from);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static Set<BackgroundModel> getBackgroundModelSetFromBackgroundEntitySet(Set<BackgroundEntity> backgroundSet) {
		Set<BackgroundModel> backgroundModelSet = new LinkedHashSet<BackgroundModel>();

		for (BackgroundEntity backgroundEntity : backgroundSet) {
			backgroundModelSet.add(getBackgroundModelFromBackgroundEntity(backgroundEntity));
		}
		return backgroundModelSet;
	}

	private static BackgroundModel getBackgroundModelFromBackgroundEntity(BackgroundEntity backgroundEntity){
		BackgroundModel backgroundModel = new BackgroundModel();
		backgroundModel.setId(backgroundEntity.getId());
		backgroundModel.setName(backgroundEntity.getName());
		backgroundModel.setSkillProficiencies(backgroundEntity.getSkillProficiencies());
		backgroundModel.setLanguages(getListFromSet(getLanguageModelSetFromLanguageEntitySet(getSetFromList(backgroundEntity.getLanguages()))));
		backgroundModel.setItems(getListFromSet(getItemModelSetFromItemEntitySet(getSetFromList(backgroundEntity.getItems()))));
		backgroundModel.setOptionalItems(getOptionalItemModelListFromOptionalItemEntityList(backgroundEntity.getOptionalItems()));
		backgroundModel.setFeatureDescriptionEn(backgroundEntity.getFeatureDescriptionEn());
		backgroundModel.setFeatureDescriptionPt(backgroundEntity.getFeatureDescriptionPt());
		backgroundModel.setCharacteristicsDescriptionEn(backgroundEntity.getCharacteristicsDescriptionEn());
		backgroundModel.setCharacteristicsDescriptionPt(backgroundEntity.getCharacteristicsDescriptionPt());
		return backgroundModel;
	}
	
	public static BackgroundEntity getBackgroundEntityFromBackgroundModel(BackgroundModel backgroundModel) {
		BackgroundEntity backgroundEntity = new BackgroundEntity();
		backgroundEntity.setId(backgroundModel.getId());
		backgroundEntity.setName(backgroundModel.getName());
		backgroundEntity.setSkillProficiencies(backgroundModel.getSkillProficiencies());
		if(backgroundModel.getLanguages() != null) {
			backgroundEntity.setLanguages(getListFromSet(getLanguageEntitySetFromLanguageModelSet(getSetFromList(backgroundModel.getLanguages()))));
		}
		if(backgroundModel.getItems() != null) {
			backgroundEntity.setItems(getItemEntityListFromItemModelList(backgroundModel.getItems()));
		}
		if(backgroundModel.getOptionalItems() != null) {
			backgroundEntity.setOptionalItems(getOptionalItemEntityListFromOptionalItemModelList(backgroundModel.getOptionalItems()));
		}
		backgroundEntity.setFeatureDescriptionEn(backgroundModel.getFeatureDescriptionEn());
		backgroundEntity.setFeatureDescriptionPt(backgroundModel.getFeatureDescriptionPt());
		backgroundEntity.setCharacteristicsDescriptionEn(backgroundModel.getCharacteristicsDescriptionEn());
		backgroundEntity.setCharacteristicsDescriptionPt(backgroundModel.getCharacteristicsDescriptionPt());
		return backgroundEntity;
	}

	public static Set<PersonalityModel> getPersonalityModelSetFromPersonalityEntitySet(Set<PersonalityEntity> personalitySet) {
		Set<PersonalityModel> personalityModelSet = new LinkedHashSet<PersonalityModel>();

		for (PersonalityEntity personalityEntity : personalitySet) {
			personalityModelSet.add(getPersonalityModelFromPersonalityEntity(personalityEntity));
		}
		return personalityModelSet;
	}

	private static PersonalityModel getPersonalityModelFromPersonalityEntity(PersonalityEntity personalityEntity) {
		PersonalityModel personalityModel = new PersonalityModel();
		personalityModel.setId(personalityEntity.getId());
		personalityModel.setValue(personalityEntity.getValue());
		personalityModel.setBackground(getBackgroundModelFromBackgroundEntity(personalityEntity.getBackground()));
		personalityModel.setDescriptionEn(personalityEntity.getDescriptionEn());
		personalityModel.setDescriptionPt(personalityEntity.getDescriptionPt());
		return personalityModel;
	}

	public static PersonalityEntity getPersonalityEntityFromPersonalityModel(PersonalityModel personalityModel) {
		PersonalityEntity entity = new PersonalityEntity();
		entity.setId(personalityModel.getId());
		entity.setValue(personalityModel.getValue());
		entity.setBackground(getBackgroundEntityFromBackgroundModel(personalityModel.getBackground()));
		entity.setDescriptionEn(personalityModel.getDescriptionEn());
		entity.setDescriptionPt(personalityModel.getDescriptionPt());
		return entity;
	}

	public static IdealEntity getIdealEntityFromIdealModel(IdealModel idealModel) {
		IdealEntity entity = new IdealEntity();
		entity.setId(idealModel.getId());
		entity.setValue(idealModel.getValue());
		entity.setBackground(getBackgroundEntityFromBackgroundModel(idealModel.getBackground()));
		entity.setDescriptionEn(idealModel.getDescriptionEn());
		entity.setDescriptionPt(idealModel.getDescriptionPt());
		return entity;
	}

	public static Set<IdealModel> getIdealModelSetFromIdealEntitySet(Set<IdealEntity> idealSet) {
		Set<IdealModel> idealModelSet = new LinkedHashSet<IdealModel>();

		for (IdealEntity idealEntity : idealSet) {
			idealModelSet.add(getIdealModelFromIdealEntity(idealEntity));
		}
		return idealModelSet;
	}

	private static IdealModel getIdealModelFromIdealEntity(IdealEntity idealEntity) {
		IdealModel idealModel = new IdealModel();
		idealModel.setId(idealEntity.getId());
		idealModel.setValue(idealEntity.getValue());
		idealModel.setBackground(getBackgroundModelFromBackgroundEntity(idealEntity.getBackground()));
		idealModel.setDescriptionEn(idealEntity.getDescriptionEn());
		idealModel.setDescriptionPt(idealEntity.getDescriptionPt());
		return idealModel;
	}

	public static BondEntity getBondEntityFromBondModel(BondModel bondModel) {
		BondEntity bondEntity = new BondEntity();
		bondEntity.setId(bondModel.getId());
		bondEntity.setValue(bondModel.getValue());
		bondEntity.setBackground(getBackgroundEntityFromBackgroundModel(bondModel.getBackground()));
		bondEntity.setDescriptionEn(bondModel.getDescriptionEn());
		bondEntity.setDescriptionPt(bondModel.getDescriptionPt());
		return bondEntity;
	}

	public static Set<BondModel> getBondModelSetFromBondEntitySet(Set<BondEntity> bondEntitySet) {
		Set<BondModel> bondModelSet = new LinkedHashSet<BondModel>();

		for (BondEntity bondEntity : bondEntitySet) {
			bondModelSet.add(getBondModelFromBondEntity(bondEntity));
		}
		return bondModelSet;
	}

	private static BondModel getBondModelFromBondEntity(BondEntity bondEntity) {
		BondModel bondModel = new BondModel();
		bondModel.setId(bondEntity.getId());
		bondModel.setValue(bondEntity.getValue());
		bondModel.setBackground(getBackgroundModelFromBackgroundEntity(bondEntity.getBackground()));
		bondModel.setDescriptionEn(bondEntity.getDescriptionEn());
		bondModel.setDescriptionPt(bondEntity.getDescriptionPt());
		return bondModel;
	}
	
	public static FlawEntity getFlawEntityFromFlawModel(FlawModel flawModel) {
		FlawEntity flawEntity = new FlawEntity();
		flawEntity.setId(flawModel.getId());
		flawEntity.setValue(flawModel.getValue());
		flawEntity.setBackground(getBackgroundEntityFromBackgroundModel(flawModel.getBackground()));
		flawEntity.setDescriptionEn(flawModel.getDescriptionEn());
		flawEntity.setDescriptionPt(flawModel.getDescriptionPt());
		return flawEntity;
	}

	public static Set<FlawModel> getFlawModelSetFromFlawEntitySet(Set<FlawEntity> flawEntitySet) {
		Set<FlawModel> flawModelSet = new LinkedHashSet<FlawModel>();

		for (FlawEntity flawEntity : flawEntitySet) {
			flawModelSet.add(getFlawModelFromFlawEntity(flawEntity));
		}
		return flawModelSet;
	}

	private static FlawModel getFlawModelFromFlawEntity(FlawEntity flawEntity) {
		FlawModel flawModel = new FlawModel();
		flawModel.setId(flawEntity.getId());
		flawModel.setValue(flawEntity.getValue());
		flawModel.setBackground(getBackgroundModelFromBackgroundEntity(flawEntity.getBackground()));
		flawModel.setDescriptionEn(flawEntity.getDescriptionEn());
		flawModel.setDescriptionPt(flawEntity.getDescriptionPt());
		return flawModel;
	}

	public static Set<ItemModel> getItemModelSetFromItemEntitySet(Set<ItemEntity> itemEntitySet) {
		Set<ItemModel> itemModelSet = new LinkedHashSet<ItemModel>();
		
		for (ItemEntity itemEntity : itemEntitySet) {
			ItemModel itemModel = new ItemModel();
			copyProperties(itemModel, itemEntity);
			itemModelSet.add(itemModel);
		}
		
		return itemModelSet;
	}
	
	public static List<ItemEntity> getItemEntityListFromItemModelList(List<ItemModel> itemModelList) {
		List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();
		
		for (ItemModel itemModel : itemModelList) {
			ItemEntity itemEntity = new ItemEntity();
			copyProperties(itemEntity, itemModel);
			itemEntityList.add(itemEntity);
		}
		
		return itemEntityList;
	}

	public static Set<OptionalItemModel> getOptionalItemModelSetFromOptionalItemEntitySet(Set<OptionalItemEntity> optionalItemEntitySet) {
		Set<OptionalItemModel> optionalItemModelSet = new LinkedHashSet<OptionalItemModel>();
		
		for (OptionalItemEntity optionalItemEntity : optionalItemEntitySet) {
			optionalItemModelSet.add(getOptionalItemModelFromOptionalItemEntity(optionalItemEntity));
		}
		
		return optionalItemModelSet;
	}
	
	public static List<OptionalItemModel> getOptionalItemModelListFromOptionalItemEntityList(List<OptionalItemEntity> optionalItemEntityList) {
		List<OptionalItemModel> optionalItemModelList = new ArrayList<OptionalItemModel>();
		
		for (OptionalItemEntity optionalItemEntity : optionalItemEntityList) {
			optionalItemModelList.add(getOptionalItemModelFromOptionalItemEntity(optionalItemEntity));
		}
		
		return optionalItemModelList;
	}

	public static OptionalItemEntity getOptionalItemEntityFromOptionalItemModel(OptionalItemModel optionalItemModel) {
		OptionalItemEntity optionalItemEntity = new OptionalItemEntity();
		optionalItemEntity.setId(optionalItemModel.getId());
		if(optionalItemModel.getBackground() != null) {
			optionalItemEntity.setBackground(getBackgroundEntityFromBackgroundModel(optionalItemModel.getBackground()));
		}
		optionalItemEntity.setCod(optionalItemModel.getCod());
		if(optionalItemModel.getItems() != null) {
			optionalItemEntity.setItems(getItemEntityListFromItemModelList(optionalItemModel.getItems()));
		}
		return optionalItemEntity;
	}
	
	public static OptionalItemModel getOptionalItemModelFromOptionalItemEntity(OptionalItemEntity optionalItemEntity) {
		OptionalItemModel optionalItemModel = new OptionalItemModel();
		optionalItemModel.setId(optionalItemEntity.getId());
		BackgroundModel bm = new BackgroundModel();
		bm.setId(optionalItemEntity.getId());
		optionalItemModel.setBackground(bm);
		optionalItemModel.setCod(optionalItemEntity.getCod());
		optionalItemModel.setItems(getListFromSet(getItemModelSetFromItemEntitySet(getSetFromList(optionalItemEntity.getItems()))));
		return optionalItemModel;
	}
	
	private static List<OptionalItemEntity> getOptionalItemEntityListFromOptionalItemModelList(List<OptionalItemModel> optionalItemModelList) {
		List<OptionalItemEntity> optionalItemEntityList = new ArrayList<OptionalItemEntity>();
		
		for (OptionalItemModel optionalItemEntity : optionalItemModelList) {
			optionalItemEntityList.add(getOptionalItemEntityFromOptionalItemModel(optionalItemEntity));
		}
		
		return optionalItemEntityList;
	}

	public static ArmorEntity getArmorEntityFromArmorModel(ArmorModel armorModel) {
		ArmorEntity armorEntity = new ArmorEntity();
		copyProperties(armorEntity, armorModel);
		return armorEntity;
	}
	
	public static ArmorModel getArmorModelFromArmorEntity(ArmorEntity armorEntity) {
		ArmorModel armorModel = new ArmorModel();
		copyProperties(armorModel, armorEntity);
		return armorModel;
	}

	public static Set<ArmorModel> getArmorModelSetFromArmorEntitySet(Set<ArmorEntity> armorEntitySet) {
		Set<ArmorModel> armorModelList = new LinkedHashSet<ArmorModel>();
		
		for (ArmorEntity armorEntity : armorEntitySet) {
			armorModelList.add(getArmorModelFromArmorEntity(armorEntity));
		}
		
		return armorModelList;
	}
	
}

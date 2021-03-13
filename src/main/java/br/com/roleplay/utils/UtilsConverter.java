package br.com.roleplay.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.roleplay.entity.AbilityBonusEntity;
import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.RaceEntity;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;

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
	
	public static Set<LanguageModel> getLanguageModelSetFromLanguageEntitySet(Set<LanguageEntity> languageEntitySet){
		
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
	
	public static Set<LanguageEntity> getLanguageEntitySetFromLanguageModelSet(Set<LanguageModel> languageModelSet){
		
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
	
	public static Set<RaceModel> getSetRaceModelFromSetRaceEntity(Set<RaceEntity> raceEntitySet){
		
		Set<RaceModel> raceModelSet = new LinkedHashSet<RaceModel>();
		
		for (RaceEntity raceEntity : raceEntitySet) {
			RaceModel raceModel = new RaceModel();
			raceModel.setName(raceEntity.getName());
			raceModel.setAge(raceEntity.getAge());
			raceModel.setAbilityBonus(getAbilityBonusModelListFromAbilityBonusEntityList(raceEntity.getAbilityBonus()));
			raceModel.setMovement(raceEntity.getMovement());
			raceModel.setSpeed(raceEntity.getSpeed());
			raceModel.setBaseHeight(raceEntity.getBaseHeight());
			raceModel.setBaseWeight(raceEntity.getBaseWeight());
			raceModel.setAlignment(raceEntity.getAlignment());
			raceModelSet.add(raceModel);
		}		
		return raceModelSet;
	}
	
	public static Set<RaceEntity> getRaceEntitySetFromRaceModelSet(Set<RaceModel> raceModelSet){
		
		Set<RaceEntity> raceEntitySet = new LinkedHashSet<RaceEntity>();
		
		for (RaceModel raceModel : raceModelSet) {
			RaceEntity raceEntity = new RaceEntity();
			raceEntity.setName(raceModel.getName());
			raceEntity.setAge(raceModel.getAge());
			raceEntity.setAbilityBonus(getAbilityBonusEntityListFromAbilityBonusModelList(raceModel.getAbilityBonus()));
			raceEntity.setMovement(raceModel.getMovement());
			raceEntity.setSpeed(raceModel.getSpeed());
			raceEntity.setBaseHeight(raceModel.getBaseHeight());
			raceEntity.setBaseWeight(raceModel.getBaseWeight());
			raceEntity.setAlignment(raceModel.getAlignment());
			raceEntitySet.add(raceEntity);
		}		
		return raceEntitySet;
	}
	
	public static List<AbilityBonusModel> getAbilityBonusModelListFromAbilityBonusEntityList(List<AbilityBonusEntity> list){
		
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
	
	public static List<AbilityBonusEntity> getAbilityBonusEntityListFromAbilityBonusModelList(List<AbilityBonusModel> list){
		
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
}
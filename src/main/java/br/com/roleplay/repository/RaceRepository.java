package br.com.roleplay.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.roleplay.entity.AbilityBonusEntity;
import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.RaceEntity;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class RaceRepository {

	@Inject
	RaceEntity raceEntity;

	EntityManager entityManager;

	public void insertRace(RaceModel raceModel) {

		entityManager = Utils.JpaEntityManager();

		raceEntity = new RaceEntity();

		raceEntity.setName(raceModel.getName());
		raceEntity.setAge(raceModel.getAge());
		raceEntity.setBaseHeight(raceModel.getBaseHeight());
		raceEntity.setBaseWeight(raceModel.getBaseWeight());
		raceEntity.setAlignment(raceModel.getAlignment());
		raceEntity.setMovement(raceModel.getMovement());
		raceEntity.setSpeed(raceModel.getSpeed());
		raceEntity.setSize(raceModel.getSize());
		raceEntity.setHeightModifier(raceModel.getHeightModifier());
		raceEntity.setWeightModifier(raceModel.getWeightModifier());

		Set<LanguageEntity> languages = new HashSet<LanguageEntity>();
		for (LanguageModel language : raceModel.getLanguages()) {
			LanguageEntity le = entityManager.find(LanguageEntity.class, language.getId());
			languages.add(le);
		}

		List<AbilityBonusEntity> abilityBonusList = new ArrayList<AbilityBonusEntity>();
		for (AbilityBonusModel abilityBonus : raceModel.getAbilityBonus()) {
			AbilityBonusEntity abe = entityManager.find(AbilityBonusEntity.class, abilityBonus.getId());
			abilityBonusList.add(abe);
		}

		raceEntity.setLanguages(languages);
		raceEntity.setAbilityBonus(abilityBonusList);
		
		entityManager.persist(raceEntity);

	}

	public Set<RaceModel> getAllRaces() {

		entityManager = Utils.JpaEntityManager();

		Query query = entityManager.createNamedQuery("RaceEntity.findAll");

		@SuppressWarnings("unchecked")
		Set<RaceEntity> pessoasEntity = UtilsConverter.getSetFromList(query.getResultList());

		return UtilsConverter.getSetRaceModelFromSetRaceEntity(pessoasEntity);
	}

	public void updateRace(RaceModel raceModel) {

		entityManager = Utils.JpaEntityManager();

		RaceEntity raceEntity = this.getRace(raceModel.getId());

		raceEntity.setName(raceModel.getName());
		raceEntity.setAge(raceModel.getAge());
		raceEntity.setBaseHeight(raceModel.getBaseHeight());
		raceEntity.setBaseWeight(raceModel.getBaseWeight());
		raceEntity.setAlignment(raceModel.getAlignment());
		raceEntity.setMovement(raceModel.getMovement());
		raceEntity.setSpeed(raceModel.getSpeed());
		raceEntity.setSize(raceModel.getSize());
		raceEntity.setHeightModifier(raceModel.getHeightModifier());
		raceEntity.setWeightModifier(raceModel.getWeightModifier());

		Set<LanguageEntity> languages = new HashSet<LanguageEntity>();
		for (LanguageModel language : raceModel.getLanguages()) {
			LanguageEntity le = entityManager.find(LanguageEntity.class, language.getId());
			languages.add(le);
		}

		List<AbilityBonusEntity> abilityBonusList = new ArrayList<AbilityBonusEntity>();
		for (AbilityBonusModel abilityBonus : raceModel.getAbilityBonus()) {
			AbilityBonusEntity abe = entityManager.find(AbilityBonusEntity.class, abilityBonus.getId());
			abilityBonusList.add(abe);
		}

		raceEntity.setLanguages(languages);
		raceEntity.setAbilityBonus(abilityBonusList);

		entityManager.merge(raceEntity);
	}

	private RaceEntity getRace(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(RaceEntity.class, id);
	}
	
	public void deleteRace(long id) {

		entityManager = Utils.JpaEntityManager();

		RaceEntity languageEntity = this.getRace(id);

		entityManager.remove(languageEntity);
	}
}

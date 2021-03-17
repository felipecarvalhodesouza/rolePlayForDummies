package br.com.roleplay.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.AbilityBonusEntity;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class AbilityBonusRepository {

	@Inject
	AbilityBonusEntity abilityBonusEntity;

	EntityManager entityManager;

	public List<AbilityBonusModel> getAllAbilityBonus() {
		
		entityManager = Utils.JpaEntityManager();
		
		TypedQuery<AbilityBonusEntity> query = entityManager.createNamedQuery("AbilityBonusEntity.findAll", AbilityBonusEntity.class);
		
		List<AbilityBonusEntity> resultList = query.getResultList();
		
		return UtilsConverter.getAbilityBonusModelListFromAbilityBonusEntityList(resultList);
	}
}

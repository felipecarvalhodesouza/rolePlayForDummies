package br.com.roleplay.repository;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.IdealEntity;
import br.com.roleplay.model.IdealModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class IdealRepository {

	@Inject
	IdealEntity idealEntity;

	EntityManager entityManager;

	public void insertIdeal(IdealModel idealModel) {

		entityManager = Utils.JpaEntityManager();
		
		idealEntity = UtilsConverter.getIdealEntityFromIdealModel(idealModel);

		
		entityManager.persist(idealEntity);
		
		entityManager.flush();
	}

	public Set<IdealModel> getAllPersonalities() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from IdealEntity t order by background_id, value";

		TypedQuery<IdealEntity> query = entityManager.createQuery(jpql, IdealEntity.class);
		Set<IdealEntity> idealSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getIdealModelSetFromIdealEntitySet(idealSet);
	}

	private IdealEntity getIdeal(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(IdealEntity.class, id);
	}

	public void deleteIdeal(long id) {

		entityManager = Utils.JpaEntityManager();

		IdealEntity idealEntity = this.getIdeal(id);

		entityManager.remove(idealEntity);
	}
	
	public void updateIdeal(IdealModel idealModel) {
		entityManager = Utils.JpaEntityManager();

		IdealEntity idealEntity = this.getIdeal(idealModel.getId());
		
		UtilsConverter.copyProperties(idealEntity, idealModel);

		entityManager.merge(idealEntity);
	}

}

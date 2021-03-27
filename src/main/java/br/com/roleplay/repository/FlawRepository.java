package br.com.roleplay.repository;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.FlawEntity;
import br.com.roleplay.model.FlawModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class FlawRepository {

	@Inject
	FlawEntity flawEntity;

	EntityManager entityManager;

	public void insertFlaw(FlawModel flawModel) {

		entityManager = Utils.JpaEntityManager();
		
		flawEntity = UtilsConverter.getFlawEntityFromFlawModel(flawModel);

		
		entityManager.persist(flawEntity);
		
		entityManager.flush();
	}

	public Set<FlawModel> getAllPersonalities() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from FlawEntity t order by background_id, value";

		TypedQuery<FlawEntity> query = entityManager.createQuery(jpql, FlawEntity.class);
		Set<FlawEntity> flawSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getFlawModelSetFromFlawEntitySet(flawSet);
	}

	private FlawEntity getFlaw(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(FlawEntity.class, id);
	}

	public void deleteFlaw(long id) {

		entityManager = Utils.JpaEntityManager();

		FlawEntity flawEntity = this.getFlaw(id);

		entityManager.remove(flawEntity);
	}
	
	public void updateFlaw(FlawModel flawModel) {
		entityManager = Utils.JpaEntityManager();

		FlawEntity flawEntity = this.getFlaw(flawModel.getId());
		
		UtilsConverter.copyProperties(flawEntity, flawModel);

		entityManager.merge(flawEntity);
	}

}

package br.com.roleplay.repository;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.BondEntity;
import br.com.roleplay.model.BondModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class BondRepository {

	@Inject
	BondEntity bondEntity;

	EntityManager entityManager;

	public void insertBond(BondModel bondModel) {

		entityManager = Utils.JpaEntityManager();
		
		bondEntity = UtilsConverter.getBondEntityFromBondModel(bondModel);

		
		entityManager.persist(bondEntity);
		
		entityManager.flush();
	}

	public Set<BondModel> getAllPersonalities() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from BondEntity t order by background_id, value";

		TypedQuery<BondEntity> query = entityManager.createQuery(jpql, BondEntity.class);
		Set<BondEntity> bondSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getBondModelSetFromBondEntitySet(bondSet);
	}

	private BondEntity getBond(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(BondEntity.class, id);
	}

	public void deleteBond(long id) {

		entityManager = Utils.JpaEntityManager();

		BondEntity bondEntity = this.getBond(id);

		entityManager.remove(bondEntity);
	}
	
	public void updateBond(BondModel bondModel) {
		entityManager = Utils.JpaEntityManager();

		BondEntity bondEntity = this.getBond(bondModel.getId());
		
		UtilsConverter.copyProperties(bondEntity, bondModel);

		entityManager.merge(bondEntity);
	}

}

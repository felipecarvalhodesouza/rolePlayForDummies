package br.com.roleplay.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.ProficiencyEntity;
import br.com.roleplay.model.ProficiencyModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class ProficiencyRepository {

	@Inject
	ProficiencyEntity proficiencyEntity;

	EntityManager entityManager;

	public void insertProficiency(ProficiencyModel proficiencyModel) {

		entityManager = Utils.JpaEntityManager();

		proficiencyEntity = UtilsConverter.getProficientyEntityFromProficiencyModel(proficiencyModel);
		
		entityManager.persist(proficiencyEntity);
		entityManager.flush();
	}

	public List<ProficiencyModel> getAllProficiencies() {

		entityManager = Utils.JpaEntityManager();
		
		String jpql = "select p from ProficiencyEntity p order by cod";

		TypedQuery<ProficiencyEntity> query = entityManager.createQuery(jpql, ProficiencyEntity.class);
		return UtilsConverter.getProficiencyModelListFromProficiencyEntityList(query.getResultList());
	}

	public void updateProficiency(ProficiencyModel proficiencyModel) {

		entityManager = Utils.JpaEntityManager();

		ProficiencyEntity proficiencyEntity = this.getProficiency(proficiencyModel.getId());

		entityManager.merge(proficiencyEntity);
	}

	private ProficiencyEntity getProficiency(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(ProficiencyEntity.class, id);
	}
	
	public void deleteProficiency(long id) {

		entityManager = Utils.JpaEntityManager();

		ProficiencyEntity languageEntity = this.getProficiency(id);

		entityManager.remove(languageEntity);
	}
}

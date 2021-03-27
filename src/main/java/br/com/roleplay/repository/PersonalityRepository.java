package br.com.roleplay.repository;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.PersonalityEntity;
import br.com.roleplay.model.PersonalityModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class PersonalityRepository {

	@Inject
	PersonalityEntity personalityEntity;

	EntityManager entityManager;

	public void insertPersonality(PersonalityModel personalityModel) {

		entityManager = Utils.JpaEntityManager();
		
		personalityEntity = UtilsConverter.getPersonalityEntityFromPersonalityModel(personalityModel);

		
		entityManager.persist(personalityEntity);
		
		entityManager.flush();
	}

	public Set<PersonalityModel> getAllPersonalities() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from PersonalityEntity t order by background_id, value";

		TypedQuery<PersonalityEntity> query = entityManager.createQuery(jpql, PersonalityEntity.class);
		Set<PersonalityEntity> personalitySet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getPersonalityModelSetFromPersonalityEntitySet(personalitySet);
	}

	private PersonalityEntity getPersonality(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(PersonalityEntity.class, id);
	}

	public void deletePersonality(long id) {

		entityManager = Utils.JpaEntityManager();

		PersonalityEntity personalityEntity = this.getPersonality(id);

		entityManager.remove(personalityEntity);
	}
	
	public void updatePersonality(PersonalityModel personalityModel) {
		entityManager = Utils.JpaEntityManager();

		PersonalityEntity personalityEntity = this.getPersonality(personalityModel.getId());
		
		UtilsConverter.copyProperties(personalityEntity, personalityModel);

		entityManager.merge(personalityEntity);
	}

}

package br.com.roleplay.repository;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.entity.RaceEntity;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class LanguageRepository {
	
	@Inject
	LanguageEntity languageEntity;
	
	EntityManager entityManager;
	
	public void insertLanguage(LanguageModel languageModel) {
		
		entityManager = Utils.JpaEntityManager();
		
		languageEntity = new LanguageEntity();
		
		languageEntity.setName(languageModel.getName());
		languageEntity.setScript(languageModel.getScript());
		languageEntity.setLanguageType(languageModel.getLanguageType());
		
		Set<RaceEntity> typicalSpeakersList = new HashSet<RaceEntity>();
		for(RaceModel race: languageModel.getTypicalSpeakers()) {
			RaceEntity re = entityManager.find(RaceEntity.class, race.getId());
			typicalSpeakersList.add(re);
		}
		
		languageEntity.setTypicalSpeakers(typicalSpeakersList);		
		
		entityManager.persist(languageEntity);
		
	}

	public Set<LanguageModel> getAllLanguages() {
		
		entityManager = Utils.JpaEntityManager();
		
		String jpql = "select l from LanguageEntity l order by name";
		
		TypedQuery<LanguageEntity> query = entityManager.createQuery(jpql, LanguageEntity.class);
		Set<LanguageEntity> languageSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getLanguageModelSetFromLanguageEntitySet(languageSet);
	}
	
	public void updateLanguage(LanguageModel languageModel){
		 
		entityManager =  Utils.JpaEntityManager();
 
		LanguageEntity languageEntity = this.getLanguage(languageModel.getId());
		
		languageEntity.setName(languageModel.getName());
		languageEntity.setLanguageType(languageModel.getLanguageType());
		languageEntity.setTypicalSpeakers(UtilsConverter.getRaceEntitySetFromRaceModelSet(languageModel.getTypicalSpeakers()));
		languageEntity.setScript(languageModel.getScript());
 
		entityManager.merge(languageEntity);
	}
	
	private LanguageEntity getLanguage(long id){
		 
		entityManager =  Utils.JpaEntityManager();
 
		return entityManager.find(LanguageEntity.class, id);
	}

}

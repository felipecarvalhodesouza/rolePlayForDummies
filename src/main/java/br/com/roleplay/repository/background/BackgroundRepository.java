package br.com.roleplay.repository.background;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.background.BackgroundEntity;
import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class BackgroundRepository {

	@Inject
	BackgroundEntity backgroundEntity;

	EntityManager entityManager;

	public void insertBackground(BackgroundModel backgroundModel) {

		entityManager = Utils.JpaEntityManager();

		backgroundEntity = UtilsConverter.getBackgroundEntityFromBackgroundModel(backgroundModel);
		
		entityManager.persist(backgroundEntity);
		entityManager.flush();
		
	}

	public Set<BackgroundModel> getAllBackgrounds() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from BackgroundEntity t order by name";

		TypedQuery<BackgroundEntity> query = entityManager.createQuery(jpql, BackgroundEntity.class);
		Set<BackgroundEntity> backgroundSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getBackgroundModelSetFromBackgroundEntitySet(backgroundSet);
	}

	private BackgroundEntity getBackground(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(BackgroundEntity.class, id);
	}

	public void deleteBackground(long id) {

		entityManager = Utils.JpaEntityManager();

		BackgroundEntity backgroundEntity = this.getBackground(id);

		entityManager.remove(backgroundEntity);
	}
	
	public void updateBackground(BackgroundModel backgroundModel) {
		entityManager = Utils.JpaEntityManager();

		BackgroundEntity backgroundEntity = this.getBackground(backgroundModel.getId());

		backgroundEntity = UtilsConverter.getBackgroundEntityFromBackgroundModel(backgroundModel);

		entityManager.merge(backgroundEntity);
	}

}

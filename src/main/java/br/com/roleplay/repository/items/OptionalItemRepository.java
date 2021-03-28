package br.com.roleplay.repository.items;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.items.OptionalItemEntity;
import br.com.roleplay.model.items.OptionalItemModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class OptionalItemRepository {

	@Inject
	OptionalItemEntity optionalItemEntity;	

	EntityManager entityManager;

	public void insertOptionalItem(OptionalItemModel optionalItemModel) {

		entityManager = Utils.JpaEntityManager();
		
		optionalItemEntity = UtilsConverter.getOptionalItemEntityFromOptionalItemModel(optionalItemModel);
		
		entityManager.persist(optionalItemEntity);		
		entityManager.flush();
	}

	public Set<OptionalItemModel> getAllOptionalItems() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select oi from OptionalItemEntity oi order by background_id, cod";

		TypedQuery<OptionalItemEntity> query = entityManager.createQuery(jpql, OptionalItemEntity.class);
		Set<OptionalItemEntity> optionalItemSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getOptionalItemModelSetFromOptionalItemEntitySet(optionalItemSet);
	}

	private OptionalItemEntity getOptionalItem(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(OptionalItemEntity.class, id);
	}

	public void deleteOptionalItem(long id) {

		entityManager = Utils.JpaEntityManager();

		OptionalItemEntity optionalItemEntity = this.getOptionalItem(id);

		entityManager.remove(optionalItemEntity);
	}
	
	public void updateOptionalItem(OptionalItemModel optionalItemModel) {
		entityManager = Utils.JpaEntityManager();

		OptionalItemEntity optionalItemEntity = this.getOptionalItem(optionalItemModel.getId());
		
		optionalItemEntity = UtilsConverter.getOptionalItemEntityFromOptionalItemModel(optionalItemModel);

		entityManager.merge(optionalItemEntity);
	}

}

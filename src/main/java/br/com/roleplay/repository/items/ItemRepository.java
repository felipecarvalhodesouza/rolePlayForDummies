package br.com.roleplay.repository.items;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.items.ItemEntity;
import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class ItemRepository {

	@Inject
	ItemEntity itemEntity;

	EntityManager entityManager;

	public void insertItem(ItemModel itemModel) {

		entityManager = Utils.JpaEntityManager();
		
		UtilsConverter.copyProperties(itemEntity, itemModel);
		
		entityManager.persist(itemEntity);
		
		entityManager.flush();
	}

	public Set<ItemModel> getAllItems() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from ItemEntity t order by name";

		TypedQuery<ItemEntity> query = entityManager.createQuery(jpql, ItemEntity.class);
		Set<ItemEntity> itemSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getItemModelSetFromItemEntitySet(itemSet);
	}

	private ItemEntity getItem(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(ItemEntity.class, id);
	}

	public void deleteItem(long id) {

		entityManager = Utils.JpaEntityManager();

		ItemEntity itemEntity = this.getItem(id);

		entityManager.remove(itemEntity);
	}
	
	public void updateItem(ItemModel itemModel) {
		entityManager = Utils.JpaEntityManager();

		ItemEntity itemEntity = this.getItem(itemModel.getId());
		
		UtilsConverter.copyProperties(itemEntity, itemModel);

		entityManager.merge(itemEntity);
	}

}

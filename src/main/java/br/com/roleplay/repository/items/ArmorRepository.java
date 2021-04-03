package br.com.roleplay.repository.items;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.items.ArmorEntity;
import br.com.roleplay.model.items.ArmorModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class ArmorRepository {

	@Inject
	ArmorEntity armorEntity;

	EntityManager entityManager;

	public void insertArmor(ArmorModel armorModel) {

		entityManager = Utils.JpaEntityManager();

		armorEntity = UtilsConverter.getArmorEntityFromArmorModel(armorModel);

		entityManager.persist(armorEntity);
	}

	public Set<ArmorModel> getAllArmors() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select l from ArmorEntity l order by name";

		TypedQuery<ArmorEntity> query = entityManager.createQuery(jpql, ArmorEntity.class);
		Set<ArmorEntity> armorSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getArmorModelSetFromArmorEntitySet(armorSet);
	}

	private ArmorEntity getArmor(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(ArmorEntity.class, id);
	}

	public void deleteArmor(long id) {

		entityManager = Utils.JpaEntityManager();

		ArmorEntity armorEntity = this.getArmor(id);

		entityManager.remove(armorEntity);
	}

	public void updateArmor(ArmorModel armorModel) {
		entityManager = Utils.JpaEntityManager();

		ArmorEntity armorEntity = this.getArmor(armorModel.getId());

		UtilsConverter.copyProperties(armorEntity, armorModel);
		
		entityManager.merge(armorEntity);
	}

}

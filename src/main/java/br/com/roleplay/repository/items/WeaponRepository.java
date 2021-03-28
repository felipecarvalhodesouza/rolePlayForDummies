package br.com.roleplay.repository.items;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.items.WeaponEntity;
import br.com.roleplay.model.items.WeaponModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class WeaponRepository {

	@Inject
	WeaponEntity weaponEntity;

	EntityManager entityManager;

	public void insertWeapon(WeaponModel weaponModel) {

		entityManager = Utils.JpaEntityManager();

		weaponEntity = UtilsConverter.getWeaponEntityFromWeaponModel(weaponModel);

		entityManager.persist(weaponEntity);
		entityManager.flush();
	}

	public Set<WeaponModel> getAllWeapons() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select l from WeaponEntity l order by name";

		TypedQuery<WeaponEntity> query = entityManager.createQuery(jpql, WeaponEntity.class);
		Set<WeaponEntity> weaponSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getWeaponModelSetFromWeaponEntitySet(weaponSet);
	}

	private WeaponEntity getWeapon(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(WeaponEntity.class, id);
	}

	public void deleteWeapon(long id) {

		entityManager = Utils.JpaEntityManager();

		WeaponEntity weaponEntity = this.getWeapon(id);

		entityManager.remove(weaponEntity);
	}

	public void updateWeapon(WeaponModel weaponModel) {
		entityManager = Utils.JpaEntityManager();

		WeaponEntity weaponEntity = this.getWeapon(weaponModel.getId());

		weaponEntity.setName(weaponModel.getName());
		weaponEntity.setCost(weaponModel.getCost());
		weaponEntity.setCoin(weaponModel.getCoin());
		weaponEntity.setWeight(weaponModel.getWeight());
		weaponEntity.setWeaponProperties(weaponModel.getWeaponProperties());
		weaponEntity.setWeaponCategory(weaponModel.getWeaponCategory());
		weaponEntity.setDamage(weaponModel.getDamage());
		weaponEntity.setDamageType(weaponModel.getDamageType());
		weaponEntity.setMinRange(weaponModel.getMinRange());
		weaponEntity.setMaxRange(weaponModel.getMaxRange());
		
		entityManager.merge(weaponEntity);
	}

}

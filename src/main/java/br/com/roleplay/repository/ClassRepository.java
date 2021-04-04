package br.com.roleplay.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.ClassEntity;
import br.com.roleplay.model.ClassModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class ClassRepository {

	@Inject
	ClassEntity classEntity;

	EntityManager entityManager;

	public void insertClass(ClassModel classModel) {

		entityManager = Utils.JpaEntityManager();

		classEntity = UtilsConverter.getClassEntityFromClassModel(classModel);
		
		entityManager.persist(classEntity);
		
		entityManager.flush();
	}

	public List<ClassModel> getAllClasses() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select c from ClassEntity c order by name";

		TypedQuery<ClassEntity> query = entityManager.createQuery(jpql, ClassEntity.class);
		return UtilsConverter.getClassModelListFromClassEntityList(query.getResultList());
	}

	private ClassEntity getClass(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(ClassEntity.class, id);
	}

	public void deleteClass(long id) {

		entityManager = Utils.JpaEntityManager();

		ClassEntity classEntity = this.getClass(id);

		entityManager.remove(classEntity);
	}
	
	public void updateClass(ClassModel classModel) {
		entityManager = Utils.JpaEntityManager();

		entityManager.merge(UtilsConverter.getClassEntityFromClassModel(classModel));
	}

}

package br.com.roleplay.repository;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.roleplay.entity.ToolEntity;
import br.com.roleplay.model.ToolModel;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

public class ToolRepository {

	@Inject
	ToolEntity toolEntity;

	EntityManager entityManager;

	public void insertTool(ToolModel toolModel) {

		entityManager = Utils.JpaEntityManager();

		toolEntity = UtilsConverter.getToolEntityFromToolModel(toolModel);
		
		entityManager.persist(toolEntity);
		
		entityManager.flush();
	}

	public Set<ToolModel> getAllTools() {

		entityManager = Utils.JpaEntityManager();

		String jpql = "select t from ToolEntity t order by name";

		TypedQuery<ToolEntity> query = entityManager.createQuery(jpql, ToolEntity.class);
		Set<ToolEntity> toolSet = UtilsConverter.getSetFromList(query.getResultList());
		return UtilsConverter.getToolModelSetFromToolEntitySet(toolSet);
	}

	private ToolEntity getTool(long id) {

		entityManager = Utils.JpaEntityManager();

		return entityManager.find(ToolEntity.class, id);
	}

	public void deleteTool(long id) {

		entityManager = Utils.JpaEntityManager();

		ToolEntity toolEntity = this.getTool(id);

		entityManager.remove(toolEntity);
	}
	
	public void updateTool(ToolModel toolModel) {
		entityManager = Utils.JpaEntityManager();

		ToolEntity toolEntity = this.getTool(toolModel.getId());

		toolEntity.setName(toolModel.getName());
		toolEntity.setToolType(toolModel.getToolType());
		toolEntity.setCost(toolModel.getCost());
		toolEntity.setCoin(toolModel.getCoin());
		toolEntity.setWeight(toolModel.getWeight());
		toolEntity.setDescription(toolModel.getDescription());

		entityManager.merge(toolEntity);
	}

}

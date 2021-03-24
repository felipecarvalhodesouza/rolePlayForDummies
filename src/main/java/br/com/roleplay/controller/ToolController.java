package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.ToolType;
import br.com.roleplay.model.ToolModel;
import br.com.roleplay.repository.ToolRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "toolController")
@RequestScoped
public class ToolController {

	@Inject
	private ToolModel toolModel;

	@Inject
	private ToolRepository toolRepository;

	private List<Coin> coins = new ArrayList<Coin>();
	
	private Set<ToolType> types = new LinkedHashSet<ToolType>();
	private Set<ToolModel> tools = new LinkedHashSet<ToolModel>();

	@PostConstruct
	public void init() {

		for (Coin coin : Coin.values()) {
			getCoins().add(coin);
		}
		
		for(ToolType toolType: ToolType.values()){
			getTypes().add(toolType);
		}
		
		setTools(toolRepository.getAllTools());
	}

	public ToolModel getToolModel() {
		return toolModel;
	}

	public void setToolModel(ToolModel toolModel) {
		this.toolModel = toolModel;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public Set<ToolModel> getTools() {
		return tools;
	}

	public void setTools(Set<ToolModel> tools) {
		this.tools = tools;
	}

	public Set<ToolType> getTypes() {
		return types;
	}

	public void setTypes(Set<ToolType> types) {
		this.types = types;
	}

	public void insertNewTool() {

		toolRepository.insertTool(this.toolModel);
		
		tools.add(toolModel);

		this.toolModel = new ToolModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}
	
	public void deleteTool(ToolModel toolModel) {

		toolRepository.deleteTool(toolModel.getId());
		this.tools.remove(toolModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}
	
	public void updateTool(ToolModel toolModel) {
		toolRepository.updateTool(toolModel);
		
		this.init();
		
		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}
	
	public void openUpdateDialog(ToolModel toolModel) {
		this.toolModel = toolModel;
	}

}
package br.com.roleplay.controller.items;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.model.items.OptionalItemModel;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.repository.items.ItemRepository;
import br.com.roleplay.repository.items.OptionalItemRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "optionalItemController")
@RequestScoped
public class OptionalItemController {

	@Inject
	private OptionalItemModel optionalItemModel;

	@Inject
	private OptionalItemRepository optionalItemRepository;
	
	@Inject
	private ItemRepository ItemRepository;
	
	@Inject
	private BackgroundRepository backgroundRepository;

	private Set<OptionalItemModel> optionalItems = new LinkedHashSet<OptionalItemModel>();
	private Set<ItemModel> items = new LinkedHashSet<ItemModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setOptionalItems(optionalItemRepository.getAllOptionalItems());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
		setItems(ItemRepository.getAllItems());
	}

	public void openUpdateDialog(OptionalItemModel optionalItemModel) {
		this.optionalItemModel = optionalItemModel;
	}

	public void updateOptionalItem(OptionalItemModel optionalItemModel) {
		optionalItemRepository.updateOptionalItem(optionalItemModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public OptionalItemModel getOptionalItemModel() {
		return optionalItemModel;
	}

	public void setOptionalItemModel(OptionalItemModel optionalItemModel) {
		this.optionalItemModel = optionalItemModel;
	}

	public Set<OptionalItemModel> getOptionalItems() {
		return optionalItems;
	}

	public void setOptionalItems(Set<OptionalItemModel> optionalItems) {
		this.optionalItems = optionalItems;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public Set<ItemModel> getItems() {
		return items;
	}

	public void setItems(Set<ItemModel> items) {
		this.items = items;
	}

	public void insertNewOptionalItem() {

		optionalItemRepository.insertOptionalItem(this.optionalItemModel);

		getOptionalItems().add(optionalItemModel);

		this.optionalItemModel = new OptionalItemModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteOptionalItem(OptionalItemModel optionalItemModel) {

		optionalItemRepository.deleteOptionalItem(optionalItemModel.getId());
		this.getOptionalItems().remove(optionalItemModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
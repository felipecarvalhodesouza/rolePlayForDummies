package br.com.roleplay.controller.items;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.repository.items.ItemRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "itemController")
@RequestScoped
public class ItemController {

	@Inject
	private ItemModel itemModel;

	@Inject
	private ItemRepository itemRepository;

	private Set<ItemModel> items = new LinkedHashSet<ItemModel>();

	@PostConstruct
	public void init() {
		setItems(itemRepository.getAllItems());
	}

	public Set<ItemModel> getItems() {
		return items;
	}

	public void setItems(Set<ItemModel> items) {
		this.items = items;
	}

	public void openUpdateDialog(ItemModel itemModel) {
		this.itemModel = itemModel;
	}

	public void updateItem(ItemModel itemModel) {
		itemRepository.updateItem(itemModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public ItemModel getItemModel() {
		return itemModel;
	}

	public void setItemModel(ItemModel itemModel) {
		this.itemModel = itemModel;
	}

	public void insertNewItem() {

		itemRepository.insertItem(this.itemModel);

		getItems().add(itemModel);

		this.itemModel = new ItemModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteItem(ItemModel itemModel) {

		itemRepository.deleteItem(itemModel.getId());
		this.getItems().remove(itemModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
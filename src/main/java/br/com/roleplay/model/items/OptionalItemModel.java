package br.com.roleplay.model.items;

import java.util.List;

import br.com.roleplay.model.background.BackgroundModel;

public class OptionalItemModel {

	private long id;
	private BackgroundModel background;
	private Integer cod;
	private List<ItemModel> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BackgroundModel getBackground() {
		return background;
	}

	public void setBackground(BackgroundModel background) {
		this.background = background;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
}

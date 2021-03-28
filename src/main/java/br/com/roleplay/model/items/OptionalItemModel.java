package br.com.roleplay.model.items;

import java.util.List;

import br.com.roleplay.model.background.BackgroundModel;

public class OptionalItemModel {

	private long id;
	private BackgroundModel background;
	private Integer cod;
	private List<ItemModel> items;

	public OptionalItemModel() {}
	
	public OptionalItemModel(long id, Integer cod) {
		this.id = id;
		this.cod = cod;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptionalItemModel other = (OptionalItemModel) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return items.toString();
	}
}

package br.com.roleplay.entity.items;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.roleplay.entity.background.BackgroundEntity;

@Entity
@Table(name = "optionalItem")
public class OptionalItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne(targetEntity = BackgroundEntity.class)
	private BackgroundEntity background;

	@Column(name = "cod")
	private Integer cod;

	@ManyToMany
	@JoinTable(name = "optional_item_item",
	joinColumns = @JoinColumn(name = "optional_item_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	private List<ItemEntity> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BackgroundEntity getBackground() {
		return background;
	}

	public void setBackground(BackgroundEntity background) {
		this.background = background;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
}

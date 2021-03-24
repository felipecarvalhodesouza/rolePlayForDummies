package br.com.roleplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.roleplay.enums.Coin;
import br.com.roleplay.enums.ToolType;

@Entity
@Table(name = "tool")
public class ToolEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "toolType")
	@Enumerated(EnumType.STRING)
	private ToolType toolType;
	
	@Column(name = "cost")
	private double cost;

	@Column(name = "coin")
	@Enumerated(EnumType.STRING)
	private Coin coin;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ToolType getToolType() {
		return toolType;
	}

	public void setToolType(ToolType toolType) {
		this.toolType = toolType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

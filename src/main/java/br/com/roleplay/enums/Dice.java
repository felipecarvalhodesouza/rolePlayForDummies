package br.com.roleplay.enums;

import java.io.Serializable;

public enum Dice implements Serializable {
	
	D4(1, "D4", 4),
	D4_2(6, "D4", 4),
	D6(2, "D6", 6),
	D6_2(7, "D6", 6),
	D8(3, "D8", 8),
	D8_2(8, "D8", 8),
	D10(4, "D10", 10),
	D10_2(9, "D10", 10),
	D12(5, "D12", 12),
	D12_2(10, "D12", 12);
	
	private Integer cod;
	private String description;
	private Integer value;
	
	private Dice(Integer cod, String description, Integer value) {
		this.cod = cod;
		this.description = description;
		this.value = value;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}

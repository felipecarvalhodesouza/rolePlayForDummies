package br.com.roleplay.enums;

public enum Dice {
	
	D4(1, "D4", 4),
	D6(1, "D6", 6),
	D8(1, "D8", 8),
	D10(1, "D10", 10),
	D12(1, "D12", 12);
	
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

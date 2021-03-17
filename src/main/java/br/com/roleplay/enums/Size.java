package br.com.roleplay.enums;

public enum Size {
	SMALL(1, "Small"),
	MEDIUM(2, "Medium");
	
	private Integer cod;
	private String description;
	
	private Size(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
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
}

package br.com.roleplay.enums.weapon;

public enum WeaponCategory {

	SIMPLE(1, "Simple"), MARTIAL(2, "Martial");

	private Integer cod;
	private String description;

	private WeaponCategory(Integer cod, String description) {
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

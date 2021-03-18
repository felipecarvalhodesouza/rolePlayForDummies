package br.com.roleplay.enums.weapon;

public enum WeaponProperty {

	AMMUNITION(1, "Ammunition"), FINESSE(2, "Finesse"), HEAVY(3, "Heavy"), LIGTH(4, "Light"), LOADING(5, "Loading"),
	RANGE(6, "Range"), REACH(7, "Reach"), THROWN(8, "Thrown"), TWO_HANDED(9, "Two-Handed"), VERSATILE(10, "Versatile");

	private Integer cod;
	private String description;

	private WeaponProperty(Integer cod, String description) {
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

package br.com.roleplay.enums.weapon;

public enum DamageType {
	ACID(1, "Acid"),
	BLUDGEONING(2, "Bludgeoning"),
	COLD(3, "Cold"),
	FIRE(4, "Fire"),
	FORCE(5, "Force"),
	LIGHTNING(6, "Lightning"),
	NECROTIC(7, "Necrotic"),
	PIERCING(8, "Piercing"),
	POISON(9, "Poison"),
	PSYCHIC(10, "Psychic"),
	RADIANT(11, "Radiant"),
	SLASHING(12, "Slashing"),
	THUNDER(13, "Thunder");
	
	private Integer cod;
	private String description;
	
	private DamageType(Integer cod, String description) {
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

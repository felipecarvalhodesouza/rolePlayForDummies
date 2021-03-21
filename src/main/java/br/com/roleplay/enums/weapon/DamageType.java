package br.com.roleplay.enums.weapon;

import br.com.roleplay.interfaces.EnumLocation;

public enum DamageType implements EnumLocation{
	
	ACID(1, "label.enum.damage.type.acid"),
	BLUDGEONING(2, "label.enum.damage.type.bludgeoning"),
	COLD(3, "label.enum.damage.type.cold"),
	FIRE(4, "label.enum.damage.type.fire"),
	FORCE(5, "label.enum.damage.type.force"),
	LIGHTNING(6, "label.enum.damage.type.lightning"),
	NECROTIC(7, "label.enum.damage.type.necrotic"),
	PIERCING(8, "label.enum.damage.type.piercing"),
	POISON(9, "label.enum.damage.type.poison"),
	PSYCHIC(10, "label.enum.damage.type.psychic"),
	RADIANT(11, "label.enum.damage.type.radiant"),
	SLASHING(12, "label.enum.damage.type.slashing"),
	THUNDER(13, "label.enum.damage.type.thunder");

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

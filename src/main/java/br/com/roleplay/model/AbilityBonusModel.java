package br.com.roleplay.model;

import br.com.roleplay.enums.Trait;

public class AbilityBonusModel {

	private long id;
	private Trait trait;
	private Integer modifier;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Trait getTrait() {
		return trait;
	}

	public void setTrait(Trait trait) {
		this.trait = trait;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

}

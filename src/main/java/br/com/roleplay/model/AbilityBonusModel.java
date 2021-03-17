package br.com.roleplay.model;

import br.com.roleplay.enums.Trait;

public class AbilityBonusModel {

	private long id;
	private Trait trait;
	private Integer modifier;
	
	public AbilityBonusModel() {
		
	}

	public AbilityBonusModel(long id, Trait trait, Integer modifier) {
		this.id = id;
		this.trait = trait;
		this.modifier = modifier;
	}

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

	@Override
	public String toString() {
		return trait.getDescription() + " +" + modifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((modifier == null) ? 0 : modifier.hashCode());
		result = prime * result + ((trait == null) ? 0 : trait.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbilityBonusModel other = (AbilityBonusModel) obj;
		if (id != other.id)
			return false;
		if (modifier == null) {
			if (other.modifier != null)
				return false;
		} else if (!modifier.equals(other.modifier))
			return false;
		if (trait != other.trait)
			return false;
		return true;
	}
}

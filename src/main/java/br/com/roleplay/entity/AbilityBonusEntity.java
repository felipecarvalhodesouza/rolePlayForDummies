package br.com.roleplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.roleplay.enums.Trait;

@NamedQuery(name = "AbilityBonusEntity.findAll",query= "SELECT a FROM AbilityBonusEntity a order by a.trait, a.modifier")

@Entity
@Table(name = "ability_bonus")
public class AbilityBonusEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "trait")
	private Trait trait;
	
	@Column(name = "modifier")
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

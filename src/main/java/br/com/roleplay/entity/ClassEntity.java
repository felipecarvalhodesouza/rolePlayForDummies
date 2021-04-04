package br.com.roleplay.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Trait;

@Entity
@Table(name = "class")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "ds_name")
	private String name;
	
	@Column(name = "ds_description_en")
	@Lob
	private String descriptionEn;
	
	@Column(name = "ds_description_pt")
	@Lob
	private String descriptionPt;
	
	@Column(name = "ds_hit_die")
	@Enumerated(EnumType.STRING)
	private Dice hitDie;
	
	@Column(name = "ds_primaty_ability")
	@Enumerated(EnumType.STRING)
	private Trait primaryAbility;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = Trait.class)
	@CollectionTable(name = "class_saving_throws",
	joinColumns = @JoinColumn(name="class_id", referencedColumnName="id"))
	@Column(name = "ds_saving_throw", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Trait> savingThrows;
	
	@ManyToMany
    @JoinTable(
            name="class_proficiency",
            joinColumns=
                @JoinColumn(name="class_id", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="proficiency_id", referencedColumnName="id")
        )
	private List<ProficiencyEntity> proficiencies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}
	
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	
	public String getDescriptionPt() {
		return descriptionPt;
	}

	public void setDescriptionPt(String descriptionPt) {
		this.descriptionPt = descriptionPt;
	}

	public Dice getHitDie() {
		return hitDie;
	}

	public void setHitDie(Dice hitDie) {
		this.hitDie = hitDie;
	}

	public Trait getPrimaryAbility() {
		return primaryAbility;
	}

	public void setPrimaryAbility(Trait primaryAbility) {
		this.primaryAbility = primaryAbility;
	}

	public List<Trait> getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(List<Trait> savingThrows) {
		this.savingThrows = savingThrows;
	}

	public List<ProficiencyEntity> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<ProficiencyEntity> proficiencies) {
		this.proficiencies = proficiencies;
	}
}

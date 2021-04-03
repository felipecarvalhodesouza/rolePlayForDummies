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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.roleplay.entity.items.WeaponEntity;
import br.com.roleplay.enums.ArmorType;
import br.com.roleplay.enums.weapon.WeaponCategory;

@Entity
@Table(name = "proficiency")
public class ProficiencyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "cod")
	private Integer cod;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = ArmorType.class)
	@CollectionTable(name = "proficiency_armor_type",
	joinColumns = @JoinColumn(name = "proficiency_id", referencedColumnName = "id"))
	@Column(name = "armor_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<ArmorType> armorTypeList;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = WeaponCategory.class)
	@CollectionTable(name = "proficiency_weapon_category",
	joinColumns = @JoinColumn(name = "proficiency_id", referencedColumnName = "id"))
	@Column(name = "weapon_category", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<WeaponCategory> weaponCategoryList;
	
	@ManyToMany
    @JoinTable(
            name="proficiency_weapon",
            joinColumns=
                @JoinColumn(name="proficiency_id", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="weapon_id", referencedColumnName="id")
        )
	private List<WeaponEntity> weaponList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public List<ArmorType> getArmorTypeList() {
		return armorTypeList;
	}

	public void setArmorTypeList(List<ArmorType> armorTypeList) {
		this.armorTypeList = armorTypeList;
	}

	public List<WeaponCategory> getWeaponCategoryList() {
		return weaponCategoryList;
	}

	public void setWeaponCategoryList(List<WeaponCategory> weaponCategoryList) {
		this.weaponCategoryList = weaponCategoryList;
	}

	public List<WeaponEntity> getWeaponList() {
		return weaponList;
	}

	public void setWeaponList(List<WeaponEntity> weaponList) {
		this.weaponList = weaponList;
	}
}

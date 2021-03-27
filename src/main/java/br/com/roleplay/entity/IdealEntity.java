package br.com.roleplay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ideal")
public class IdealEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "descriptionEn")
	private String descriptionEn;
	
	@Column(name = "descriptionPt")
	private String descriptionPt;
	
	@ManyToOne(targetEntity = BackgroundEntity.class)
	private BackgroundEntity background;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	public BackgroundEntity getBackground() {
		return background;
	}

	public void setBackground(BackgroundEntity background) {
		this.background = background;
	}
}

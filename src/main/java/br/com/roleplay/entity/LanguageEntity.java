package br.com.roleplay.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.roleplay.enums.LanguageType;
import br.com.roleplay.enums.Script;

@Entity
@Table(name = "language")
public class LanguageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany
    @JoinTable(
            name="race_language",
            joinColumns=
                @JoinColumn(name="language_id", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="race_id", referencedColumnName="id")
        )
	private Set<RaceEntity> typicalSpeakers;

	@Enumerated(EnumType.STRING)
	@Column(name = "script")
	private Script script;

	@Enumerated(EnumType.STRING)
	@Column(name = "languageType")
	private LanguageType languageType;

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

	public Set<RaceEntity> getTypicalSpeakers() {
		return typicalSpeakers;
	}

	public void setTypicalSpeakers(Set<RaceEntity> typicalSpeakers) {
		this.typicalSpeakers = typicalSpeakers;
	}

	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	public LanguageType getLanguageType() {
		return languageType;
	}

	public void setLanguageType(LanguageType languageType) {
		this.languageType = languageType;
	}
}

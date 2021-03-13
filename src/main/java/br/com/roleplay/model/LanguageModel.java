package br.com.roleplay.model;

import java.util.Set;

import br.com.roleplay.enums.LanguageType;
import br.com.roleplay.enums.Script;

public class LanguageModel {

	private long id;

	private String name;

	private Set<RaceModel> typicalSpeakers;

	private Script script;
	
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

	public Set<RaceModel> getTypicalSpeakers() {
		return typicalSpeakers;
	}

	public void setTypicalSpeakers(Set<RaceModel> typicalSpeakers) {
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

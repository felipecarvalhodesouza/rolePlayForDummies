package br.com.roleplay.model;

import java.io.Serializable;
import java.util.Set;

import br.com.roleplay.enums.LanguageType;
import br.com.roleplay.enums.Script;

public class LanguageModel implements Comparable<LanguageModel>, Serializable {

	private static final long serialVersionUID = 6237103526130103899L;

	private long id;

	private String name;

	private Set<RaceModel> typicalSpeakers;

	private Script script;
	
	private LanguageType languageType;
	
	public LanguageModel() {
	}

	public LanguageModel(long id, String name) {
		this.id = id;
		this.name = name;
	}

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

	@Override
	public int compareTo(LanguageModel o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LanguageModel other = (LanguageModel) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

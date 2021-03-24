package br.com.roleplay.enums;

import br.com.roleplay.interfaces.EnumLocation;

public enum ToolType implements EnumLocation{

	ARTISAN(1, "label.enum.tooltype.artisan"),
	DISGUISE(2, "label.enum.tooltype.disguise"),
	FORGERY(3, "label.enum.tooltype.forgery"),
	GAMING(4, "label.enum.tooltype.gaming"),
	HERBALISM(5, "label.enum.tooltype.herbalism"),
	MUSICAL(6, "label.enum.tooltype.musical"),
	NAVIGATOR(7, "label.enum.tooltype.navigator"),
	POISONER(8, "label.enum.tooltype.poisoner"),
	THIEVES(9, "label.enum.tooltype.thieves");

	private Integer cod;
	private String description;
	
	private ToolType(Integer cod, String description) {
		this.cod = cod;
		this.setDescription(description);
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

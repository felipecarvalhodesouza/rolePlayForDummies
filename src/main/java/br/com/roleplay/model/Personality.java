package br.com.roleplay.model;

public class Personality {

	private long id;
	private int value;
	private String description;
	private BackgroundModel background;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BackgroundModel getBackground() {
		return background;
	}

	public void setBackground(BackgroundModel background) {
		this.background = background;
	}
}

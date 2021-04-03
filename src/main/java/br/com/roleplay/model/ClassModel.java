package br.com.roleplay.model;

import java.util.List;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Skill;
import br.com.roleplay.interfaces.PHBClass;

public class ClassModel implements PHBClass{

	private long id;
	private String name;
	private String description;
	private Dice hitDie;
	private Skill primaryAbility;
	private List<Skill> savingThrows;
	
	/**
	 * Criar a proficiency
	 */

	
}

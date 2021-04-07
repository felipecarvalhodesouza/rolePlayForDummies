package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import br.com.roleplay.enums.Gender;
import br.com.roleplay.model.CharacterModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.repository.RaceRepository;

@Named(value = "characterController")
@RequestScoped
public class CharacterController {

	@Inject
	private CharacterModel characterModel;
	
	@Inject
	RaceRepository raceRepository;
	
	private List<Gender> genders = new ArrayList<Gender>();
	private Set<RaceModel> races = new LinkedHashSet<RaceModel>();

	@PostConstruct
	public void init() {
		for(Gender gender: Gender.values()) {
			genders.add(gender);
		}
		
		races = raceRepository.getAllRaces();
	}

	public CharacterModel getCharacterModel() {
		return characterModel;
	}

	public void setCharacterModel(CharacterModel characterModel) {
		this.characterModel = characterModel;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public Set<RaceModel> getRaces() {
		return races;
	}

	public void setRaces(Set<RaceModel> races) {
		this.races = races;
	}

	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	public void insertNewClass() {

	}

}
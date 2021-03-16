package br.com.roleplay.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Alignment;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.repository.LanguageRepository;
import br.com.roleplay.repository.RaceRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "raceController")
@RequestScoped
public class RaceController {

	@Inject
	private	RaceModel raceModel;
	
	@Inject
	LanguageRepository languageRepository;

	@Inject
	RaceRepository raceRepository;

	private Set<LanguageModel> languages = new LinkedHashSet<LanguageModel>();
	private Set<Alignment> alignments = new LinkedHashSet<Alignment>();

	@PostConstruct
	public void init() {
		languages = languageRepository.getAllLanguages();
		
		for (Alignment alignment : Alignment.values()) {
			alignments.add(alignment);
		}
	}

	public void insertNewRace() {

		raceRepository.insertRace(this.getRaceModel());

		this.setRaceModel(new RaceModel());

		Utils.infoMessage("Record succesfully inserted.");
	}

	public Set<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageModel> languages) {
		this.languages = languages;
	}

	public RaceModel getRaceModel() {
		return raceModel;
	}

	public void setRaceModel(RaceModel raceModel) {
		this.raceModel = raceModel;
	}

	public Set<Alignment> getAlignments() {
		return alignments;
	}

	public void setAlignments(Set<Alignment> alignments) {
		this.alignments = alignments;
	}
}
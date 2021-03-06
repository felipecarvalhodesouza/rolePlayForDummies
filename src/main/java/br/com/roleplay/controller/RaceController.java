package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.enums.Alignment;
import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Size;
import br.com.roleplay.model.AbilityBonusModel;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.repository.AbilityBonusRepository;
import br.com.roleplay.repository.LanguageRepository;
import br.com.roleplay.repository.RaceRepository;
import br.com.roleplay.utils.Utils;
import br.com.roleplay.utils.UtilsConverter;

@Named(value = "raceController")
@RequestScoped
public class RaceController {

	@Inject
	private	RaceModel raceModel;
	
	@Inject
	LanguageRepository languageRepository;
	
	@Inject
	AbilityBonusRepository abilityBonusRepository;

	@Inject
	RaceRepository raceRepository;

	private Set<LanguageModel> languages = new LinkedHashSet<LanguageModel>();
	private Set<Alignment> alignments = new LinkedHashSet<Alignment>();
	private List<AbilityBonusModel> abilityBonus = new ArrayList<AbilityBonusModel>();
	private List<Size> sizes = new ArrayList<Size>();
	private List<Dice> dices = new ArrayList<Dice>();
	
	private Set<RaceModel> races = new LinkedHashSet<RaceModel>();

	@PostConstruct
	public void init() {
		languages = languageRepository.getAllLanguages();
		
		for (Alignment alignment : Alignment.values()) {
			alignments.add(alignment);
		}
		
		for(Size size: Size.values()) {
			getSizes().add(size);
		}
		
		for (Dice dice : Dice.values()) {
			getDices().add(dice);
		}
		
		abilityBonus = abilityBonusRepository.getAllAbilityBonus();
		
		races = raceRepository.getAllRaces();
		for (RaceModel race : races) {
			Set<LanguageEntity> languageEntitySet = languageRepository.getLanguageEntityListFromRaceModel(race);
			race.setLanguages(UtilsConverter.getLanguageModelSetFromLanguageEntitySet(languageEntitySet));
		}
	}

	public void insertNewRace() {

		raceRepository.insertRace(this.getRaceModel());
		
		races.add(getRaceModel());

		this.setRaceModel(new RaceModel());

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));
	}
	
	public void openUpdateDialog(RaceModel raceModel) {
		this.raceModel = raceModel;
	}

	public void updateRace(RaceModel raceModel) {
		raceRepository.updateRace(raceModel);
		
		this.init();
		
		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}
	
	public void deleteRace(RaceModel raceModel) {

		raceRepository.deleteRace(raceModel.getId());
		this.races.remove(raceModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
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

	public List<AbilityBonusModel> getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(List<AbilityBonusModel> abilityBonus) {
		this.abilityBonus = abilityBonus;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}
	
	public Set<RaceModel> getRaces() {
		return races;
	}

	public void setRaces(Set<RaceModel> races) {
		this.races = races;
	}

	public List<Dice> getDices() {
		return dices;
	}

	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}
}
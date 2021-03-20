package br.com.roleplay.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.LanguageType;
import br.com.roleplay.enums.Script;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.repository.LanguageRepository;
import br.com.roleplay.repository.RaceRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "languageController")
@RequestScoped
public class LanguageController {

	@Inject
	LanguageModel languageModel;

	@Inject
	LanguageRepository languageRepository;
	
	@Inject
	RaceRepository raceRepository;

	private Set<Script> scripts = new LinkedHashSet<Script>();
	private Set<LanguageType> languageTypes = new LinkedHashSet<LanguageType>();
	private Set<RaceModel> typicalSpeakers = new LinkedHashSet<RaceModel>();

	private Set<LanguageModel> languages = new LinkedHashSet<LanguageModel>();

	public LanguageModel getLanguageModel() {
		return languageModel;
	}

	public void setLanguageModel(LanguageModel languageModel) {
		this.languageModel = languageModel;
	}

	@PostConstruct
	public void init() {
		for (Script script : Script.values()) {
			scripts.add(script);
		}

		for (LanguageType languageType : LanguageType.values()) {
			getLanguageTypes().add(languageType);
		}

		languages = languageRepository.getAllLanguages();
		
		typicalSpeakers = raceRepository.getAllRaces();
	}

	public void insertNewLanguage() {

		languageRepository.insertLanguage(this.languageModel);

		this.languageModel = new LanguageModel();
		languages = languageRepository.getAllLanguages();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));
	}

	public void openUpdateDialog(LanguageModel languageModel) {
		this.languageModel = languageModel;
	}

	public void updateLanguage(LanguageModel languageModel) {
		languageRepository.updateLanguage(languageModel);
		this.init();
	}

	public void deleteLanguage(LanguageModel languageModel) {

		languageRepository.deleteLanguage(languageModel.getId());
		this.languages.remove(languageModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

	public Set<Script> getScripts() {
		return scripts;
	}

	public void setScripts(Set<Script> scripts) {
		this.scripts = scripts;
	}

	public Set<LanguageType> getLanguageTypes() {
		return languageTypes;
	}

	public void setLanguageTypes(Set<LanguageType> languageTypes) {
		this.languageTypes = languageTypes;
	}

	public Set<RaceModel> getTypicalSpeakers() {
		return typicalSpeakers;
	}

	public void setTypicalSpeakers(Set<RaceModel> typicalSpeakers) {
		this.typicalSpeakers = typicalSpeakers;
	}

	public Set<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageModel> languages) {
		this.languages = languages;
	}
}
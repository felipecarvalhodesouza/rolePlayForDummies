package br.com.roleplay.language.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.entity.LanguageEntity;
import br.com.roleplay.enums.LanguageType;
import br.com.roleplay.enums.Script;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.RaceModel;
import br.com.roleplay.repository.LanguageRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "insertLanguageController")
@RequestScoped
public class InsertLanguageController {

	@Inject
	LanguageModel languageModel;

	@Inject
	LanguageRepository languageRepository;
	
	private Set<Script> scripts = new HashSet<Script>();
	private Set<LanguageType> languageTypes = new HashSet<LanguageType>();
	private Set<RaceModel> typicalSpeakers = new HashSet<RaceModel>();
	
	private Set<LanguageEntity> languages = new HashSet<LanguageEntity>();

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
		
		for(LanguageType languageType: LanguageType.values()) {
			getLanguageTypes().add(languageType);
		}
		
		languages = languageRepository.getAllLanguages();
	}

	public void insertNewLanguage() {

		languageRepository.insertLanguage(this.languageModel);

		this.languageModel = new LanguageModel();
		languages = languageRepository.getAllLanguages();

		Utils.infoMessage("Record succesfully inserted.");
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

	public Set<LanguageEntity> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageEntity> languages) {
		this.languages = languages;
	}
}
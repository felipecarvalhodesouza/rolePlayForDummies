package br.com.roleplay.controller.background;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.background.PersonalityModel;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.repository.background.PersonalityRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "personalityController")
@RequestScoped
public class PersonalityController {

	@Inject
	private PersonalityModel personalityModel;

	@Inject
	private PersonalityRepository personalityRepository;
	
	@Inject
	private BackgroundRepository backgroundRepository;

	private Set<PersonalityModel> personalities = new LinkedHashSet<PersonalityModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setPersonalities(personalityRepository.getAllPersonalities());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
	}

	public void openUpdateDialog(PersonalityModel personalityModel) {
		this.personalityModel = personalityModel;
	}

	public void updatePersonality(PersonalityModel personalityModel) {
		personalityRepository.updatePersonality(personalityModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public PersonalityModel getPersonalityModel() {
		return personalityModel;
	}

	public void setPersonalityModel(PersonalityModel personalityModel) {
		this.personalityModel = personalityModel;
	}

	public Set<PersonalityModel> getPersonalities() {
		return personalities;
	}

	public void setPersonalities(Set<PersonalityModel> personalities) {
		this.personalities = personalities;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public void insertNewPersonality() {

		personalityRepository.insertPersonality(this.personalityModel);

		getPersonalities().add(personalityModel);

		this.personalityModel = new PersonalityModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deletePersonality(PersonalityModel personalityModel) {

		personalityRepository.deletePersonality(personalityModel.getId());
		this.getPersonalities().remove(personalityModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
package br.com.roleplay.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.BackgroundModel;
import br.com.roleplay.model.FlawModel;
import br.com.roleplay.repository.BackgroundRepository;
import br.com.roleplay.repository.FlawRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "flawController")
@RequestScoped
public class FlawController {

	@Inject
	private FlawModel flawModel;

	@Inject
	private FlawRepository flawRepository;
	
	@Inject
	private BackgroundRepository backgroundRepository;

	private Set<FlawModel> personalities = new LinkedHashSet<FlawModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setPersonalities(flawRepository.getAllPersonalities());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
	}

	public void openUpdateDialog(FlawModel flawModel) {
		this.flawModel = flawModel;
	}

	public void updateFlaw(FlawModel flawModel) {
		flawRepository.updateFlaw(flawModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public FlawModel getFlawModel() {
		return flawModel;
	}

	public void setFlawModel(FlawModel flawModel) {
		this.flawModel = flawModel;
	}

	public Set<FlawModel> getPersonalities() {
		return personalities;
	}

	public void setPersonalities(Set<FlawModel> personalities) {
		this.personalities = personalities;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public void insertNewFlaw() {

		flawRepository.insertFlaw(this.flawModel);

		getPersonalities().add(flawModel);

		this.flawModel = new FlawModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteFlaw(FlawModel flawModel) {

		flawRepository.deleteFlaw(flawModel.getId());
		this.getPersonalities().remove(flawModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
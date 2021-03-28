package br.com.roleplay.controller.background;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.background.IdealModel;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.repository.background.IdealRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "idealController")
@RequestScoped
public class IdealController {

	@Inject
	private IdealModel idealModel;

	@Inject
	private IdealRepository idealRepository;
	
	@Inject
	private BackgroundRepository backgroundRepository;

	private Set<IdealModel> ideals = new LinkedHashSet<IdealModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setIdeals(idealRepository.getAllIdeals());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
	}

	public void openUpdateDialog(IdealModel idealModel) {
		this.idealModel = idealModel;
	}

	public void updateIdeal(IdealModel idealModel) {
		idealRepository.updateIdeal(idealModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public IdealModel getIdealModel() {
		return idealModel;
	}

	public void setIdealModel(IdealModel idealModel) {
		this.idealModel = idealModel;
	}

	public Set<IdealModel> getIdeals() {
		return ideals;
	}

	public void setIdeals(Set<IdealModel> ideals) {
		this.ideals = ideals;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public void insertNewIdeal() {

		idealRepository.insertIdeal(this.idealModel);

		getIdeals().add(idealModel);

		this.idealModel = new IdealModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteIdeal(IdealModel idealModel) {

		idealRepository.deleteIdeal(idealModel.getId());
		this.getIdeals().remove(idealModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
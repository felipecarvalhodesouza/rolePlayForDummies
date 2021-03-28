package br.com.roleplay.controller.background;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "backgroundController")
@RequestScoped
public class BackgroundController {

	@Inject
	private BackgroundModel backgroundModel;

	@Inject
	private BackgroundRepository backgroundRepository;

	
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setBackgrounds(backgroundRepository.getAllBackgrounds());
	}

	public BackgroundModel getBackgroundModel() {
		return backgroundModel;
	}

	public void setBackgroundModel(BackgroundModel backgroundModel) {
		this.backgroundModel = backgroundModel;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public void insertNewBackground() {

		backgroundRepository.insertBackground(this.backgroundModel);
		
		backgrounds.add(backgroundModel);

		this.backgroundModel = new BackgroundModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}
	
	public void deleteBackground(BackgroundModel backgroundModel) {

		backgroundRepository.deleteBackground(backgroundModel.getId());
		this.backgrounds.remove(backgroundModel);
		
		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}
	
	public void updateBackground(BackgroundModel backgroundModel) {
		backgroundRepository.updateBackground(backgroundModel);
		
		this.init();
		
		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}
	
	public void openUpdateDialog(BackgroundModel backgroundModel) {
		this.backgroundModel = backgroundModel;
	}

}
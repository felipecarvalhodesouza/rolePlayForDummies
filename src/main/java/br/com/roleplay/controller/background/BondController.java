package br.com.roleplay.controller.background;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.background.BondModel;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.repository.background.BondRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "bondController")
@RequestScoped
public class BondController {

	@Inject
	private BondModel bondModel;

	@Inject
	private BondRepository bondRepository;
	
	@Inject
	private BackgroundRepository backgroundRepository;

	private Set<BondModel> bonds = new LinkedHashSet<BondModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();

	@PostConstruct
	public void init() {
		setBonds(bondRepository.getAllBonds());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
	}

	public void openUpdateDialog(BondModel bondModel) {
		this.bondModel = bondModel;
	}

	public void updateBond(BondModel bondModel) {
		bondRepository.updateBond(bondModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public BondModel getBondModel() {
		return bondModel;
	}

	public void setBondModel(BondModel bondModel) {
		this.bondModel = bondModel;
	}

	public Set<BondModel> getBonds() {
		return bonds;
	}

	public void setBonds(Set<BondModel> bonds) {
		this.bonds = bonds;
	}

	public Set<BackgroundModel> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(Set<BackgroundModel> backgrounds) {
		this.backgrounds = backgrounds;
	}

	public void insertNewBond() {

		bondRepository.insertBond(this.bondModel);

		getBonds().add(bondModel);

		this.bondModel = new BondModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteBond(BondModel bondModel) {

		bondRepository.deleteBond(bondModel.getId());
		this.getBonds().remove(bondModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

}
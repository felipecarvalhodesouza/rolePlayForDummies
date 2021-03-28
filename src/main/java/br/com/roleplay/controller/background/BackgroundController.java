package br.com.roleplay.controller.background;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Skill;
import br.com.roleplay.model.LanguageModel;
import br.com.roleplay.model.background.BackgroundModel;
import br.com.roleplay.model.items.ItemModel;
import br.com.roleplay.model.items.OptionalItemModel;
import br.com.roleplay.repository.LanguageRepository;
import br.com.roleplay.repository.background.BackgroundRepository;
import br.com.roleplay.repository.items.ItemRepository;
import br.com.roleplay.repository.items.OptionalItemRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "backgroundController")
@RequestScoped
public class BackgroundController {

	@Inject
	private BackgroundModel backgroundModel;

	@Inject
	private BackgroundRepository backgroundRepository;
	
	@Inject
	LanguageRepository languageRepository;
	
	@Inject
	ItemRepository itemRepository;
	
	@Inject
	OptionalItemRepository optionalItemRepository;
	
	private Set<LanguageModel> languages = new LinkedHashSet<LanguageModel>();
	private Set<BackgroundModel> backgrounds = new LinkedHashSet<BackgroundModel>();
	private Set<ItemModel> items = new LinkedHashSet<ItemModel>();
	private Set<OptionalItemModel> optionalItems = new LinkedHashSet<OptionalItemModel>();
	private Set<Skill> skills = new LinkedHashSet<Skill>();

	@PostConstruct
	public void init() {
		setLanguages(languageRepository.getAllLanguages());
		setBackgrounds(backgroundRepository.getAllBackgrounds());
		setItems(itemRepository.getAllItems());
		setOptionalItems(optionalItemRepository.getAllOptionalItems());
		
		for(Skill skill: Skill.values()) {
			getSkills().add(skill);
		}
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

	public Set<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageModel> languages) {
		this.languages = languages;
	}

	public Set<ItemModel> getItems() {
		return items;
	}

	public void setItems(Set<ItemModel> items) {
		this.items = items;
	}

	public Set<OptionalItemModel> getOptionalItems() {
		return optionalItems;
	}

	public void setOptionalItems(Set<OptionalItemModel> optionalItems) {
		this.optionalItems = optionalItems;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
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
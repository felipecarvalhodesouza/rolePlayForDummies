package br.com.roleplay.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.roleplay.enums.Dice;
import br.com.roleplay.enums.Trait;
import br.com.roleplay.model.ClassModel;
import br.com.roleplay.model.ProficiencyModel;
import br.com.roleplay.repository.ClassRepository;
import br.com.roleplay.repository.ProficiencyRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "classController")
@RequestScoped
public class ClassController{

	@Inject
	private ClassModel classModel;

	@Inject
	private ClassRepository classRepository;

	@Inject
	private ProficiencyRepository proficiencyRepository;

	private List<ClassModel> classes = new ArrayList<ClassModel>();
	private List<Dice> hitDie = new ArrayList<Dice>();
	private List<Trait> traits = new ArrayList<Trait>();
	private List<ProficiencyModel> proficiencies = new ArrayList<ProficiencyModel>();

	@PostConstruct
	public void init() {
		setClasses(classRepository.getAllClasses());

		for (Dice dice : Dice.values()) {
			if (dice.getCod() <= 5)
				getHitDie().add(dice);
		}

		for (Trait trait : Trait.values()) {
			getTraits().add(trait);
		}

		setProficiencies(proficiencyRepository.getAllProficiencies());
	}
	
	@PreDestroy
	public void destroy() {
		if(Utils.getSessionMap().get("classImage") != null) {
			Utils.getSessionMap().remove("classImage");
		}
	}

	public ClassModel getClassModel() {
		return classModel;
	}

	public void setClassModel(ClassModel classModel) {
		this.classModel = classModel;
	}

	public List<ClassModel> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}

	public List<Dice> getHitDie() {
		return hitDie;
	}

	public void setHitDie(List<Dice> hitDie) {
		this.hitDie = hitDie;
	}

	public List<Trait> getTraits() {
		return traits;
	}

	public void setTraits(List<Trait> traits) {
		this.traits = traits;
	}

	public List<ProficiencyModel> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<ProficiencyModel> proficiencies) {
		this.proficiencies = proficiencies;
	}

	public void insertNewClass() {

		classRepository.insertClass(this.classModel);

		classes.add(classModel);

		this.classModel = new ClassModel();

		Utils.infoMessage(Utils.getLocaleName("message.record.inserted"));

	}

	public void deleteClass(ClassModel classModel) {

		classRepository.deleteClass(classModel.getId());
		this.classes.remove(classModel);

		Utils.warningMessage(Utils.getLocaleName("message.record.deleted"));
	}

	public void updateClass(ClassModel classModel) {
		classRepository.updateClass(classModel);

		this.init();

		Utils.warningMessage(Utils.getLocaleName("message.record.updated"));
	}

	public void openUpdateDialog(ClassModel classModel) {
		this.classModel = classModel;
	}
}
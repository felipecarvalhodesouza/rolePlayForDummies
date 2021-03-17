package br.com.roleplay.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.enums.Trait;
import br.com.roleplay.model.AbilityBonusModel;

@FacesConverter("abilityBonusConverter")
public class AbilityBonusConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		try {
		
			String[] array = value.split(",");
			long id = Long.valueOf(array[0].substring(19));
			String traitCod = array[1].substring(9);
			Trait trait = Trait.getTraitByCod(Integer.valueOf(traitCod));
			String modifier = array[2].substring(12, array[2].lastIndexOf("]") - 1);

			return new AbilityBonusModel(id, trait, Integer.valueOf(modifier));
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Conversion error", "Conversion error");

			throw new ConverterException(facesMessage);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value == null) {
			return null;
		}

		AbilityBonusModel abilityBonus = (AbilityBonusModel) value;
		return "AbilityBonus[ id = " + abilityBonus.getId() + 
				", trait = " + abilityBonus.getTrait().getCod() + 
				", modifier = " + abilityBonus.getModifier() + " ]";
	}

}

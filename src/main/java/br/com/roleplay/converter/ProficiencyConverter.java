package br.com.roleplay.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.model.ProficiencyModel;

@FacesConverter("proficiencyConverter")
public class ProficiencyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || "".equals(value)) {
			return null;
		}

		try {
			long id = Long.valueOf(value.substring(18, value.indexOf(",")));
			String cod = value.substring(value.lastIndexOf("=") + 2, value.lastIndexOf("]") - 1);

			return new ProficiencyModel(id, Integer.parseInt(cod));
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion error",
					"Conversion error");

			throw new ConverterException(facesMessage);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value == null || "".equals(value)) {
			return null;
		}

		ProficiencyModel proficiency = (ProficiencyModel) value;
		return "Proficiency[ id = " + proficiency.getId() + ", cod = " + proficiency.getCod() + " ]";
	}

}

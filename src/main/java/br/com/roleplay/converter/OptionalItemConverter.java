package br.com.roleplay.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.model.items.OptionalItemModel;

@FacesConverter("optionalItemConverter")
public class OptionalItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || "".equals(value)) {
			return null;
		}

		try {
			long id = Long.valueOf(value.substring(19, value.indexOf(",")));
			String cod = value.substring(value.lastIndexOf("=") + 2, value.lastIndexOf("]") - 1);

			return new OptionalItemModel(id, Integer.parseInt(cod));
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

		OptionalItemModel item = (OptionalItemModel) value;
		return "OptionalItem[ id = " + item.getId() + ", cod = " + item.getCod() + " ]";
	}

}

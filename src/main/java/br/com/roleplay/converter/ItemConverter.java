package br.com.roleplay.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.model.items.ItemModel;

@FacesConverter("itemConverter")
public class ItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || "".equals(value)) {
			return null;
		}

		try {
			long id = Long.valueOf(value.substring(11, value.indexOf(",")));
			String name = value.substring(value.lastIndexOf("=") + 2, value.lastIndexOf("]") - 1);

			return new ItemModel(id, name);
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

		ItemModel item = (ItemModel) value;
		return "Item[ id = " + item.getId() + ", name = " + item.getName() + " ]";
	}

}

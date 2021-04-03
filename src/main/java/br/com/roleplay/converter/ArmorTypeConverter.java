package br.com.roleplay.converter;

import java.util.stream.Stream;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.enums.ArmorType;

@FacesConverter("armorTypeConverter")
public class ArmorTypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		return Stream.of(ArmorType.values()).filter(c -> c.getDescription().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		
		ArmorType type = (ArmorType) value;
		
		return type.getDescription();
	}
}

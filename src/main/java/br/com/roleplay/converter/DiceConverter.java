package br.com.roleplay.converter;

import java.util.stream.Stream;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.roleplay.enums.Dice;

@FacesConverter("diceConverter")
public class DiceConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		return Stream.of(Dice.values()).
						filter(c -> c.getCod().equals(Integer.parseInt(value))).
						findFirst().
						orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		
		Dice dice = (Dice) value;
		
		return String.valueOf(dice.getCod());
	}
}

package br.com.roleplay.interfaces;

import java.util.MissingResourceException;

import br.com.roleplay.utils.Utils;

public interface Localizable {
	
	String getName();

	default String getMessageKey(Localizable e) {
		return e.getClass().getCanonicalName().toLowerCase() + '.' + Utils.replaceSpecialChars(getName()).toLowerCase();
	}

	default String getLocaleName() {
		try {
			return Utils.getResouceBundle().getString(getMessageKey(this));
		} catch (MissingResourceException exception) {
			return getName();
		}
	}
}

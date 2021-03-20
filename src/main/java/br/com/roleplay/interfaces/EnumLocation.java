package br.com.roleplay.interfaces;

import br.com.roleplay.utils.Utils;

public interface EnumLocation {
	
	default String getLocaleDescription() {
		return Utils.getResouceBundle().getString(getDescription());
	}

	String getDescription();
}

package br.com.roleplay.interfaces;

public interface Localizable {
	
	String getName();
	
	default String getMessageKey(Localizable e) {
		return e.getClass().getSimpleName() + '.' + e.getName().toLowerCase();
	}
}

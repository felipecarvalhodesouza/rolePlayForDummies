package br.com.roleplay.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilsConverter {

	public static <T> Set<T> getSetFromList(List<T> list) {
		
		Set<T> set = new HashSet<T>();
		
		for (T t : list) {
			set.add(t);
		}
		
		return set;
	}

}

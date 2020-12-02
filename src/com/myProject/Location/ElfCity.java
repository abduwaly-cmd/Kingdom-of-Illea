package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Character.Pherousa;

import java.util.ArrayList;

public class ElfCity extends Location {
	private ArrayList<Character> characters = new ArrayList<Character>();

	public ElfCity() {
		super("Erilea Kingdom");
		characters.add(new Pherousa());
		setCharacters(characters);
	}
}

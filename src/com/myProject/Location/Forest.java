package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Character.*;

import java.util.ArrayList;

public class Forest extends Location {
	private instance;
	private ArrayList<Character> characters = new ArrayList<Character>();

	public Forest() {
		super("Niadale Forest");
		characters.add(new Pherousa());
		setCharacters(characters);
	}
}

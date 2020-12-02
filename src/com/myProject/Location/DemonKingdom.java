package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Character.Pherousa;

import java.util.ArrayList;

public class DemonKingdom extends Location{
	private ArrayList<Character> characters = new ArrayList<Character>();

	public DemonKingdom() {
		super("The Dooms of Valm");
		characters.add(new Pherousa());
		setCharacters(characters);
	}
}

package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Character.*;

import java.util.ArrayList;

public class Sea extends Location {
	private ArrayList<Character> characters = new ArrayList<Character>();

	public Sea() {
		super("Lakes of Darya");
		characters.add(new Pherousa());
		setCharacters(characters);
	}
}

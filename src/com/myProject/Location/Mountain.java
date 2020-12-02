package com.myProject.Location;

import com.myProject.Character.Character;
import com.myProject.Character.*;

import java.util.ArrayList;


public class Mountain  extends Location{
	private ArrayList<Character> characters = new ArrayList<Character>();

	public Mountain() {
		super("Mount Daein");
		characters.add(new Pherousa());
		setCharacters(characters);
	}
}

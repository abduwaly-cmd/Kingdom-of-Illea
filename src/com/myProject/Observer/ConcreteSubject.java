package com.myProject.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class ConcreteSubject implements Subject {

    private final ArrayList<Observer> observers;

    public ConcreteSubject(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) observers.remove(i);
    }

    @Override
    public void notifyObservers(String[] in) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        for (Observer observer : observers)
            observer.update(in);
    }
}

package com.myProject.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() { }

    @Override
    public void update(String[] in) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException { }
}
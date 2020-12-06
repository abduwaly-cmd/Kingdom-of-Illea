package com.myProject.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Subject {
    void removeObserver(Observer o);
    void registerObserver(Observer o);
    void notifyObservers(String[] a) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException;
}

package com.myProject.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface Observer {
    void update();
    void update(String[] in) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException;
}

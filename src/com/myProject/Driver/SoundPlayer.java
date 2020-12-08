package com.myProject.Driver;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer implements Runnable, LineListener {
    private Clip audioClip;
    private String filePath;
    private boolean running;
    private AudioInputStream as;
    private boolean playCompleted;
    private final boolean continous;

    public SoundPlayer(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.running = true;
        this.filePath = filePath;
        this.continous = true;
        this.as = AudioSystem.getAudioInputStream(new File ("/Users/abdu/Desktop/Projects/Uni/Software Design/myProject/out/production/myProject/com/myProject/Sounds/" + this.filePath + ".wav"));
        this.playCompleted = false;
        AudioFormat format = this.as.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        this.audioClip = (Clip) AudioSystem.getLine(info);
        this.audioClip.addLineListener(this);
        this.audioClip.open(as);
        this.audioClip.start();
        Thread thread = new Thread(this);
        thread.start();
    }

    public SoundPlayer(String filePath, boolean continous) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.running = true;
        this.filePath = filePath;
        this.continous = continous;
        this.as = AudioSystem.getAudioInputStream(new File ("/Users/abdu/Desktop/Projects/Uni/Software Design/myProject/out/production/myProject/com/myProject/Sounds/" + this.filePath + ".wav"));
        this.playCompleted = false;
        AudioFormat format = this.as.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        this.audioClip = (Clip) AudioSystem.getLine(info);
        this.audioClip.addLineListener(this);
        this.audioClip.open(as);
        this.audioClip.start();
        Thread thread = new Thread(this);
        thread.start();
    }

    public void change(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(!playCompleted) audioClip.close();
        this.filePath = filePath;
        this.as = AudioSystem.getAudioInputStream(new File ("/Users/abdu/Desktop/Projects/Uni/Software Design/myProject/out/production/myProject/com/myProject/Sounds/" + this.filePath + ".wav"));
        this.playCompleted = false;
        AudioFormat format = this.as.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        this.audioClip = (Clip) AudioSystem.getLine(info);
        this.audioClip.addLineListener(this);
        this.audioClip.open(as);
        this.audioClip.start();
    }

    private synchronized void close() { this.running = false; }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP) playCompleted = true;
    }

    @Override
    public void run() {
        while (running) {
            try {
                while (!playCompleted && running) Thread.sleep(1000);
                if(!continous) break;
                change(this.filePath);
            } catch (InterruptedException | IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        audioClip.close();
        try {
            as.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
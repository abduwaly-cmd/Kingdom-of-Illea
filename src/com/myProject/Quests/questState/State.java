package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface State {
    public void next(Quest quest, Player player, String[] str) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException;
    public void printStatus();
}
package com.myProject.Observer;
import com.myProject.Main.Console;
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String[] a, Console console);
}

package com.myProject.Observer;
import com.myProject.Driver.Console;
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String[] a, Console console);
}

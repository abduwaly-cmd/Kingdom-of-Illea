package com.myProject.Observer;
import com.myProject.Main.Console;

public abstract class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() { }

    @Override
    public void update(String[] in, Console console) { }
}
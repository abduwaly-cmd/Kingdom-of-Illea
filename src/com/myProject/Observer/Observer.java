package com.myProject.Observer;

import com.myProject.Main.Console;

public interface Observer {
    void update();
    void update(String[] in, Console console);
}

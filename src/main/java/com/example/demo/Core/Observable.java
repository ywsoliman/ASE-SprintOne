package com.example.demo.Core;

public interface Observable {
    public void subscribe(String source, String destination);
    public void unsubscribe(Observer o);
    public void update();
}

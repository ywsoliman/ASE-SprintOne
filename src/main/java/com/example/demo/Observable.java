package com.example.demo;

public interface Observable {
    public void subscribe(String source, String destination);
    public void unsubscribe(Observer o);
    public void update();
}

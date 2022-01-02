package com.example.demo.SystemLogin;

import com.example.demo.Database.AppSystem;
import com.example.demo.Core.Member;

public abstract class Login {

    AppSystem system = AppSystem.getAppSystem();
    public abstract Member login(String username, String password);

}

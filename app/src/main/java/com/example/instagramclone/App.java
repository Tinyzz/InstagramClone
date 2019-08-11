package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("GtbkIokiMi65lgCk7esAfQ2ETr4Wfe4C1kCnQgqu")
                // if defined
                .clientKey("Ez7g9VPJaddoI7vQlU5NTJHCHrQvNT8WXoYUitt9")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}

package com.jllalt.mystockapp.configuration;

import com.jllalt.mystockapp.MainActivity;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}

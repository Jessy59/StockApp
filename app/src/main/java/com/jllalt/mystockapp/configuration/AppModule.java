package com.jllalt.mystockapp.configuration;

import android.app.Application;
import android.content.Context;

import com.jllalt.mystockapp.services.ProductServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
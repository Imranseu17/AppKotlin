package com.example.root.lifecycleawaredemo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MainActivityObserver implements LifecycleObserver {

     private String Tag = this.getClass().getSimpleName();

     @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreateEvent(){

         Log.i(Tag,"Observer ON_CREATE");

        }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartEvent(){

        Log.i(Tag,"Observer ON_START");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent(){

        Log.i(Tag,"Observer ON_RESUME");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseEvent(){

        Log.i(Tag,"Observer ON_PAUSE");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopEvent(){

        Log.i(Tag,"Observer ON_STOP");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyEvent(){

        Log.i(Tag,"Observer ON_DESTROY");

    }
}

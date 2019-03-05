package com.example.root.lifecycleawaredemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(TAG,"Owner on_Create");
        getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Owner on_Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Owner on_Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Owner on_Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Owner on_Destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Owner on_Stop");
    }
}

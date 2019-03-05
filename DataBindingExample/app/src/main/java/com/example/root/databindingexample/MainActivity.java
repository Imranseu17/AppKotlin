package com.example.root.databindingexample;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.root.databindingexample.databinding.ActivityMainBinding;
import com.example.root.databindingexample.model.User;

public class MainActivity extends AppCompatActivity {

    User user = new User("Imran","123");

    public void onLogin(){


        if(user.username.equals("Imran") && user.password.equals("123")){

            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
        }

        else {

            Toast.makeText(this,"Login Error",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.
                setContentView(this,R.layout.activity_main);

        activityMainBinding.setUser(user);
        activityMainBinding.setActivity(this);
    }
}

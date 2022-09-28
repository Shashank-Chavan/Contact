package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this(contact list page) will be the opening screen of our application
        //hence in the below code  the fragment will be added in the container
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.Container,new Contact_Page()).commit();
    }
}
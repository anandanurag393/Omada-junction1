package com.omada.junction;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class Junction extends AppCompatActivity {

    int activeScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junction_activity_layout);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_area, FeedScreen.newInstance(), null)
                .disallowAddToBackStack()
                .commit();

        activeScreen = 1;
    }

    public void setActiveScreen(int activeScreen){
        if(activeScreen == this.activeScreen){
            return;
        }
        //fragment transaction code here
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_area, FeedScreen.newInstance(), null)
                .disallowAddToBackStack()
                .commit();

    }

}


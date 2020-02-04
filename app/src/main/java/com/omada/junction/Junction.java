package com.omada.junction;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

//TODO
//
//Create layout for card
//Create Cardholder scrollview class
//Create mechanism to display multiple possible Cardholders in same feedscreen fragment

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
        Object fr;
        switch(activeScreen){
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, ExploreScreen.newInstance(), null)
                        .disallowAddToBackStack()
                        .commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, FeedScreen.newInstance(), null)
                        .disallowAddToBackStack()
                        .commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, MoreScreen.newInstance(), null)
                        .disallowAddToBackStack()
                        .commit();
                break;

        }


    }

}


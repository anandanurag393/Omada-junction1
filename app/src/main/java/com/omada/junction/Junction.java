package com.omada.junction;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//TODO
//
//Create mechanism to display multiple possible Cardholders in same feedscreen fragment

public class Junction extends AppCompatActivity {

    int activeScreen;

    private Fragment feedScreen;
    private Fragment exploreScreen;
    private Fragment moreScreen;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junction_activity_layout);

        this.feedScreen = FeedScreen.newInstance();
        this.exploreScreen = ExploreScreen.newInstance();
        this.moreScreen = MoreScreen.newInstance();

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.content_area, this.moreScreen, null)
                .commit();

        activeScreen = 2;

    }

    public void setActiveScreen(int activeScreen){

        switch(activeScreen){
            case 0:
                if(this.activeScreen == 0){
                    exploreScreen = null;
                    exploreScreen = ExploreScreen.newInstance();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_area, exploreScreen, null)
                        .commit();
                break;
            case 1:
                if(this.activeScreen == 1){
                    feedScreen = null;
                    feedScreen = FeedScreen.newInstance();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_area, feedScreen, null)
                        .commit();
                break;
            case 2:
                if(this.activeScreen == 2){
                    moreScreen = null;
                    moreScreen = MoreScreen.newInstance();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_area, moreScreen, null)
                        .commit();
                break;

        }

        this.activeScreen = activeScreen;


    }

}


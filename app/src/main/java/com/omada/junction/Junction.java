package com.omada.junction;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

//TODO
//
//Create mechanism to display multiple possible Cardholders in same feedscreen fragment

public class Junction extends AppCompatActivity {

    int activeScreen;

    Fragment feedScreen;
    Fragment exploreScreen;
    Fragment moreScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.junction_activity_layout);

        this.feedScreen = FeedScreen.newInstance();
        this.exploreScreen = ExploreScreen.newInstance();
        this.moreScreen = MoreScreen.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_area, this.feedScreen, null)
                .disallowAddToBackStack()
                .commit();

        activeScreen = 1;
    }

    public void setActiveScreen(int activeScreen){
        if(activeScreen == this.activeScreen){
            return;
        }

        switch(activeScreen){
            case 0:
                if(this.activeScreen == 0){
                    exploreScreen = null;
                    exploreScreen = ExploreScreen.newInstance();
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, exploreScreen, null)
                        .commit();
                break;
            case 1:
                if(this.activeScreen == 1){
                    feedScreen = null;
                    feedScreen = FeedScreen.newInstance();
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, feedScreen, null)
                        .commit();
                break;
            case 2:
                if(this.activeScreen == 2){
                    moreScreen = null;
                    moreScreen = MoreScreen.newInstance();
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_area, moreScreen, null)
                        .commit();
                break;

        }


    }

}


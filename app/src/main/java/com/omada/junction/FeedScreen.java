package com.omada.junction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;


public class FeedScreen extends Fragment {
    //code goes here

    private int nextCardId;
    private LinearLayout feedScreenLayout;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        nextCardId = 0;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.feed_screen_layout, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle b){
        feedScreenLayout = getView().findViewById(R.id.feed_screen_root);
    }
    public static FeedScreen newInstance(){
        FeedScreen f = new FeedScreen();
        //put arguments here
        return f;
    }
}

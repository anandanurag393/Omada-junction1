package com.omada.junction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ExploreScreen extends Fragment {

    @Override
    public void onCreate(Bundle s){
        super.onCreate(s);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.explore_screen_layout, container, false);
    }


    public static ExploreScreen newInstance(){
        ExploreScreen f = new ExploreScreen();
        //put arguments here
        return f;
    }
}

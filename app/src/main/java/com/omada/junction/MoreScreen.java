package com.omada.junction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MoreScreen extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.more_screen_layout, container, false);
        //TODO
        //attach functionalities, styles and listeners to buttons in view here
        return view;
    }

    public static MoreScreen newInstance(){
        MoreScreen f = new MoreScreen();
        //put arguments here
        return f;
    }
}

package com.example.omada;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class MoreScreen extends LinearLayout{
    public MoreScreen(Context c) {
        super(c);
        LayoutInflater.from(getContext()).inflate(R.layout.more_screen_layout, this);
    }
}

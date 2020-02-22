package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class SearchBar extends LinearLayout{

    public SearchBar(Context c, AttributeSet attrs){
        super(c, attrs);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.search_bar_layout, this);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                if(v.getId() == R.id.search_bar_button){
                    //TODO
                    //search function here
                }
            }
        });
    }
}

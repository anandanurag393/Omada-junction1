package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class TopToolbar extends HorizontalScrollView {

    int last_button_id = 0;

    public TopToolbar(Context c, AttributeSet attrs){
        super(c, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.top_toolbar_layout, this);

    }

    protected void AddButton(String text, String tag){

        LinearLayout container = (LinearLayout) (findViewById(R.id.top_toolbar_horizontalscrollview)).findViewById(R.id.top_toolbar_linearlayout);
        TopToolbarButton new_btn = new TopToolbarButton(getContext(), null, "For You");

        new_btn.setId(last_button_id++);
        new_btn.setTag(tag);

        container.addView(new_btn);
    }
}

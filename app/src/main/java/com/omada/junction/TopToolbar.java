package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class TopToolbar extends HorizontalScrollView {

    int lastButtonId = 0;

    public TopToolbar(Context c, AttributeSet attrs){
        super(c, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.top_toolbar_layout, this);

    }

    protected void addButton(String text, String tag){

        LinearLayout container = (LinearLayout) (findViewById(R.id.top_toolbar_horizontalscrollview)).findViewById(R.id.top_toolbar_linearlayout);
        TopToolbarButton new_btn = new TopToolbarButton(getContext(), null, text);

        new_btn.setId(lastButtonId++);
        new_btn.setTag(tag);
        //change button properties here if needed

        container.addView(new_btn);
    }
}

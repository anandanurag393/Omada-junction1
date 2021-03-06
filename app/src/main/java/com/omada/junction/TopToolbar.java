package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class TopToolbar extends HorizontalScrollView{

    private int lastButtonId;
    private int pressedButtonId;

    private CardScroller cardScroller;

    public TopToolbar(Context c, AttributeSet attrs){
        super(c, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.top_toolbar_layout, this);

        pressedButtonId = 0;
        lastButtonId = -1;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                ((TopToolbarButton)findViewById(pressedButtonId)).changeImage();
                pressedButtonId = v.getId();
                ((TopToolbarButton)v).changeImage();
                ((TopToolbarButton)v).carryOutAction();
            }
        });
    }

    @Override
    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        this.cardScroller = ((ViewGroup)getParent()).findViewById(R.id.junction_card_scroller);

    }


    protected void addButton(String text, String tag){

        LinearLayout container = (findViewById(R.id.top_toolbar_linearlayout));
        TopToolbarButton new_btn = new TopToolbarButton(getContext(), null, text);

        new_btn.setId(lastButtonId + 1);
        new_btn.setTag(tag);
        //change button properties here if needed

        container.addView(new_btn);

        if(lastButtonId == -1){
            new_btn.changeImage();
        }

        lastButtonId += 1;
    }

    public CardScroller getCardScroller(){

        return this.cardScroller;
    }
}

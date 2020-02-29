package com.omada.junction;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

public class JunctionCard extends HorizontalScrollView {

    FrameLayout cardFace;
    FrameLayout cardDesc;
    int activeCard = 0;
    int cardsList = 2;
    private float spaceWidth;

    public JunctionCard(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.card_layout, this);

        int marg = (int)JunctionUtilities.DP_to_PX(getContext(), 20);
        ((MarginLayoutParams)(findViewById(R.id.card_container_linearlayout)).getLayoutParams()).setMargins(0, marg, 0, marg);

    }

    @Override
    public void onAttachedToWindow(){

        super.onAttachedToWindow();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float screenWidth = displayMetrics.widthPixels;

        this.spaceWidth = (screenWidth - getResources().getDimension(R.dimen.card_content_width))/2;
        //Toast.makeText(getContext(), ""+spaceWidth+ " " + screenWidth + " " + JunctionUtilities.DP_to_PX(getContext(), getResources().getDimension(R.dimen.card_content_width)), Toast.LENGTH_SHORT).show();

        this.cardFace = findViewById(R.id.card_face);
        this.cardDesc = findViewById(R.id.card_details);

        MarginLayoutParams faceMargins;

        faceMargins = (MarginLayoutParams) (cardFace.getLayoutParams());
        faceMargins.setMargins((int)spaceWidth, 0, (int)spaceWidth, 0);
        cardFace.setLayoutParams(faceMargins);

        faceMargins = (MarginLayoutParams) (cardDesc.getLayoutParams());
        faceMargins.setMargins(0, 0, (int)spaceWidth, 0);
        cardDesc.setLayoutParams(faceMargins);

        (this.getLayoutParams()).height = LayoutParams.WRAP_CONTENT;
        (this.getLayoutParams()).width = LayoutParams.MATCH_PARENT;

        this.requestLayout();

        setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //If the user swipes

                if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL ){
                    int scrollX = getScrollX();
                    activeCard = ((scrollX + (int)(getResources().getDimension(R.dimen.card_desc_width)/2))/(int)getResources().getDimension(R.dimen.card_desc_width));
                    int scrollTo = activeCard * (int)getResources().getDimension(R.dimen.card_desc_width) + (activeCard==1 ? (int)spaceWidth : 0);
                    smoothScrollTo(scrollTo, 0);
                    return true;
                }
                else{
                    return false;
                }
            }
        });
    }


    protected void styleCardFace(){
        //TODO
        //use this as an overridden method in inheriting classes

    }
    protected void styleCardDesc(){
        //TODO
        //use this as an overridden method in inheriting classes
    }

}

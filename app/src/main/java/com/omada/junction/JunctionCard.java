package com.omada.junction;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

public class JunctionCard extends HorizontalScrollView {

    FrameLayout cardFace;
    FrameLayout cardDesc;

    public JunctionCard(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.card_layout, this);

    }

    @Override
    public void onAttachedToWindow(){

        super.onAttachedToWindow();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float screenWidth = displayMetrics.widthPixels;

        float spaceWidth = (screenWidth - getResources().getDimension(R.dimen.card_content_width))/2;
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

        this.requestLayout();
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

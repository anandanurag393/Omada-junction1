package com.omada.junction;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;

public class JunctionCard extends HorizontalScrollView {

    FrameLayout cardFace;
    FrameLayout cardDesc;

    public JunctionCard(Context context, AttributeSet attrs) {
        super(context, attrs);


        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.card_layout, this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float screenWidth = displayMetrics.widthPixels;

        float spaceWidth = (screenWidth - JunctionUtilities.DP_to_PX(getContext(), getResources().getDimension(R.dimen.card_content_width)))/2;

        this.cardFace = findViewById(R.id.card_face);
        this.cardDesc = findViewById(R.id.card_details);

        MarginLayoutParams faceMargins;

        faceMargins = (MarginLayoutParams) (cardFace.getLayoutParams());
        faceMargins.leftMargin = (int)spaceWidth;
        faceMargins.rightMargin = (int)spaceWidth;

        faceMargins = (MarginLayoutParams) (cardDesc.getLayoutParams());
        faceMargins.leftMargin = 0;
        faceMargins.rightMargin = (int)spaceWidth;

    }

    protected void styleCardFace(){

    }
    protected void styleCardDesc(){

    }

}

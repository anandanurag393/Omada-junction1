package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class PersonalDetails extends RelativeLayout {
    public PersonalDetails(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.personal_details,this);
    }

}

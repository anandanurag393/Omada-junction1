package com.omada.junction;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class AutofillSettings extends LinearLayout
{

    public AutofillSettings(Context context) {
        super(context);
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.autofill_settings_layout,this,true);
    }
}

package com.lmw.livebus.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class Adapters {
    @BindingAdapter("setText")
    public static void setText(View view, String str) {
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        } else if (view instanceof Button) {
            ((Button) view).setText(str);
        }
    }
}

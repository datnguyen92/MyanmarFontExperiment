package com.myanmarexperiment.datnt.myanmarfontexperiment;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by thanhdat.nguyen on 4/19/17.
 */

public class UNEditText extends AppCompatEditText {
    public UNEditText(Context context) {
        super(context);
        setTF(context);
    }

    public UNEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTF(context);
    }

    public UNEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTF(context);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        setTF(getContext());
    }

    private void setTF(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_regular));
        setTypeface(tf);
    }
}

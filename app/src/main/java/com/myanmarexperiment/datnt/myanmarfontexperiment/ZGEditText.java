package com.myanmarexperiment.datnt.myanmarfontexperiment;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class ZGEditText extends AppCompatEditText {
    public ZGEditText(Context context) {
        super(context);
        setTF(context);
    }

    public ZGEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTF(context);
    }

    public ZGEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTF(context);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        setTF(getContext());
    }

    private void setTF(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.font_zawgyi));
        setTypeface(tf);
    }
}
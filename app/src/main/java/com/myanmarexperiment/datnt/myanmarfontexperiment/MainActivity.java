package com.myanmarexperiment.datnt.myanmarfontexperiment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleUtils.wrapContext(newBase));
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        LinearLayout lnContainer = (LinearLayout) findViewById(R.id.lnContainer);
        LinearLayout lnZawgyiContainer = (LinearLayout) findViewById(R.id.lnZawgyiContainer);
        prepareUnicode(this, lnContainer);
        prepareZawgyi(this, lnZawgyiContainer);
    }


    /**
     * Reference goes to this author https://github.com/htoomyintnaung/mmtext
     */
    public static void prepareUnicode(Context c, ViewGroup root) {
        Typeface tf = Typeface.createFromAsset(c.getAssets(), c.getString(R.string.font_regular));

        if (root == null) return;
        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(tf);
                ((TextView) v).setText(((TextView) v).getText().toString());
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(tf);
                ((Button) v).setText(((Button) v).getText().toString());
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(tf);
                ((EditText) v).setHint(((EditText) v).getHint().toString());
            } else if (v instanceof ViewGroup) {
                prepareUnicode(c, (ViewGroup) v);
            }
        }
    }

    public static void prepareZawgyi(Context c, ViewGroup root) {
        Typeface tf = Typeface.createFromAsset(c.getAssets(), c.getString(R.string.font_zawgyi));

        if (root == null) return;
        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(tf);
                ((TextView) v).setText(((TextView) v).getText().toString());
            } else if (v instanceof Button) {
                ((Button) v).setTypeface(tf);
                ((Button) v).setText(((Button) v).getText().toString());
            } else if (v instanceof EditText) {
                ((EditText) v).setTypeface(tf);
                ((EditText) v).setHint(((EditText) v).getHint().toString());
            } else if (v instanceof ViewGroup) {
                prepareUnicode(c, (ViewGroup) v);
            }
        }
    }
}

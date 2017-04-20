package com.myanmarexperiment.datnt.myanmarfontexperiment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UNEditText edtUnicode = (UNEditText) findViewById(R.id.edt_unicode);
        ZGEditText edtZawgyi = (ZGEditText) findViewById(R.id.edt_zawgyi);

        edtUnicode.setText(R.string.unicode_string);
        edtZawgyi.setText(R.string.zawgyi_string);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleUtils.wrapContext(newBase));
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

    }
}

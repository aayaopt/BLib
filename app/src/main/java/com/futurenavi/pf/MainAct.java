package com.futurenavi.pf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import futurenavi.lib.Text;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Text.getTextStr();
    }
}

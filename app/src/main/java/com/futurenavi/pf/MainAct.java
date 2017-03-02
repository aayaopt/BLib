package com.futurenavi.pf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.futurenavi.pf.erecyclerview.ERecyclerviewAct;
import com.futurenavi.pf.evideo.EVideoAct;

public class MainAct extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainAct.this, EVideoAct.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_receylerview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainAct.this, ERecyclerviewAct.class);
                startActivity(intent);
            }
        });
    }
}

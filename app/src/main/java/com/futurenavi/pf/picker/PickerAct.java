package com.futurenavi.pf.picker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.futurenavi.pf.R;

import java.util.ArrayList;

import futurenavi.lib.picker.ImagePicker;
import futurenavi.lib.picker.bean.ImageItem;
import futurenavi.lib.picker.ui.ImageGridActivity;
import futurenavi.lib.picker.ui.ImagePreviewActivity;

public class PickerAct extends AppCompatActivity {

    public static final int IMAGE_PICKER = 100;
    ImageView iv;
boolean mulei=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_picker);
        iv = (ImageView) findViewById(R.id.iv_picker);
        findViewById(R.id.btn_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mulei){
                    mulei=false;
                }else{
                    mulei=true;
                }
                Intent intent = new Intent(PickerAct.this, ImageGridActivity.class);
                intent.putExtra(ImageGridActivity.forMulei,mulei);
                startActivityForResult(intent, IMAGE_PICKER);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {//返回多张照片
            if (data != null) {
                //是否发送原图
                boolean isOrig = data.getBooleanExtra(ImagePreviewActivity.ISORIGIN, false);
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra
                        (ImagePicker.EXTRA_RESULT_ITEMS);

                Log.e("CSDN_LQR", isOrig ? "发原图" : "不发原图");//若不发原图的话，需要在自己在项目中做好压缩图片算法
                for (ImageItem imageItem : images) {
                    Log.e("CSDN_LQR", imageItem.path);
                }
                Log.e("CSDN_LQR", images.get(0).path);
                iv.setImageURI(Uri.parse(images.get(0).path));
            }
        }
    }
}

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
import futurenavi.lib.picker.ui.ImagePreviewDelActivity;

import static futurenavi.lib.picker.ImagePicker.EXTRA_IMAGE_ITEMS;

public class PickerAct extends AppCompatActivity {

    public static final int IMAGE_PICKER = 100;
    private ImageView iv;
    private ArrayList<ImageItem> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_picker);
        iv = (ImageView) findViewById(R.id.iv_picker);

        //选一张
        findViewById(R.id.btn_picker_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUI(false);
            }
        });
        //选多张
        findViewById(R.id.btn_picker_change_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUI(true);
            }
        });

        //展示选择的照片
        findViewById(R.id.btn_picker_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (images != null) {
                        if ( images.size() > 0) {
                            Intent intent = new Intent(PickerAct.this, ImagePreviewDelActivity.class);
                            intent.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, 0);
                            intent.putExtra(EXTRA_IMAGE_ITEMS, images);
                            intent.putExtra(ImagePreviewActivity.ISORIGIN, true);
                            startActivityForResult(intent, ImagePicker.REQUEST_CODE_PREVIEW);
                        }else{
                            Log.e("wzk", " images.size() < 0" );
                        }
                    }else{
                        Log.e("wzk", "images==null" );
                    }
                } catch (Exception e) {
                    Log.e("wzk", "catch" + e.toString());
                }

            }
        });
    }

    private void callUI(boolean isChageMore) {
        Intent intent = new Intent(PickerAct.this, ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.forMulei, isChageMore);
        startActivityForResult(intent, IMAGE_PICKER);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {//返回多张照片
            if (data != null) {
                //是否发送原图
                boolean isOrig = data.getBooleanExtra(ImagePreviewActivity.ISORIGIN, false);
                images = (ArrayList<ImageItem>) data.getSerializableExtra
                        (ImagePicker.EXTRA_RESULT_ITEMS);
                if (images.size() > 0) {
                    Log.e("CSDN_LQR", isOrig ? "发原图" : "不发原图");//若不发原图的话，需要在自己在项目中做好压缩图片算法
                    for (ImageItem imageItem : images) {
                        Log.e("CSDN_LQR", imageItem.path);
                    }
                    Log.e("CSDN_LQR", images.get(0).path);
                    iv.setImageURI(Uri.parse(images.get(0).path));
                }
            }
        }

        if (resultCode == ImagePicker.RESULT_CODE_BACK) {
            if (data != null) {
                Log.e("wzk", "images获取到新的数据");
                images = (ArrayList<ImageItem>) data.getSerializableExtra
                        (ImagePicker.EXTRA_IMAGE_ITEMS);
                Log.e("wzk", "images获取到新的数据"+images.size());
            }

        }
    }
}

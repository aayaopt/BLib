package com.futurenavi.pf.erecyclerview.adapter.viewholder;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.futurenavi.pf.R;
import com.futurenavi.pf.erecyclerview.model.Child;


public class ChildViewHolder extends futurenavi.lib.erecyclerview.expandablerecyclerview.viewholders
        .ChildViewHolder {

    private TextView childTextView,tvChildType,tvChildUpTime;
    RelativeLayout flayoutItem;
    private Activity mAct;

    public ChildViewHolder(View itemView) {
        super(itemView);
        flayoutItem = (RelativeLayout) itemView.findViewById(R.id.flayout_item);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_song_name);
        tvChildType = (TextView) itemView.findViewById(R.id.tv_child_type);
        tvChildUpTime = (TextView) itemView.findViewById(R.id.tv_child_uptime);
    }

    public void setSongName(Child child, int childIndex) {
        childTextView.setText(child.name);
        tvChildType.setText(child.type);
        tvChildUpTime.setText(child.time);

        setLayoutClick(flayoutItem,childIndex);
    }



    private void setLayoutClick(View v, final int childIndex) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("WZK","setLayoutClick被点击了---->"+childIndex);
            }
        });
    }


}

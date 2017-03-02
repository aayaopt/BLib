package com.futurenavi.pf.erecyclerview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.futurenavi.pf.R;
import com.futurenavi.pf.erecyclerview.adapter.viewholder.ChildViewHolder;
import com.futurenavi.pf.erecyclerview.adapter.viewholder.GroupViewHolder;
import com.futurenavi.pf.erecyclerview.model.Child;
import com.futurenavi.pf.erecyclerview.model.Group;

import java.util.List;

import ljying.github.io.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import ljying.github.io.expandablerecyclerview.models.ExpandableGroup;


public class GroupAdapter extends ExpandableRecyclerViewAdapter<GroupViewHolder, ChildViewHolder> {

  private final Activity mAct;
  public GroupAdapter(List<? extends ExpandableGroup> groups, Activity
          act) {
    super(groups);
    this.mAct=act;
  }

  @Override
  public GroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.act_recycler_item_band, parent, false);
    return new GroupViewHolder(view);
  }

  @Override
  public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View childView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.act_recycler_item_song, parent, false);

    return new ChildViewHolder(childView);
  }

  @Override
  public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition,
                                    ExpandableGroup group, int childIndex) {

    final Child child = ((Group) group).getItems().get(childIndex);
    holder.setSongName(child,childIndex);
  }

  @Override
  public void onBindGroupViewHolder(GroupViewHolder holder, int flatPosition, ExpandableGroup group) {

    holder.setBandName(group);
  }
}

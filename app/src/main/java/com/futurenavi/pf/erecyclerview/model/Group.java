package com.futurenavi.pf.erecyclerview.model;

import java.util.List;

import futurenavi.lib.erecyclerview.expandablerecyclerview.models.ExpandableGroup;


public class Group extends ExpandableGroup<Child> {

  public Group(String title, List<Child> items) {
    super(title, items);
  }
}

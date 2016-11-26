package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Bye Bye Burger Navigation Bar Behavior
 *
 * Created by wing on 11/5/16.
 */

public class ByeBurgerBottomBehavior extends ByeBurgerBehavior {

  public ByeBurgerBottomBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {


    return true;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
    if (canInit) {
      canInit = false;
      mAnimateHelper = TranslateAnimateHelper.get(child);
      mAnimateHelper.setStartY(child.getY());
      mAnimateHelper.setMode(TranslateAnimateHelper.MODE_BOTTOM);
    }
    return super.onDependentViewChanged(parent, child, dependency);
  }



  @Override protected void onNestPreScrollInit(View child) {

  }
}

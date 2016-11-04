package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Bye Bye Burger Android Bottom Navigation Behavior
 *
 * Created by wing on 11/4/16.
 */

public class ByeBurgerBehavior extends CoordinatorLayout.Behavior<ByeBurgerNavigationView> {

  private final int mTouchSlop;
  private boolean isFirstMove = true;

  public ByeBurgerBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);

    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  // on Scroll Started
  @Override public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
      ByeBurgerNavigationView child, View directTargetChild, View target, int nestedScrollAxes) {

    return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
  }

  @Override
  public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, ByeBurgerNavigationView child,
      View target, int dx, int dy, int[] consumed) {

    if (isFirstMove) {
      isFirstMove = false;

      child.setStartY(child.getY());
    }
    if (Math.abs(dy) > mTouchSlop) {
      if (dy < 0) {

        if (child.getState() == ByeBurgerNavigationView.STATE_HIDE) {
          child.show();
        }
      } else if (dy > 0) {
        if (child.getState() == ByeBurgerNavigationView.STATE_SHOW) {
          child.hide();
        }
      }
    }
  }
}

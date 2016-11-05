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

public class ByeBurgerBottomBehavior extends CoordinatorLayout.Behavior<View> {

  private final int mTouchSlop;
  private boolean isFirstMove = true;
  private AnimateHelper mAnimateHelper;

  public ByeBurgerBottomBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);

    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  // on Scroll Started
  @Override public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
      View directTargetChild, View target, int nestedScrollAxes) {

    return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
  }

  @Override
  public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
      int dx, int dy, int[] consumed) {

    if (isFirstMove) {
      isFirstMove = false;
      mAnimateHelper = AnimateHelper.get(child);
      mAnimateHelper.setStartY(child.getY());
      mAnimateHelper.setMode(AnimateHelper.MODE_BOTTOM);
    }
    if (Math.abs(dy) > mTouchSlop) {
      if (dy < 0) {

        if (mAnimateHelper.getState() == AnimateHelper.STATE_HIDE) {
          mAnimateHelper.show();
        }
      } else if (dy > 0) {
        if (mAnimateHelper.getState() == AnimateHelper.STATE_SHOW) {
          mAnimateHelper.hide();
        }
      }
    }
  }
}

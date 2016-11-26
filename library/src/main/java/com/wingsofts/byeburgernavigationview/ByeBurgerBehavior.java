package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * Base Behavior
 * Created by wing on 11/8/16.
 */

abstract public class ByeBurgerBehavior extends CoordinatorLayout.Behavior<View> {

  protected final int mTouchSlop;
  protected boolean isFirstMove = true;
  protected boolean canInit = true;
  protected AnimateHelper mAnimateHelper;

  public ByeBurgerBehavior(Context context, AttributeSet attrs) {
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
    onNestPreScrollInit(child);

    if (Math.abs(dy) > 2) {
      if (dy < 0) {
        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_HIDE) {
          mAnimateHelper.show();
        }
      } else if (dy > 0) {
        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_SHOW) {
          mAnimateHelper.hide();
        }
      }
    }
  }

  protected abstract void onNestPreScrollInit(View child);

  public void show() {
    mAnimateHelper.show();
  }

  public void hide() {
    mAnimateHelper.hide();
  }

  public static ByeBurgerBehavior from(View view) {
    ViewGroup.LayoutParams params = view.getLayoutParams();
    if (!(params instanceof CoordinatorLayout.LayoutParams)) {
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
    if (!(behavior instanceof ByeBurgerBehavior)) {
      throw new IllegalArgumentException("The view is not associated with ByeBurgerBehavior");
    }
    return (ByeBurgerBehavior) behavior;
  }
}

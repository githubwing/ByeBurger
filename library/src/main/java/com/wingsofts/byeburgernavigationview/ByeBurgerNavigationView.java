package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * BYE BYE BURGER!
 * Created by wing on 11/4/16.
 */

public class ByeBurgerNavigationView extends BottomNavigationView
    implements Animation.AnimationListener {

  public static String BEHAVIOR = "";
  public static int STATE_SHOW = 1;
  public static int STATE_HIDE = 0;

  public int mState = STATE_SHOW;

  private float mStartY = 0;

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    mStartY = getY();
  }

  public int getState() {
    return mState;
  }

  public void show() {

    setY(mStartY);
    TranslateAnimation ta = new TranslateAnimation(0f, 0f,getMeasuredHeight(),0);
    ta.setDuration(300);
    ta.setAnimationListener(this);
    startAnimation(ta);

  }

  public void showWithoutAnimate(){

    setY(mStartY);
    mState = STATE_SHOW;
  }

  public void setStartY(float y) {
    mStartY = y;
  }

  public void hide() {
    setY(mStartY + getMeasuredHeight());

    TranslateAnimation ta = new TranslateAnimation(0f, 0f, -getMeasuredHeight(), getMeasuredHeight());
    ta.setDuration(300);
    ta.setAnimationListener(this);
    startAnimation(ta);
  }

  public ByeBurgerNavigationView(Context context) {
    super(context);
  }

  public ByeBurgerNavigationView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ByeBurgerNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public void onAnimationStart(Animation animation) {

  }

  @Override public void onAnimationEnd(Animation animation) {

    if (mState == STATE_SHOW) {
      mState = STATE_HIDE;
    } else if
        (mState == STATE_HIDE) {
      mState = STATE_SHOW;
    }
  }

  @Override public void onAnimationRepeat(Animation animation) {

  }
}

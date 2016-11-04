# ByeBurgerNavigationView
滚粗吧 汉堡菜单
[![](https://jitpack.io/v/githubwing/ByeBurgerNavigationView.svg)](https://jitpack.io/#githubwing/ByeBurgerNavigationView)

这是一个全新底部菜单交互的实现 [再见，汉堡菜单，我们有了新的 Android 交互设计方案](https://github.com/xitu/gold-miner/blob/master/TODO/bye-bye-burger.md)


![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/preview.gif)



> *   **滚动时隐藏：** 我们希望在用户的屏幕上显示尽可能多的内容。因此，我们决定在向下滚动的时候隐藏导航栏，从而给内容区域提供更多的空间。而向上滚动可以使导航栏重新显现。
> *   **变换式导航栏：** Material Design 底部栏有一个非常平滑的动画，它参考了变换式导航栏——在不同目标间切换的时候，被选中的部分会被放大，同时未被选中的元素会被向后移动，从而在导航栏上浏览不同的目标就有点像在浏览一个旋转木马。我们决定要使用这种效果因为它使得切换导航目标变得更加有趣了。我们希望这可以推动我们的用户更多地在应用的不同功能组间切换。同时，该动画在我们的下一个观点中非常重要。

# 使用

在gradle 编译库文件

```

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}


dependencies {
  compile 'com.github.githubwing:ByeBurgerNavigationView:v1.0'
  compile 'com.android.support:design:25.0.0'
  }
```
在布局中。使用CoordinatorLayout作为跟布局

```
<android.support.design.widget.CoordinatorLayout>
  <Viewpager />
  <com.wingsofts.byeburgernavigationview.ByeBurgerNavigationView 
      <--! important --> 
        app:menu="@menu/bottom"
        app:layout_behavior="@string/bye_burger_behavior"  
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:itemIconTint="@color/colorPrimary"
        app:itemTextColor="@color/colorPrimary"
   />
      
</android.support.design.widget.CoordinatorLayout>

```


在menu文件夹创建新的menu xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
  <item
      android:icon="@drawable/ic_home_black_24dp"
      android:enabled="true"
      app:showAsAction="ifRoom"
      android:title="home"/>

  <item
      android:icon="@drawable/ic_search_black_24dp"
      android:enabled="true"
      app:showAsAction="ifRoom"
      android:title="search"/>
  <item
      android:icon="@drawable/ic_account_circle_black_24dp"
      android:enabled="true"
      app:showAsAction="ifRoom"
      android:title="me"
      />
  <item
      android:icon="@drawable/ic_settings_black_24dp"
      android:enabled="true"
      app:showAsAction="ifRoom"
      android:title="setting"
      />
</menu>
```

添加选项监听器addOnSelectedListener
```
mByeBurger.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getTitle().equals("home")){
              mViewPager.setCurrentItem(0);
            }else if(item.getTitle().equals("search")){
              mViewPager.setCurrentItem(1);
            }else if(item.getTitle().equals("me")){
              mViewPager.setCurrentItem(2);
            }else if(item.getTitle().equals("setting")){
              mViewPager.setCurrentItem(3);
            }
            return false;
          }
        });
```

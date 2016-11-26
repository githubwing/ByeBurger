# ByeBurger
拜拜吧 汉堡菜单, 这是一个极其简便的快速实现隐藏标题栏和导航栏的库。

[![](https://jitpack.io/v/githubwing/ByeBurger.svg)](https://jitpack.io/#githubwing/ByeBurger)


这是一个全新底部菜单交互的实现 [再见，汉堡菜单，我们有了新的 Android 交互设计方案](https://github.com/xitu/gold-miner/blob/master/TODO/bye-bye-burger.md)


![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/title.gif)
![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/book.gif)
![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/webview.gif)


> *   **滚动时隐藏：** 我们希望在用户的屏幕上显示尽可能多的内容。因此，我们决定在向下滚动的时候隐藏导航栏，从而给内容区域提供更多的空间。而向上滚动可以使导航栏重新显现。
> *   **变换式导航栏：** Material Design 底部栏有一个非常平滑的动画，它参考了变换式导航栏——在不同目标间切换的时候，被选中的部分会被放大，同时未被选中的元素会被向后移动，从而在导航栏上浏览不同的目标就有点像在浏览一个旋转木马。我们决定要使用这种效果因为它使得切换导航目标变得更加有趣了。我们希望这可以推动我们的用户更多地在应用的不同功能组间切换。同时，该动画在我们的下一个观点中非常重要。

# 使用

在gradle 编译库文件

```gralde

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}


dependencies {
   compile 'com.github.githubwing:ByeBurger:1.2.3'
  compile 'com.android.support:design:25.0.0'
  }
```

你只需要在布局中，使用CoordinatorLayout作为根布局,然后向你的**任何**View中插入一句app:layout_behavior属性，即可实现滑动的隐藏和显示。你的标题栏可以是Toolbar或者LinearLayout或者什么鬼，同样你的底部导航栏可以是最新的BottomNavigationView亦或者TabLayout在古老一点的RadioButton都可以！

最新添加了对悬浮按钮的支持。

```xml
<android.support.design.widget.CoordinatorLayout>
 
  <Viewpager /><--! 这里放你的布局内容，可以是任意view-->
   <Toolbar 
  	app:layout_behavior="@string/bye_burger_title_behavior"
  />
  <BottomTab 
   android:layout_gravity="bottom"
   app:layout_behavior="@string/bye_burger_bottom_behavior"
  />      
  <FloatingActionButton
   app:layout_behavior="@string/bye_burger_float_behavior"
  />
</android.support.design.widget.CoordinatorLayout>

```
# 注意
CoordinatorLayout类似于FrameLayout，所以注意xml层次，Title和Bottom Tab要在xml下方。

只有实现NestScorll接口View的才可以实现监听，例如RecyclerView、NestScrollView.

在**ListView**下，是**不生效**的。

**所有需要隐藏的，必须作为CoordinatorLayout的直接子view**

你也可以手动调用如下方法，来控制显隐。

```
ByeBurgerBehavior.from(mToolbar).hide()

ByeBurgerBehavior.show(mFloatButton).show()
```

# License

    Copyright 2016 androidwing1992

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

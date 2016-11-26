# ByeBurger
[![](https://jitpack.io/v/githubwing/ByeBurger.svg)](https://jitpack.io/#githubwing/ByeBurger)


Bye Burger~  this is a easy way to make  your title or bottom navigation hiding on scroll like this

[Bye, Bye Burger!
What we learned from implementing the new Android Bottom Navigation](https://medium.com/startup-grind/bye-bye-burger-5bd963806015#.qibuxdc1t)


# [中文文档](https://github.com/githubwing/ByeBurger/blob/master/README_CN.md)

![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/title.gif)
![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/book.gif)
![image](https://github.com/githubwing/ByeBurgerNavigationView/raw/master/img/webview.gif)



> **Hiding on scroll:** We wanted to provide as much content as possible on our user’s screens. Consequently, we decided to make the navigation hide on scroll, thus making more room for the content area. Scrolling up makes the navigation fade back in.

> **Shifting navigation** : The Material Design bottom bar comes with a very slick animation, which is referred to as the Shifting navigation — when navigating between destinations the selected section icon is enlarged, moving the unselected element to the back. Flipping through destinations on the nav bar thus feels a bit like browsing through a carousel. We decided to utilize this effect as it adds a playful note to switching sections, which we hoped would nudge our users into navigating to different areas in the app more often. Further, the animation plays a major part in our next point…


# USAGE

compile the library in your build.gralde

```gradle

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

You only need to change the root view to CoordinatorLayout,
And add one line code "app:layout_behavior" like the bottom
into **ANY** view, Then your view hiding on scroll.
Your titleBar can be Toolbar,LinearLayout and so on. 
Your NavigationView can be BottomNavigationView or TabLayout,
or **Any** View you put in xml.

```xml
<android.support.design.widget.CoordinatorLayout>

  <Viewpager />
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

You can control it by call method show() hide()

```java
    ByeBurgerBehavior.from(mToolbar).hide()

    ByeBurgerBehavior.from(mFloatButton).show()

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

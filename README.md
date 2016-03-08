# WoWoViewPager
![WoWoViewPager App Intros Example](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/AppIntroExample.gif) 
![WoWoViewPager CV Example](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/CVExample.gif)

Optimized for scrolling app intros or making your CV app. Free and open source.

# Note
1. Thanks [JazzHands](https://github.com/IFTTT/JazzHands) for giving me inspiration.
2. I'll add more animations for WoWoViewPager.

# Demo
There is a demo for the current animations that WoWoViewPager supports. 
And there are App intros example and CV example(the above gifs) in the demo. 

# Animations Guide

### Basic Animations  

1. [Translation Animation](https://github.com/Nightonke/WoWoViewPager#translation-animation)
2. [Scale Animation](https://github.com/Nightonke/WoWoViewPager#scale-animation)
3. [Alpha Animation](https://github.com/Nightonke/WoWoViewPager#alpha-animation)
4. [Rotation Animation](https://github.com/Nightonke/WoWoViewPager#rotation-animation)

# Animations Usage  
### Basic Animations  
#### Translation Animation  
Translation animation helps to move a view.  
![Translation animation](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/TranslationAnimation.gif)  
```java
/**
 *
 * @param page                The translation animation will start from 
                              page(0, 1, ..., adapter.getCount() - 1)
                              
 * @param startOffset         The translation animation will start from this offset([0, 1]) 
                              when swiping from page to page + 1
                              
 * @param endOffset           The translation animation will end with this offset([0, 1]) 
                              when swiping from page to page + 1
                              
 * @param fromX               The starting horizontal position of this view 
                              relative to its left position, in pixels.
                              
 * @param fromY               The starting vertical position of this view 
                              relative to its top position, in pixels.
                              
 * @param targetX             The ending horizontal position of this view 
                              relative to its left position, in pixels.
                              
 * @param targetY             The ending vertical position of this view 
                              relative to its top position, in pixels.
                              
 * @param easeType            Ease type, please check the ease type section.
 
 * @param useSameEaseTypeBack Whether use the same ease type to back.
 */
ViewAnimation animation = new ViewAnimation(findViewById(R.id.test));
animation.addPageAnimaition(new WoWoTranslationAnimation(
        0, 
        0f, 
        1f,
        findViewById(R.id.test).getTranslationX(),
        findViewById(R.id.test).getTranslationY(),
        -screenW / 2 + WoWoUtil.dp2px(40, this),
        -screenH / 2 + WoWoUtil.dp2px(40, this),
        easeType,
        useSameEaseTypeBack));
animation.addPageAnimaition(new WoWoTranslationAnimation(
        1, 
        0f, 
        1f,
        -screenW / 2 + WoWoUtil.dp2px(40, this),
        -screenH / 2 + WoWoUtil.dp2px(40, this),
        screenW - WoWoUtil.dp2px(80, this),
        screenH - WoWoUtil.dp2px(80, this),
        easeType,
        useSameEaseTypeBack));
wowoViewPager.addAnimation(animation);
```
As you can see, the code above helps to make part of effect in the above gif(from page 1 to page 3, 2 translation animations totally). 
For more codes about translation animation, please check the [code](https://github.com/Nightonke/WoWoViewPager/blob/master/app/src/main/java/com/nightonke/wowoviewpagerexample/WoWoTranslationAnimationActivity.java).  

#### Scale Animation  
Scale animation helps to scale a view.  
![Scale animation](https://github.com/Nightonke/WoWoViewPager/blob/master/Pictures/ScaleAnimation.gif)  
```java
/**
 *
 * @param page                The scale animation will start from 
                              page(0, 1, ..., adapter.getCount() - 1)
                              
 * @param startOffset         The scale animation will start from this offset([0, 1]) 
                              when swiping from page to page + 1
                              
 * @param endOffset           The scale animation will end with this offset([0, 1]) 
                              when swiping from page to page + 1
                              
 * @param targetScaleX        Target scale x = target x / original y
 
 * @param targetScaleY        Target scale y = target y / original y
 
 * @param easeType            Ease type, please check the ease type section.
 
 * @param useSameEaseTypeBack Whether use the same ease type to back.
 */
ViewAnimation animation = new ViewAnimation(findViewById(R.id.test));
animation.addPageAnimaition(new WoWoScaleAnimation(
        3, 0f, 0.5f,
        2f,
        1f,
        easeType,
        useSameEaseTypeBack));
animation.addPageAnimaition(new WoWoScaleAnimation(
        3, 0.5f, 1f,
        1f,
        2f,
        easeType,
        useSameEaseTypeBack));
wowoViewPager.addAnimation(animation);
```
You can combine several animations to create a complex animation. For example, you can create 2 translation animations to make a polyline. Let's see the code above. From offset 0 to offset 0.5 starting from page 3, the width of the view doubles. And then, the height of the view doubles from offset 0.5 to offset 1. 
For more codes about scale animation, please check the [code](https://github.com/Nightonke/WoWoViewPager/blob/master/app/src/main/java/com/nightonke/wowoviewpagerexample/WoWoScaleAnimationActivity.java).  


#### Alpha Animation  
Alpha animation helps to change the opacity of the view, making fading or appearing effects. 
#### Rotation Animation  
Rotation animation helps to rotate a view. 

# Ease Type

# Color Changing Type

# Version
### 1.0.1  
First version for 11 animations.

# License

    Copyright 2016 Nightonke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

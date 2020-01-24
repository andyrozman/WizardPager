Wizard Pager
=================

![Wizard Pager Screenshot](https://lh3.googleusercontent.com/-_-Sv3J3bdcc/UdeUUDd1TjI/AAAAAAAAEEo/yproJ-EbCJg/w412-h716-no/wizardPager.png)

Wizard Pager is a library that provides an example implementation of a Wizard UI on Android, it's based of Roman Nurik's wizard pager (https://github.com/romannurik/android-wizardpager)

I've updated Roman's code to use the latest support library, it is now structured as a library project, and it's backwards compatible with Android 2.2

Download
============

You can get the library via Maven:

```xml
<dependency>
  <groupId>com.github.techfreak</groupId>
  <artifactId>wizardpager</artifactId>
  <version>1.0.0</version>
  <type>aar</type>
</dependency>
```

or Gradle:

```groovy
dependencies {
   compile 'com.github.techfreak:wizardpager:1.0.0'
}
```


Usage
============

1. Add dependency in your project

2. Add


There is a sample implementation, so you can see how to add this library to your project. The example uses ActionBarCompat.



Developed By
============

* Andy Rozman - <andy.rozman@gmail.com>


License
=======

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


History
=======
0.0.1 - Wizard pager was just sample application by Roman Nurik (https://github.com/romannurik/android-wizardpager)

1.0.0 - Wizard pager was rewritten a little by Tech Freak & Suarez Julian (https://github.com/str4d/WizardPager) and
        made as library.

1.1.0 - made fork of original and started extending library (everything added under package com.atech.android.library.wizardpager)
      - created new groupId
      - changed build to version 28 (minimal 23)
      - added android X support
      - created new main activity (to simplify use)
      - added Actions for when wizard is finished (either succesfully or by canceling)
      - added DisplayTextPage for displaying text
      - added possibility for custom End page
      - added WizardPagerSettings, which can be used to to modify behaviour
      - added the way wizard can be handled (WizardStepsWayType, standard Next/Previous or one-way Next/Cancel)
      - added WizardPagerContext to be used when using Wizard
      - refactored sample to use new activity
      - changes in default style

1.1.1 - disabled swiping

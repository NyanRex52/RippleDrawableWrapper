RippleDrawableWrapper
===============

A simple wrapper that will create a ripple drawable with the most dominant color in a bitmap, and apply as a forground on an ImageView.


Usage
-----
```
new RippleDrawableWrapper().getRecDomColor(bitmap);
new RippleDrawableWrapper().getCircularDomColor(bitmap);
new RippleDrawableWrapper(0.3f).getRecDomColor(bitmap);
new RippleDrawableWrapper(0.3f).getCircularDomColor(bitmap);
```

Limitations
-----------
* Bitmap can't be null


License
-------

    Copyright 2017 Mohammed Al-Safwan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

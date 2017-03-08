# franjam-custom-progress-bar

The purpose of this library is to have an easily configurable ProgressBar via xml which allows to change top progress drawable 
and background drawable.

For ussage, after import:

1) Add to the root of your main xml layout
```xml
  xmlns:app="http://schemas.android.com/apk/res-auto"
  ```
2) Declare your custom-progress-bar on your xml like this:

```xml

  <franjam.ui.FranJamProgressBar
        android:id="@+id/custom_progress_bar"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:visibility="visible"
        app:maxLevel="200"
        app:backgroundDrawable="@drawable/custom_background_drawable"
        app:progressDrawable="@drawable/custom_progress_vector_drawable" />
```

2) XML attributes:

* maxLevel: Define the max progress possible value. If not specified max will be 100 (Only positive values)
* backgroundDrawable: Specify drawable (or svg) for a background image progress
* progressDrawable: Specify drawable (or svg) for a main progress (ClipDrawable)

NOTE: If drawables are not specified in xml it will use default_progress.png and default_background.png

3) Default images demo:

![Default sample 1](/demo_initial.png? "Demo sample 1")

![Default sample 2](/demo_progress.png? "Demo sample 2")

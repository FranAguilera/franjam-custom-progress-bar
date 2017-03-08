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

  <franjam.ui.CustomProgressBar
        android:id="@+id/custom_progress_bar"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:visibility="visible"
        app:maxLevel="200"
        app:backgroundDrawable="@drawable/custom_background_drawable"
        app:progressDrawable="@drawable/custom_progress_vector_drawable" />
```

2) Attributes:

* maxLevel--> Will define the max progress possible value. (Only positive values)
* backgroundDrawable --> Will allow to set any drawable as a background image for the progress bar
* progressDrawable --> Will allow to customize the looks of your progress bar by adding a simple vector drawable or png image

NOTE: If drawables are not specified in xml it will use default_progress.png and default_background.png

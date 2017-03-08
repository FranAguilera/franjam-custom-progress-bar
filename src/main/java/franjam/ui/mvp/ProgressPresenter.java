package franjam.ui.mvp;

import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.VisibleForTesting;
import android.view.Gravity;

import franjam.ui.R;

/**
 * Created by fran_aguilera on 3/8/17.
 */
public class ProgressPresenter {
    private static final int DEFAULT_MAX_LEVEL = 100;

    private ProgressView view;
    private int maxLevel;
    private LayerDrawable mainLayer;
    private Drawable progressDrawable;
    private Drawable backgroundDrawable;

    public ProgressPresenter(ProgressView view) {
        this.view = view;
    }

    public void onCreate(TypedArray typedArray, LayerDrawable mainLayer) {
        this.mainLayer = mainLayer;
        this.maxLevel = getMaxLevelFromTypedArray(typedArray);
        this.progressDrawable = getDrawableFromTypedArray(typedArray, R.styleable.CustomBar_progressDrawable);
        this.backgroundDrawable = getDrawableFromTypedArray(typedArray, R.styleable.CustomBar_backgroundDrawable);

        if (maxLevel > 0) {
            view.setMaxLevel(maxLevel);
        }

        LayerDrawable layerDrawable = getLayoutDrawable();
        view.setMainLayoutXmlDrawable(layerDrawable);
    }

    @VisibleForTesting
    int getMaxLevelFromTypedArray(TypedArray typedArray) {
        return typedArray.getInt(R.styleable.CustomBar_maxLevel, DEFAULT_MAX_LEVEL);
    }

    @VisibleForTesting
    Drawable getDrawableFromTypedArray(TypedArray typedArray, int styleableId) {
        return typedArray.getDrawable(styleableId);
    }

    @VisibleForTesting
    LayerDrawable getLayoutDrawable() {
        Drawable background = (backgroundDrawable != null) ? backgroundDrawable : getMainBackgroundDrawable();
        ClipDrawable progressClip = (ClipDrawable) mainLayer.getDrawable(1);

        if (progressDrawable != null) {
            progressClip = getClipDrawable(progressDrawable);
        }

        // Initialize a new LayerDrawable to hold progress bar all states
        return new LayerDrawable(new Drawable[]{background, progressClip});
    }

    Drawable getMainBackgroundDrawable() {
        return mainLayer.getDrawable(0);
    }

    ClipDrawable getClipDrawable(Drawable progressDrawable) {
        return new ClipDrawable(progressDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
    }
}

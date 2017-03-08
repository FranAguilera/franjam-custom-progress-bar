package franjam.ui.mvp;

import android.graphics.drawable.LayerDrawable;

public interface ProgressView {
    void setMainLayoutXmlDrawable(LayerDrawable layout);
    void setMaxLevel(int level);
}

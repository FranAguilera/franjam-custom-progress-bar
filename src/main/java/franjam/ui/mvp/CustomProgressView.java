package franjam.ui.mvp;

import android.graphics.drawable.LayerDrawable;

public interface CustomProgressView {
    void setMainLayoutXmlDrawable(LayerDrawable layout);
    void setMaxLevel(int level);
}

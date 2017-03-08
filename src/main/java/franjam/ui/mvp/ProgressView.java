package franjam.ui.mvp;

import android.graphics.drawable.LayerDrawable;

/**
 * Created by fran_aguilera on 3/8/17.
 */
public interface ProgressView {
    void setMainLayoutXmlDrawable(LayerDrawable layout);
    void setMaxLevel(int level);
}

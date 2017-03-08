package franjam.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import franjam.ui.mvp.ProgressPresenter;
import franjam.ui.mvp.ProgressView;

public class FranJamProgressBar extends ProgressBar implements ProgressView {
    private ProgressPresenter presenter;

    public FranJamProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomBar,
                0, 0);

        LayerDrawable mainLayer = (LayerDrawable) ContextCompat.getDrawable(context,
                R.drawable.custom_progres_bar_with_images);

        presenter = new ProgressPresenter(this);
        presenter.onCreate(typedArray, mainLayer);
    }

    @Override
    public void setMainLayoutXmlDrawable(LayerDrawable layer) {
        setProgressDrawable(layer);
    }

    @Override
    public void setMaxLevel(int level) {
        this.setMax(level);
    }
}
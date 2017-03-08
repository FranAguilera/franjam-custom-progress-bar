package franjam.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import franjam.ui.mvp.CustomProgressPresenter;
import franjam.ui.mvp.CustomProgressView;

public class CustomProgressBar extends ProgressBar implements CustomProgressView {
    private CustomProgressPresenter presenter;

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomBar,
                0, 0);

        LayerDrawable mainLayer = (LayerDrawable) ContextCompat.getDrawable(context,
                R.drawable.custom_progres_bar_with_images);

        presenter = new CustomProgressPresenter(this);
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
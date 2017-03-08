package franjam.ui.mvp;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import org.junit.Before;
import org.junit.Test;

import franjam.ui.R;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;

/**
 * Created by fran_aguilera on 3/8/17.
 */
public class CustomProgressPresenterTest {
    private CustomProgressView view;
    private CustomProgressPresenter spyPresenter;

    @Before
    public void setUp() throws Exception {
        view = mock(CustomProgressView.class);
        CustomProgressPresenter outPresenter = new CustomProgressPresenter(view);
        spyPresenter = spy(outPresenter);
    }

    @Test
    public void setMaxLevel() throws Exception {
        final int progressLevel = 1500;
        TypedArray array = mock(TypedArray.class);
        LayerDrawable layerDrawable = mock(LayerDrawable.class);

        doReturn(progressLevel).when(spyPresenter).getMaxLevelFromTypedArray(array);

        spyPresenter.onCreate(array, layerDrawable);
        verify(view, times(1)).setMaxLevel(progressLevel);
    }

    @Test
    public void setWrongMaxLevel() throws Exception {
        final int progressLevel = -2000;
        TypedArray array = mock(TypedArray.class);
        LayerDrawable layerDrawable = mock(LayerDrawable.class);

        doReturn(progressLevel).when(spyPresenter).getMaxLevelFromTypedArray(array);

        spyPresenter.onCreate(array, layerDrawable);
        verify(view, never()).setMaxLevel(progressLevel);
    }

    @Test
    public void setLayoutDrawable() throws Exception {
        TypedArray array = mock(TypedArray.class);

        LayerDrawable layerDrawable = mock(LayerDrawable.class);
        doReturn(layerDrawable).when(spyPresenter).getLayoutDrawable();

        spyPresenter.onCreate(array, layerDrawable);

        verify(view, times(1)).setMainLayoutXmlDrawable(layerDrawable);
    }

    @Test
    public void setOnlyBackgroundDrawable() throws Exception {
        TypedArray array = mock(TypedArray.class);

        LayerDrawable layerDrawable = mock(LayerDrawable.class);
        Drawable mockDrawable = mock(Drawable.class);
        doReturn(mockDrawable).when(spyPresenter).getDrawableFromTypedArray(array, R.styleable.CustomBar_backgroundDrawable);
        spyPresenter.onCreate(array, layerDrawable);

        verify(spyPresenter, never()).getMainBackgroundDrawable();
    }

    @Test
    public void setTopProgressOnly() throws Exception {
        TypedArray array = mock(TypedArray.class);

        LayerDrawable layerDrawable = mock(LayerDrawable.class);
        Drawable mockDrawable = mock(Drawable.class);
        doReturn(mockDrawable).when(spyPresenter).getDrawableFromTypedArray(array, R.styleable.CustomBar_progressDrawable);
        spyPresenter.onCreate(array, layerDrawable);

        verify(spyPresenter, times(1)).getClipDrawable(mockDrawable);
    }
}
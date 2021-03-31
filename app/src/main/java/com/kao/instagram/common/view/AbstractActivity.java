package com.kao.instagram.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.kao.instagram.R;
import com.kao.instagram.common.utils.Colors;
import com.kao.instagram.common.utils.Drawables;

import butterknife.ButterKnife;

public abstract class AbstractActivity extends AppCompatActivity implements View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

//        precisa esse para todos anotações funcionam
        ButterKnife.bind(this);

        onInject();
    }

    public Drawable findDrawable(@DrawableRes int drawableId) {
        return Drawables.getDrawable(this, drawableId);
    }

    public int findColor(@ColorRes int colorId) {
        return Colors.getColor(this, colorId);
    }

    @Override
    public Context getContext() {
        return getBaseContext();
    }

    @Override
    public void showProgressBar() {
    }

    @Override
    public void hideProgressBar() {
    }

    @Override
    public void setStatusBarDark() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(findColor(R.color.colorAccent));
        }
    }

//  @LayoutRes isso para garantir parametros foi de recurso
    protected abstract @LayoutRes
    int getLayout();

    protected abstract void onInject();

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

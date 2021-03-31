package com.kao.instagram.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kao.instagram.common.utils.Colors;
import com.kao.instagram.common.utils.Drawables;

import butterknife.ButterKnife;

public abstract class AbstractFragment<P> extends Fragment implements View {

    protected P presenter;

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(getLayout(), container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void showProgressBar() {
    }

    @Override
    public void hideProgressBar() {
    }

    @Override
    public void setStatusBarDark() {

    }

    public Drawable findDrawable(@DrawableRes int drawableId) {
        return Drawables.getDrawable(getContext(), drawableId);
    }

    public int findColor(@ColorRes int colorId) {
        return Colors.getColor(getContext(), colorId);
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    protected abstract @LayoutRes
    int getLayout();
}

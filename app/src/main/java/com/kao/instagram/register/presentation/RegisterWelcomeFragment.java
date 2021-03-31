package com.kao.instagram.register.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kao.instagram.R;
import com.kao.instagram.common.component.LoadingButton;
import com.kao.instagram.common.view.AbstractFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterWelcomeFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.WelcomeView{

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;
    @BindView(R.id.register_text_view_welcome)
    TextView textViewWelcome;

    public static RegisterWelcomeFragment newInstance(RegisterPresenter presenter) {
        RegisterWelcomeFragment fragment = new RegisterWelcomeFragment();
        fragment.setPresenter(presenter);
        return fragment;
    }

    public RegisterWelcomeFragment() {}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonNext.setEnabled(true);
        textViewWelcome.setText(getString(R.string.welcome_to_instagram, presenter.getName()));
    }

    @OnClick(R.id.register_button_next)
    public void onButtonNextClick() {
        presenter.showPhotoView();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_welcome;
    }
}

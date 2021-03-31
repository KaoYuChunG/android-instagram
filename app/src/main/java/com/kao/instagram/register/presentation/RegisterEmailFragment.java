package com.kao.instagram.register.presentation;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.kao.instagram.R;
import com.kao.instagram.common.component.LoadingButton;
import com.kao.instagram.common.view.AbstractFragment;

import butterknife.BindView;

public class RegisterEmailFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.EmailView{

    @BindView(R.id.register_edit_text_email_input)
    TextInputLayout inputLayoutEmail;

    @BindView(R.id.register_edit_text_email)
    EditText editTextEmail;

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;

    public RegisterEmailFragment() {}

    public static RegisterEmailFragment newInstance(RegisterPresenter presenter) {
        RegisterEmailFragment fragment = new RegisterEmailFragment();

        fragment.setPresenter(presenter);
        presenter.setEmailView(fragment);

        return fragment;
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    public void onFailureForm(String emailError) {

    }
}

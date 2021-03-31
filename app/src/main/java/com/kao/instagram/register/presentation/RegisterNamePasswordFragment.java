package com.kao.instagram.register.presentation;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.Toast;

import com.kao.instagram.R;
import com.kao.instagram.common.component.LoadingButton;
import com.kao.instagram.common.view.AbstractFragment;

import butterknife.BindView;

public class RegisterNamePasswordFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.NamePasswordView {

    @BindView(R.id.register_edit_text_name_input)
    TextInputLayout inputLayoutName;

    @BindView(R.id.register_edit_text_name)
    EditText editTextName;

    @BindView(R.id.register_edit_text_name_password_input)
    TextInputLayout inputLayoutNamePassword;

    @BindView(R.id.register_edit_text_name_password)
    EditText editTextPassword;

    @BindView(R.id.register_edit_text_name_password_confirm_input)
    TextInputLayout inputLayoutConfirm;

    @BindView(R.id.register_edit_text_name_password_confirm)
    EditText editTextConfirm;

    @BindView(R.id.register_name_button_next)
    LoadingButton buttonNext;

    public static RegisterNamePasswordFragment newInstance(RegisterPresenter presenter) {
        RegisterNamePasswordFragment fragment = new RegisterNamePasswordFragment();
        fragment.setPresenter(presenter);
        presenter.setNamePasswordView(fragment);
        return fragment;
    }

    public RegisterNamePasswordFragment() {}

    @Override
    public void showProgressBar() {
        buttonNext.showProgress(true);
    }

    @Override
    public void hideProgressBar() {
        buttonNext.showProgress(false);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_name_password;
    }

    @Override
    public void onFailureForm(String nameError, String passwordError) {
        if (nameError != null) {
            inputLayoutName.setError(nameError);
            editTextName.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
        if (passwordError != null) {
            inputLayoutNamePassword.setError(passwordError);
            editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
    }

    @Override
    public void onFailureCreateUser(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}

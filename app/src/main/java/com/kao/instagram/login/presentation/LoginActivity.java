package com.kao.instagram.login.presentation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.kao.instagram.R;
import com.kao.instagram.common.component.LoadingButton;
import com.kao.instagram.common.view.AbstractActivity;
import com.kao.instagram.login.data.LoginDataSource;
import com.kao.instagram.login.data.LoginFireData;
import com.kao.instagram.login.data.LoginLocalData;
import com.kao.instagram.register.presentation.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AbstractActivity implements LoginView {
//  @BindView nao pode usar como privata
    @BindView(R.id.login_edit_text_email) EditText editTextEmail;
    @BindView(R.id.login_edit_text_password) EditText editTextPassword;
    @BindView(R.id.login_edit_text_email_input) TextInputLayout inputLayoutEmail;
    @BindView(R.id.login_edit_text_password_input) TextInputLayout inputLayoutPassword;
    @BindView(R.id.login_button_enter) LoadingButton buttonEnter;

    LoginPresenter presenter;

    public static void launch(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarDark();

        String user = FirebaseAuth.getInstance().getUid();
        if (user != null)
            onUserLogged();
    }

//  Inject é responsavel por buscar dados
//  no caso de degger faz inject neles
    @Override
    protected void onInject() {
        // usando LoginLocalData como dados falsos
        LoginDataSource dataSource = new LoginLocalData();
        presenter = new LoginPresenter(this, dataSource);
    }

    @Override
    public void showProgressBar() {
        buttonEnter.showProgress(true);
    }

    @Override
    public void hideProgressBar() {
        buttonEnter.showProgress(false);
    }

    @Override
    public void onFailureForm(String emailError, String passwordError) {
        if (emailError != null) {
            inputLayoutEmail.setError(emailError);
            editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
        if (passwordError != null) {
            inputLayoutPassword.setError(passwordError);
            editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
    }

    @Override
    public void onUserLogged() {
//        MainActivity.launch(this, MainActivity.LOGIN_ACTIVITY);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.login_button_enter)
    public void onButtonEnterClick() {
        presenter.login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }

    @OnClick(R.id.login_text_view_register)
    public void onTextViewRegisterClick() {
        RegisterActivity.launch(this);
    }

    //quais editores vão ser manipulados
    @OnTextChanged({R.id.login_edit_text_email, R.id.login_edit_text_password})
    public void onTextChanged(CharSequence s) {
        buttonEnter.setEnabled(
                !editTextEmail.getText().toString().isEmpty() &&
                        !editTextPassword.getText().toString().isEmpty());

        // verificar qual editor de texto
        if (s.hashCode() == editTextEmail.getText().hashCode()) {
            editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background));
            inputLayoutEmail.setError(null);
            inputLayoutEmail.setErrorEnabled(false);
        } else if (s.hashCode() == editTextPassword.getText().hashCode()) {
            editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background));
            inputLayoutPassword.setError(null);
            inputLayoutPassword.setErrorEnabled(false);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}
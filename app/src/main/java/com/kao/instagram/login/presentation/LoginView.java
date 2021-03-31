package com.kao.instagram.login.presentation;

import com.kao.instagram.common.view.View;

public interface LoginView extends View {

    void onFailureForm(String emailError, String passwordError);

    void onUserLogged();
}

package com.kao.instagram.login.data;

import com.kao.instagram.common.presenter.Presenter;
import com.kao.instagram.login.presentation.LoginPresenter;

public interface LoginDataSource {
    void login(String email, String password, Presenter presenter);
}

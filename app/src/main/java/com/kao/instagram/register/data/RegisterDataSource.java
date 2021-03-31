package com.kao.instagram.register.data;

import android.net.Uri;

import com.kao.instagram.common.presenter.Presenter;

public interface RegisterDataSource {

    void createUser(String name, String email, String password, Presenter presenter);

    void addPhoto(Uri uri, Presenter presenter);
}

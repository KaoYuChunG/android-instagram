package com.kao.instagram.login.data;

import com.kao.instagram.common.model.Database;
import com.kao.instagram.common.model.UserAuth;
import com.kao.instagram.common.presenter.Presenter;


// para uso no caso de dados fakes
public class LoginLocalData implements LoginDataSource {
    @Override
    public void login(String email, String password, Presenter presenter) {
        Database.getInstance().login(email, password)
                .addOnSuccessListener((Database.OnSuccessListener<UserAuth>) response -> presenter.onSuccess(response))
                .addOnFailureListener(e -> presenter.onError(e.getMessage()))
                .addOnCompleteListener(() -> presenter.onComplete());
    }
}

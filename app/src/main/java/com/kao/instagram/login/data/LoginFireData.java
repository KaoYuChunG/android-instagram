package com.kao.instagram.login.data;

import com.google.firebase.auth.FirebaseAuth;
import com.kao.instagram.common.presenter.Presenter;

public class LoginFireData implements LoginDataSource {
    @Override
    public void login(String email, String password, Presenter presenter) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> presenter.onSuccess(authResult.getUser()))
                .addOnFailureListener(e -> presenter.onError(e.getMessage()))
                .addOnCompleteListener(task -> presenter.onComplete());
    }
}

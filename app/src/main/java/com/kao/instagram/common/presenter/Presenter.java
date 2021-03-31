package com.kao.instagram.common.presenter;

public interface Presenter<T> {

    void onSuccess(T response);

    void onError(String message);

    void onComplete();
}

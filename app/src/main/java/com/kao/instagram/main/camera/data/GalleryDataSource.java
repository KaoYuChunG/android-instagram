package com.kao.instagram.main.camera.data;

import android.content.Context;

import com.kao.instagram.common.presenter.Presenter;

public interface GalleryDataSource {

  void findPictures(Context context, Presenter presenter);

}

package com.kao.instagram.main.camera.presentation;

import android.net.Uri;

public interface AddView {

  void onImageLoaded(Uri uri);

  void dispose();

}

package com.kao.instagram.main.camera.presentation;

import android.net.Uri;

import java.util.List;

import com.kao.instagram.common.view.View;

public interface GalleryView extends View {

  void onPicturesLoaded(List<Uri> uris);
}

package com.kao.instagram.main.camera.data;

import android.net.Uri;

import com.kao.instagram.common.model.Database;
import com.kao.instagram.common.presenter.Presenter;

public class AddLocalDataSource implements AddDataSource {

  @Override
  public void savePost(Uri uri, String caption, Presenter presenter) {
    Database db = Database.getInstance();
    db.createPost(db.getUser().getUUID(), uri, caption)
            .addOnSuccessListener((Database.OnSuccessListener<Void>) presenter::onSuccess)
            .addOnFailureListener(e -> presenter.onError(e.getMessage()))
            .addOnCompleteListener(presenter::onComplete);
  }

}

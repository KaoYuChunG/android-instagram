package com.kao.instagram.main.home.data;

import java.util.List;

import com.kao.instagram.common.model.Database;
import com.kao.instagram.common.model.Feed;
import com.kao.instagram.common.presenter.Presenter;

public class HomeLocalDataSource implements HomeDataSource {

  @Override
  public void findFeed(Presenter<List<Feed>> presenter) {
    Database db = Database.getInstance();
    db.findFeed(db.getUser().getUUID())
            .addOnSuccessListener(presenter::onSuccess)
            .addOnFailureListener(e -> presenter.onError(e.getMessage()))
            .addOnCompleteListener(presenter::onComplete);
  }

}

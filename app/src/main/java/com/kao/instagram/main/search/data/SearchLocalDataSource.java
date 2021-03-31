package com.kao.instagram.main.search.data;

import java.util.List;

import com.kao.instagram.common.model.Database;
import com.kao.instagram.common.model.User;
import com.kao.instagram.common.presenter.Presenter;

public class SearchLocalDataSource implements SearchDataSource {

  @Override
  public void findUser(String query, Presenter<List<User>> presenter) {
    Database db = Database.getInstance();
    db.findUsers(db.getUser().getUUID(), query)
            .addOnSuccessListener(presenter::onSuccess)
            .addOnFailureListener(e -> presenter.onError(e.getMessage()))
            .addOnCompleteListener(presenter::onComplete);
  }

}

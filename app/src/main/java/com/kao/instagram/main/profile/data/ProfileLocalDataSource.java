package com.kao.instagram.main.profile.data;

import java.util.List;

import com.kao.instagram.common.model.Database;
import com.kao.instagram.common.model.Post;
import com.kao.instagram.common.model.User;
import com.kao.instagram.common.model.UserProfile;
import com.kao.instagram.common.presenter.Presenter;

public class ProfileLocalDataSource implements ProfileDataSource {

  @Override
  public void findUser(String uuid, Presenter<UserProfile> presenter) {
    Database db = Database.getInstance();
    db.findUser(uuid)
            .addOnSuccessListener((Database.OnSuccessListener<User>) user1 -> {
              db.findPosts(uuid)
                      .addOnSuccessListener((Database.OnSuccessListener<List<Post>>) posts -> {
                        db.following(db.getUser().getUUID(), uuid)
                                .addOnSuccessListener((Database.OnSuccessListener<Boolean>) following -> {
                                  presenter.onSuccess(new UserProfile(user1, posts, following));
                                  presenter.onComplete();
                                });
                      });
            });
  }

  @Override
  public void follow(String user) {
    Database.getInstance().follow(Database.getInstance().getUser().getUUID(), user);
  }

  @Override
  public void unfollow(String user) {
    Database.getInstance().unfollow(Database.getInstance().getUser().getUUID(), user);
  }

}

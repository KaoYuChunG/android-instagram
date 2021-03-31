package com.kao.instagram.main.profile.data;

import com.kao.instagram.common.model.UserProfile;
import com.kao.instagram.common.presenter.Presenter;

public interface ProfileDataSource {

  void findUser(String user, Presenter<UserProfile> presenter);

  void follow(String user);

  void unfollow(String user);

}

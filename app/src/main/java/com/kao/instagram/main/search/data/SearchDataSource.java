package com.kao.instagram.main.search.data;

import java.util.List;

import com.kao.instagram.common.model.User;
import com.kao.instagram.common.presenter.Presenter;

public interface SearchDataSource {

  void findUser(String query, Presenter<List<User>> presenter);
}

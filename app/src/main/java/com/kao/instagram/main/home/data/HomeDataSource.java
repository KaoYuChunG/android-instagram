package com.kao.instagram.main.home.data;

import java.util.List;

import com.kao.instagram.common.model.Feed;
import com.kao.instagram.common.presenter.Presenter;

public interface HomeDataSource {

  void findFeed(Presenter<List<Feed>> presenter);

}

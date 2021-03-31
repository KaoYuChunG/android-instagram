package com.kao.instagram.main.home.presentation;

import java.util.List;

import com.kao.instagram.common.model.Feed;
import com.kao.instagram.common.presenter.Presenter;
import com.kao.instagram.main.home.data.HomeDataSource;
import com.kao.instagram.main.presentation.MainView;

public class HomePresenter implements Presenter<List<Feed>> {

  private final HomeDataSource dataSource;
  private MainView.HomeView view;

  public HomePresenter(HomeDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void setView(MainView.HomeView view) {
    this.view = view;
  }

  public void findFeed() {
    view.showProgressBar();
    dataSource.findFeed(this);
  }

  @Override
  public void onSuccess(List<Feed> response) {
    view.showFeed(response);
  }

  @Override
  public void onError(String message) {
    // TODO: 25/04/19
  }

  @Override
  public void onComplete() {
    view.hideProgressBar();
  }
}

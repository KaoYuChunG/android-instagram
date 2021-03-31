package com.kao.instagram.main.search.presentation;

import java.util.List;

import com.kao.instagram.common.model.User;
import com.kao.instagram.common.presenter.Presenter;
import com.kao.instagram.main.presentation.MainView;
import com.kao.instagram.main.search.data.SearchDataSource;

public class SearchPresenter implements Presenter<List<User>> {

  private final SearchDataSource dataSource;
  private MainView.SearchView view;

  public SearchPresenter(SearchDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void setView(MainView.SearchView view) {
    this.view = view;
  }

  public void findUsers(String newText) {
    dataSource.findUser(newText, this);
  }

  @Override
  public void onSuccess(List<User> response) {
    view.showUsers(response);
  }

  @Override
  public void onError(String message) {
    // TODO: 29/04/19
  }

  @Override
  public void onComplete() {
  }

}

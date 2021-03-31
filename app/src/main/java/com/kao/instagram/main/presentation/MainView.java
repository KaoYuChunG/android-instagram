package com.kao.instagram.main.presentation;

import com.kao.instagram.common.model.Feed;
import com.kao.instagram.common.model.Post;
import com.kao.instagram.common.model.User;
import com.kao.instagram.common.view.View;

import java.util.List;

public interface MainView extends View {

    void scrollToolbarEnabled(boolean enabled);

    void showProfile(String user);

    void disposeProfileDetail();

    void logout();

    public interface ProfileView extends View {

        void showPhoto(String photo);

        void showData(String name, String following, String followers, String posts, boolean editProfile, boolean follow);

        void showPosts(List<Post> posts);

    }

    public interface HomeView extends View {

        void showFeed(List<Feed> response);

    }

    public interface SearchView {

        void showUsers(List<User> users);

    }
}


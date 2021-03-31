package com.kao.instagram.main.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.kao.instagram.common.view.AbstractActivity;
import com.kao.instagram.main.home.presentation.HomePresenter;
import com.kao.instagram.main.profile.presentation.ProfileFragment;
import com.kao.instagram.main.profile.presentation.ProfilePresenter;
import com.kao.instagram.main.search.presentation.SearchPresenter;

public class MainActivity extends AbstractActivity implements BottomNavigationView.OnNavigationItemSelectedListener, MainView {
    public static final String ACT_SOURCE = "act_source";
    public static final int LOGIN_ACTIVITY = 0;
    public static final int REGISTER_ACTIVITY = 1;

    private ProfilePresenter profilePresenter;
    private HomePresenter homePresenter;
    private SearchPresenter searchPresenter;

    Fragment homeFragment;
    Fragment profileFrament;
    //  Fragment cameraFragment;
    Fragment searchFragment;
    Fragment active;

    ProfileFragment profileDetailFragment;

    public static void launch(Context context, int source) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(ACT_SOURCE, source);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void onInject() {

    }

    @Override
    public void scrollToolbarEnabled(boolean enabled) {

    }

    @Override
    public void showProfile(String user) {

    }

    @Override
    public void disposeProfileDetail() {

    }

    @Override
    public void logout() {

    }
}

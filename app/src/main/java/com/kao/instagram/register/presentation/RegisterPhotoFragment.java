package com.kao.instagram.register.presentation;

import android.net.Uri;
import android.widget.ImageView;

import com.kao.instagram.R;
import com.kao.instagram.common.component.LoadingButton;
import com.kao.instagram.common.view.AbstractFragment;

import butterknife.BindView;

public class RegisterPhotoFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.PhotoView{

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;

    @BindView(R.id.register_camera_icon)
    ImageView imageViewCropped;

    public RegisterPhotoFragment() {
    }

    public static RegisterPhotoFragment newInstance(RegisterPresenter presenter) {
        RegisterPhotoFragment fragment = new RegisterPhotoFragment();
        presenter.setPhotoView(fragment);
        fragment.setPresenter(presenter);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_photo;
    }

    @Override
    public void onImageCropped(Uri uri) {

    }
}

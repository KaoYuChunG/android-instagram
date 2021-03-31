package com.kao.instagram.common.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.kao.instagram.R;

//cria component  customizado
//1.cria uma arqivo xml , defini visual
//2.cria class e definir funcionamento dele
public class LoadingButton extends FrameLayout {

    private AppCompatButton button;
    private ProgressBar progressBar;
    private String text;

    public LoadingButton(@NonNull Context context) {
        super(context);
        setup(context, null);
    }

    //usa attrs para manipular dinamicamente a visual do component
    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
    }

    public LoadingButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context, attrs);
    }

    private void setup(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_loading, this, true);

        //parte coracao, aqui defini component costumizado
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0);

        text = typedArray.getString(R.styleable.LoadingButton_text);

        typedArray.recycle();

        //pega primeiro filho que seria buttom de acordo com xml
        button = (AppCompatButton) getChildAt(0);
        button.setText(text);
        button.setEnabled(false);

        progressBar = (ProgressBar) getChildAt(1);
        //LOLLIPOP -> version 21
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            Drawable wrap = DrawableCompat.wrap(progressBar.getIndeterminateDrawable());
            DrawableCompat.setTint(wrap, ContextCompat.getColor(context, android.R.color.white));
            progressBar.setIndeterminateDrawable(DrawableCompat.unwrap(wrap));
        } else {
            //version antiga
            progressBar.getIndeterminateDrawable().setColorFilter(
                    ContextCompat.getColor(context, android.R.color.white), PorterDuff.Mode.SRC_IN);
        }

    }

    @Override
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        //defini com button e nao fragment
        button.setOnClickListener(l);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        //defini com button e nao fragment
        button.setEnabled(enabled);
    }

    public void showProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? VISIBLE : GONE);
        button.setText(enabled ? "" : text);
    }
}

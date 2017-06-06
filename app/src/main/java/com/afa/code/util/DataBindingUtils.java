package com.afa.code.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.afa.code.R;
import com.bumptech.glide.Glide;

/**
 * Created by kadin on 17/5/26.
 */

public class DataBindingUtils {

    @BindingAdapter({"stateImage"})
    public static void loadImage(ImageView view, int state) {
        int id = -1;
        switch (state) {
            case 0:
                id = R.mipmap.ic_state_accept;
                break;
            case 1:
                id = R.mipmap.ic_state_continue;
                break;
        }
        Glide.with(view.getContext()).load(id).error(R.mipmap.ic_state_accept).into(view);
    }


}

package com.teamcaffeine.hotswap.messaging;

/**
 * Created by william on 29/11/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.teamcaffeine.hotswap.messaging.model.Dialog;
import com.teamcaffeine.hotswap.messaging.utils.AppUtils;

public abstract class DialogsActivity extends AppCompatActivity
        implements DialogsListAdapter.OnDialogClickListener<Dialog>,
        DialogsListAdapter.OnDialogLongClickListener<Dialog> {
    protected ImageLoader imageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(DialogsActivity.this).load(url).into(imageView);
            }
        };
    }

    @Override
    public void onDialogLongClick(Dialog dialog) {
        AppUtils.showToast(this, dialog.getDialogName(),false);
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        MessagesActivity.open(this);
    }
}



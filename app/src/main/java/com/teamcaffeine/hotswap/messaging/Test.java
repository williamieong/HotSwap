package com.teamcaffeine.hotswap.messaging;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

import com.teamcaffeine.hotswap.R;
import com.teamcaffeine.hotswap.messaging.model.Dialog;
import com.teamcaffeine.hotswap.messaging.utils.AppUtils;

import java.util.ArrayList;

import static com.teamcaffeine.hotswap.messaging.fixtureData.DialogsFixtures.getDialogs;

public class Test extends AppCompatActivity implements DialogsListAdapter.OnDialogClickListener<Dialog>{

    DialogsList dialogsListView;
    DialogsListAdapter dialogsListAdapter;
    ArrayList<Dialog> dialogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dialogs = getDialogs();

        DialogsListAdapter dialogsListAdapter = new DialogsListAdapter<>(new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                //If you using another library - write here your way to load image
                Picasso.with(Test.this).load(url).into(imageView);
            }
        });

        dialogsListView = (DialogsList) findViewById(R.id.dialogsList);
        dialogsListView.setAdapter(dialogsListAdapter);
        dialogsListAdapter.addItems(dialogs);
        dialogsListAdapter.setOnDialogClickListener(this);

    }

    @Override
    public void onDialogClick(Dialog dialog) {
        AppUtils.showToast(this, "Click activated for " + dialog.getDialogName(),false);
        MessagesActivity.open(this);
    }



}

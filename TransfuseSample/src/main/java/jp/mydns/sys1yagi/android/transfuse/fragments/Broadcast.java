package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.receivers.Action;

@Fragment
@Layout(R.layout.fragment_broadcast)
public class Broadcast {

    @Inject
    Context mContext;

    @RegisterListener(R.id.button)
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Action.ACTION);
            mContext.sendBroadcast(intent);
        }
    };
}

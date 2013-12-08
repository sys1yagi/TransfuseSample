package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.SystemService;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_system_injection)
public class SystemServiceInjection {

    @Inject
    @SystemService(Context.LAYOUT_INFLATER_SERVICE)
    LayoutInflater mLayoutInflater;

    @Inject
    @View(R.id.container_layout)
    LinearLayout mContainerLayout;

    @OnActivityCreated
    public void created() {
        for (int i = 0; i < 10; i++) {
            android.view.View view = mLayoutInflater.inflate(R.layout.item_system_injection, null, false);
            ((TextView) view.findViewById(R.id.text)).setText("injection " + i);
            mContainerLayout.addView(view);
        }
    }
}

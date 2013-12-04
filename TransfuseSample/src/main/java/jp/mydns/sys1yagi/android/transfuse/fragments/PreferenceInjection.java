package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.Preference;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.di.constant.PreferenceConstant;

@Fragment
@Layout(R.layout.fragment_preference_injection)
public class PreferenceInjection {
    @Inject
    @Preference(value = PreferenceConstant.NAME, defaultValue = "undefined")
    String mName;

    @Inject
    @Preference(value = PreferenceConstant.IS_NOTIFICATION, defaultValue = "false")
    Boolean mIsNotification;

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @OnActivityCreated
    public void created() {
        mTextView.setText("name=" + mName + " notification=" + mIsNotification);
    }
}

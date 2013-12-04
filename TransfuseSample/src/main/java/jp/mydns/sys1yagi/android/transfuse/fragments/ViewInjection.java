package jp.mydns.sys1yagi.android.transfuse.fragments;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.View;

import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_view_injection)
public class ViewInjection {

    public static final String NAME = "ViewInjection";

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @Inject
    @View(tag = "hello_button")
    Button mButton;

    @OnActivityCreated
    private void init() {
        mTextView.setText("Hello Transfuse!!");
        mButton.setText("Tag Injection!!");
    }
}

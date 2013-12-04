package jp.mydns.sys1yagi.android.transfuse.fragments;


import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.Resource;
import org.androidtransfuse.annotations.View;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_resource_injection)
public class ResourceInjection {

    @Inject
    @Resource(R.string.injection_text)
    String mInjectionText;

    @Inject
    @Resource(R.drawable.ic_launcher)
    Drawable mIcLauncher;

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @Inject
    @View(R.id.image)
    ImageView mImageView;

    @OnActivityCreated
    private void created() {
        mTextView.setText(mInjectionText);
        mImageView.setImageDrawable(mIcLauncher);
    }

}

package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.tools.SingletonSample;

@Fragment
@Layout(R.layout.fragment_scope)
public class Scope {

    @Inject
    @View(R.id.textView)
    TextView mTextView;

    @Inject
    @View(R.id.textView2)
    TextView mTextView2;

    @Inject
    @View(R.id.textView3)
    TextView mTextView3;

    @Inject
    @View(R.id.textView4)
    TextView mTextView4;

    @Inject
    SingletonSample.SingletonCalculator mSingletonCalculator1;

    @Inject
    SingletonSample.SingletonCalculator mSingletonCalculator2;

    @Inject
    SingletonSample.NonSingletonCalculator mNonSingletonCalculator1;

    @Inject
    SingletonSample.NonSingletonCalculator mNonSingletonCalculator2;

    @OnActivityCreated
    public void created() {
        mTextView.setText("Singleton Hash code="+mSingletonCalculator1.hashCode());
        mTextView2.setText("Singleton Hash code="+mSingletonCalculator2.hashCode());
        mTextView3.setText("Non Singleton Hash code="+mNonSingletonCalculator1.hashCode());
        mTextView4.setText("Non Singleton Hash code="+mNonSingletonCalculator2.hashCode());
    }

}

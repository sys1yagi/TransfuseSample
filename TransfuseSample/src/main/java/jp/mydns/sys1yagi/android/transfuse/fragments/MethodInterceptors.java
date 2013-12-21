package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.os.NetworkOnMainThreadException;
import android.widget.TextView;

import org.androidtransfuse.annotations.Asynchronous;
import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.annotations.UIThread;
import org.androidtransfuse.annotations.View;
import org.apache.commons.io.IOUtils;

import java.net.URL;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_method_interceptors)
public class MethodInterceptors {

    private static final String LOAD_URL = "https://dl.dropboxusercontent.com/s/4y6mn5ahg9qsf7j/sample.txt";

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @RegisterListener(R.id.asynchronous)
    android.view.View.OnClickListener mAsynchronous = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {
            loadAsynchronous();
        }
    };

    @RegisterListener(R.id.ui_thread)
    android.view.View.OnClickListener mUiThead = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {
            loadUiThread();
        }
    };

    @Asynchronous
    public void loadAsynchronous() {
        try {
            URL url = new URL(LOAD_URL);
            String result = IOUtils.toString(url);
            setResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            setResult(e.getMessage());
        }
    }

    @UIThread
    public void loadUiThread() {
        try {
            URL url = new URL(LOAD_URL);
            String result = IOUtils.toString(url);
            setResult(result);
        } catch (NetworkOnMainThreadException e) {
            e.printStackTrace();
            setResult("NetworkOnMainThreadException");
        } catch (Exception e) {
            e.printStackTrace();
            setResult(e.getMessage());
        }
    }

    @UIThread
    public void setResult(String text) {
        mTextView.setText(text);
    }

}

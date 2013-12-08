package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.util.Log;
import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnConfigurationChanged;
import org.androidtransfuse.annotations.OnDestroy;
import org.androidtransfuse.annotations.OnDestroyView;
import org.androidtransfuse.annotations.OnLowMemory;
import org.androidtransfuse.annotations.OnPause;
import org.androidtransfuse.annotations.OnResume;
import org.androidtransfuse.annotations.OnStart;
import org.androidtransfuse.annotations.OnStop;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_fragment_lifecycle_method)
public class FragmentLifecycleMethod {

    private final static String TAG = FragmentLifecycleMethod.class.getSimpleName();

    @Inject
    @View(R.id.text)
    TextView mText;

    @OnActivityCreated
    void activityCreated() {
        addText("OnActivityCreated");
    }

    @OnStart
    void start() {
        addText("OnStart");
    }

    @OnResume
    void resume() {
        addText("OnResume");
    }

    @OnPause
    void pause() {
        addText("OnPause");
    }

    @OnStop
    void stop() {
        addText("OnStop");
    }

    @OnDestroyView
    void destroyView() {
        addText("OnDestroyView");
    }

    @OnDestroy
    void destroy() {
        addText("OnDestroy");
    }

    @OnLowMemory
    void lowMemory() {
        addText("lowMemory");
    }

    @OnConfigurationChanged
    void configurationChanged() {
        addText("OnConfigurationChanged");
    }

    private void addText(String text) {
        mText.setText(mText.getText() + "\n" + text);
        Log.d(TAG, text);
    }
}

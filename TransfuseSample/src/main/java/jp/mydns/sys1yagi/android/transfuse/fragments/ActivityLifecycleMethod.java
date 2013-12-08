package jp.mydns.sys1yagi.android.transfuse.fragments;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnBackPressed;
import org.androidtransfuse.annotations.OnConfigurationChanged;
import org.androidtransfuse.annotations.OnCreate;
import org.androidtransfuse.annotations.OnDestroy;
import org.androidtransfuse.annotations.OnPause;
import org.androidtransfuse.annotations.OnRestoreInstanceState;
import org.androidtransfuse.annotations.OnResume;
import org.androidtransfuse.annotations.OnSaveInstanceState;
import org.androidtransfuse.annotations.OnStart;
import org.androidtransfuse.annotations.OnStop;
import org.androidtransfuse.annotations.View;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_activity_lifecycle_methods)
public class ActivityLifecycleMethod {

    @Inject
    @View(R.id.log_text)
    TextView mLogText;

    @OnCreate
    public void create() {
        addLog("OnCreate");
    }

    @OnStart
    public void start() {
        addLog("OnStart");
    }

    @OnPause
    public void pause() {
        addLog("OnPause");
    }

    @OnResume
    public void resume() {
        addLog("OnResume");
    }

    @OnStop
    public void stop() {
        addLog("OnStop");
    }

    @OnDestroy
    public void destroy() {
        addLog("OnDestroy");
    }

    @OnBackPressed
    public void back() {
        addLog("OnBackPressed");
    }

    @OnSaveInstanceState
    public void save(Bundle save) {
        addLog("OnSaveInstanceState");
    }

    @OnRestoreInstanceState
    public void restore(Bundle restore) {
        addLog("OnRestoreInstanceState");
    }

    private void addLog(String log) {
        mLogText.setText(mLogText.getText() + "\n" + log);
    }
}

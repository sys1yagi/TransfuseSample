package jp.mydns.sys1yagi.android.transfuse;

import android.util.Log;

import org.androidtransfuse.annotations.Application;
import org.androidtransfuse.annotations.OnConfigurationChanged;
import org.androidtransfuse.annotations.OnCreate;
import org.androidtransfuse.annotations.OnLowMemory;
import org.androidtransfuse.annotations.OnTerminate;

@Application(name = "TransfuseApplication")
public class TransfuseApplicationBase {

    private final static String TAG = TransfuseApplicationBase.class.getSimpleName();

    @OnCreate
    public void create() {
        Log.d(TAG, "onCreate");
    }

    @OnTerminate
    public void terminate() {
        Log.d(TAG, "onTerminate");
    }

    @OnLowMemory
    public void lowMemory() {
        Log.d(TAG, "onLowMemory");
    }

    @OnConfigurationChanged
    public void onfigurationChanged() {
        Log.d(TAG, "OnConfigurationChanged");
    }
}

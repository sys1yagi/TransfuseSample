package jp.mydns.sys1yagi.android.transfuse.services;

import android.util.Log;

import org.androidtransfuse.annotations.Intent;
import org.androidtransfuse.annotations.IntentFilter;
import org.androidtransfuse.annotations.IntentType;
import org.androidtransfuse.annotations.OnCreate;
import org.androidtransfuse.annotations.OnDestroy;
import org.androidtransfuse.annotations.Service;
import org.androidtransfuse.listeners.ServiceOnStartCommand;

@Service
@IntentFilter(@Intent(type= IntentType.ACTION, name="transfuse"))
public class Calc implements ServiceOnStartCommand{

    private static final String TAG = Calc.class.getSimpleName();

    @Override
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        Log.d(TAG, "onStartCommand");
        return android.app.Service.START_NOT_STICKY;
    }

    @OnCreate
    public void create(){
        Log.d(TAG, "onCreate");
    }

    @OnDestroy
    public void destroy(){
        Log.d(TAG, "onDestroy");
    }

}

package jp.mydns.sys1yagi.android.transfuse.receivers;

import android.content.Context;
import android.util.Log;

import org.androidtransfuse.annotations.BroadcastReceiver;
import org.androidtransfuse.annotations.Intent;
import org.androidtransfuse.annotations.IntentType;
import org.androidtransfuse.annotations.OnReceive;

@BroadcastReceiver
@Intent(type = IntentType.ACTION, name = Action.ACTION)
public class Action {
    private final static String TAG = Action.class.getSimpleName();

    public final static String ACTION = "jp.mydns.sys1yagi.android.transfuse.ACTION";

    @OnReceive
    public void boot(Context context, android.content.Intent intent) {
        Log.d(TAG, "receive action :" + intent.getAction());
    }
}

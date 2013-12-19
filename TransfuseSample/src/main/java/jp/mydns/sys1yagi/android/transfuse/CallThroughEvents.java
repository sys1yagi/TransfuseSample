package jp.mydns.sys1yagi.android.transfuse;

import android.util.Log;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.listeners.ActivityOnKeyDownListener;

import jp.mydns.sys1yagi.android.transfuse.R;

@Activity
@Layout(R.layout.fragment_call_through_events)

public class CallThroughEvents implements ActivityOnKeyDownListener {

    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        Log.d("Key Pressed", "code:" + keyCode);

        return true;
    }

//    ActivityMenuComponent
//    ActivityOnKeyDownListener
//    ActivityOnKeyLongPressListener
//    ActivityOnKeyMultipleListener
//    ActivityOnKeyUpListener
//    ActivityOnTouchEventListener
//    ActivityOnTrackballEventListener

}

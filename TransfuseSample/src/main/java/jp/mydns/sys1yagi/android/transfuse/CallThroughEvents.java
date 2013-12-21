package jp.mydns.sys1yagi.android.transfuse;

import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.annotations.View;
import org.androidtransfuse.listeners.ActivityOnKeyDownListener;
import org.androidtransfuse.listeners.ActivityOnTouchEventListener;

import javax.inject.Inject;

@Activity
@Layout(R.layout.fragment_call_through_events)
@RegisterListener
public class CallThroughEvents implements ActivityOnKeyDownListener, ActivityOnTouchEventListener {

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @Override
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        Log.d("Key Pressed", "code:" + keyCode);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        mTextView.setText("Touch " + motionEvent.getX() + "," + motionEvent.getY());
        return false;
    }

    // 以下のinterfaceを実装しておくと、生成されたActivityに対応したメソッドが生える
//    ActivityMenuComponent
//    ActivityOnKeyDownListener
//    ActivityOnKeyLongPressListener
//    ActivityOnKeyMultipleListener
//    ActivityOnKeyUpListener
//    ActivityOnTouchEventListener
//    ActivityOnTrackballEventListener

}

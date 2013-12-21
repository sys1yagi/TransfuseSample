package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.Observes;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.annotations.View;
import org.androidtransfuse.event.EventManager;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.events.MessageEvent;

@Fragment
@Layout(R.layout.fragment_event_bus)
public class EventBus {

    @Inject
    EventManager mEventManager;

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @RegisterListener(R.id.button)
    android.view.View.OnClickListener mListener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {
            mEventManager.trigger(new MessageEvent("send event!!"));
        }
    };

    @Observes
    public void onMessage(MessageEvent event) {
        mTextView.setText("receive event = " + event.getMessage());
    }

}

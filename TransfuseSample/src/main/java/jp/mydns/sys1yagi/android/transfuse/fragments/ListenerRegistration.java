package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.view.View;
import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;

@Fragment
@Layout(R.layout.fragment_listener_registration)
public class ListenerRegistration {

    @Inject
    @org.androidtransfuse.annotations.View(R.id.text)
    TextView mTextView;

    @RegisterListener(R.id.button)
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTextView.setText("Pushed!!!!!!!");
        }
    };

    @RegisterListener(value = R.id.long_click_text)
    View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            mTextView.setText("Long Pushed!!!!!!!");
            return false;
        }
    };

//    Viewクラスの持つリスナをサポートしている
//    API Level 11以降に追加されたものはサポートしていない

//    View.OnLongClickListener
//    View.OnClickListener
//    View.OnCreateContextMenuListener
//    View.OnFocusChangeListener
//    View.OnKeyListener
//    View.OnTouchListener
}

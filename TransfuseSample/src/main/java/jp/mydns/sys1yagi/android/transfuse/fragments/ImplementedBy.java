package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.widget.EditText;
import android.widget.TextView;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.tools.ICalculator;

@Fragment
@Layout(R.layout.fragment_implemented_by)
public class ImplementedBy {

    @Inject
    @View(R.id.editText)
    EditText mEditText;

    @Inject
    @View(R.id.editText2)
    EditText mEditText2;

    @Inject
    @View(R.id.text)
    TextView mTextView;

    @Inject
    ICalculator mCalculator;

    @RegisterListener(R.id.button)
    android.view.View.OnClickListener listener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(android.view.View v) {
            int result = mCalculator.add(Integer.parseInt(mEditText.getText().toString()),
                    Integer.parseInt(mEditText2.getText().toString()));

            mTextView.setText("Result=" + result);
        }
    };
}

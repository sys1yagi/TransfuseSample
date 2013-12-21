package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.util.Log;
import android.view.View;

import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.RegisterListener;
import org.androidtransfuse.intentFactory.IntentFactory;
import org.androidtransfuse.intentFactory.IntentFactoryStrategy;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.services.CalcServiceStrategy;

@Fragment
@Layout(R.layout.fragment_service_lifecycle_method)
public class ServiceLifecycleMethod {

    @Inject
    IntentFactory mIntentFactory;

    @RegisterListener(R.id.button)
    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("moge", "onClick");
            CalcServiceStrategy calcServiceStrategy = new CalcServiceStrategy();
            mIntentFactory.start(calcServiceStrategy);
        }
    };

}

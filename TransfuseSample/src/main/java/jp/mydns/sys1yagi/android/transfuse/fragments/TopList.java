package jp.mydns.sys1yagi.android.transfuse.fragments;


import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnListItemClick;
import org.androidtransfuse.intentFactory.IntentFactory;
import org.androidtransfuse.intentFactory.IntentFactoryStrategy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.ExtraInjectionActivityStrategy;
import jp.mydns.sys1yagi.android.transfuse.R;

@org.androidtransfuse.annotations.Fragment(type = ListFragment.class)
public class TopList {

    public static final String NAME = "TopList";

    @Inject
    IntentFactory mIntentFactory;

    @Inject
    @Named("top menu list")
    ArrayAdapter mAdapter;

    @Inject
    ListFragment mThis;

    @Inject
    @Named(ViewInjection.NAME)
    private Fragment mViewInjection;

    @Inject
    @Named(ActivityLifecycleMethods.NAME)
    private Fragment mActivityLifecycleMethods;

    @Inject
    @Named(ResourceInjection.NAME)
    private Fragment mResourceInjection;

    private Map<String, Object> mObjectMap = new LinkedHashMap<String, Object>();

    @OnListItemClick
    public void onItemClick(int position) {
        String key = (String) mAdapter.getItem(position);
        Object object = mObjectMap.get(key);
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            if (fragment != null) {
                FragmentTransaction transaction = mThis.getActivity()
                        .getSupportFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        } else if (object instanceof IntentFactoryStrategy) {
            IntentFactoryStrategy intentFactoryStrategy = (IntentFactoryStrategy) object;
            mIntentFactory.start(intentFactoryStrategy);
        }
    }

    @OnActivityCreated
    public void activityCreated() {
        mObjectMap.put("Activity Lifecycle Methods", mActivityLifecycleMethods);
        mObjectMap.put("View Injection", mViewInjection);
        mObjectMap.put("Extra Injection", new ExtraInjectionActivityStrategy(10, "Transfuse!", "hello"));
        mObjectMap.put("Resource Injection", mResourceInjection);
        mObjectMap.put("Preference Injection", mViewInjection);
        mObjectMap.put("SystemService Injection", mViewInjection);
        mObjectMap.put("Application", mViewInjection);
        mObjectMap.put("Fragment", mViewInjection);
        mObjectMap.put("Service", mViewInjection);
        mObjectMap.put("Listener Registration", mViewInjection);
        mObjectMap.put("Call-Through Events", mViewInjection);
        mObjectMap.put("Provider", mViewInjection);
        mObjectMap.put("Scope", mViewInjection);
        mObjectMap.put("ImplementedBy", mViewInjection);
        mObjectMap.put("Asynchronous", mViewInjection);
        mObjectMap.put("UIThread", mViewInjection);
        mObjectMap.put("Events", mViewInjection);
        mObjectMap.put("Parcel", mViewInjection);
        mObjectMap.put("Factory", mViewInjection);

        for (String title : mObjectMap.keySet()) {
            mAdapter.add(title);
        }
        mThis.setListAdapter(mAdapter);
    }
}
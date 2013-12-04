package jp.mydns.sys1yagi.android.transfuse.fragments;


import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnListItemClick;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.ExtraInjection;
import jp.mydns.sys1yagi.android.transfuse.R;

@org.androidtransfuse.annotations.Fragment(type = ListFragment.class)
public class TopList {

    @Inject
    @Named("top menu list")
    ArrayAdapter mAdapter;

    @Inject
    ListFragment mThis;

    @Inject
    @Named("view injection")
    private Fragment mViewInjection;

    @Inject
    @Named(ActivityLifecycleMethods.NAME)
    private Fragment mActivityLifecycleMethods;



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
        } else if (object instanceof Intent) {
            Intent intent = (Intent) object;
            mThis.startActivity(intent);
        }
    }

    @OnActivityCreated
    public void activityCreated() {

        mObjectMap.put("Activity Lifecycle Methods", mActivityLifecycleMethods);
        mObjectMap.put("View Injection", mViewInjection);
        //mObjectMap.put("Extra Injection", mViewInjection);
        mObjectMap.put("Resource Injection", mViewInjection);
        mObjectMap.put("Preference Injection", mViewInjection);
        mObjectMap.put("SystemService Injection", mViewInjection);
        mObjectMap.put("Application", mViewInjection);
        mObjectMap.put("Fragment", mViewInjection);
        mObjectMap.put("Service", mViewInjection);
        mObjectMap.put("Listener Registration", mViewInjection);
        mObjectMap.put("Call-Through Events", mViewInjection);
        //mObjectMap.put("Intent Factory", mViewInjection);
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
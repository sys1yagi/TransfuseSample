package jp.mydns.sys1yagi.android.transfuse.fragments;


import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnListItemClick;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.R;

@org.androidtransfuse.annotations.Fragment(type = ListFragment.class)
public class TopList {

    @Inject
    @Named("top menu list")
    ArrayAdapter mAdapter;

    @Inject
    ListFragment mListFragment;

    @Inject
    @Named("view injection")
    private Fragment mViewInjection;

    @Inject
    @Named(ActivityLifecycleMethods.NAME)
    private Fragment mActivityLifecycleMethods;

    private Map<String, Fragment> mFragmentMap = new LinkedHashMap<String, Fragment>();

    @OnListItemClick
    public void onItemClick(int position) {
        String key = (String) mAdapter.getItem(position);
        Fragment fragment = mFragmentMap.get(key);
        if (fragment != null) {
            FragmentTransaction transaction = mListFragment.getActivity()
                    .getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @OnActivityCreated
    public void activityCreated() {

        mFragmentMap.put("Activity Lifecycle Methods", mActivityLifecycleMethods);
        mFragmentMap.put("View Injection", mViewInjection);
        mFragmentMap.put("Extra Injection", mViewInjection);
        mFragmentMap.put("Resource Injection", mViewInjection);
        mFragmentMap.put("Preference Injection", mViewInjection);
        mFragmentMap.put("SystemService Injection", mViewInjection);
        mFragmentMap.put("Application", mViewInjection);
        mFragmentMap.put("Fragment", mViewInjection);
        mFragmentMap.put("Service", mViewInjection);
        mFragmentMap.put("Listener Registration", mViewInjection);
        mFragmentMap.put("Call-Through Events", mViewInjection);
        mFragmentMap.put("Intent Factory", mViewInjection);
        mFragmentMap.put("Provider", mViewInjection);
        mFragmentMap.put("Scope", mViewInjection);
        mFragmentMap.put("ImplementedBy", mViewInjection);
        mFragmentMap.put("Asynchronous", mViewInjection);
        mFragmentMap.put("UIThread", mViewInjection);
        mFragmentMap.put("Events", mViewInjection);
        mFragmentMap.put("Parcel", mViewInjection);
        mFragmentMap.put("Factory", mViewInjection);

        for (String title : mFragmentMap.keySet()) {
            mAdapter.add(title);
        }
        mListFragment.setListAdapter(mAdapter);
    }
}
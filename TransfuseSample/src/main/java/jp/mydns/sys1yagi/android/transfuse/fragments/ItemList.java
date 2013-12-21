package jp.mydns.sys1yagi.android.transfuse.fragments;

import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnListItemClick;
import org.androidtransfuse.intentFactory.IntentFactory;
import org.androidtransfuse.intentFactory.IntentFactoryStrategy;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.CallThroughEventsActivityStrategy;
import jp.mydns.sys1yagi.android.transfuse.ExtraInjectionActivityStrategy;
import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.di.constant.ModuleConstant;
import jp.mydns.sys1yagi.android.transfuse.di.constant.PreferenceConstant;

@org.androidtransfuse.annotations.Fragment(type = ListFragment.class)
public class ItemList {

    @Inject
    IntentFactory mIntentFactory;

    @Inject
    @Named(ModuleConstant.FRAGMENT_TOP_MENU_LIST)
    ArrayAdapter mAdapter;

    @Inject
    ListFragment mThis;

    @Inject
    @Named(ModuleConstant.FRAGMENT_VIEW_INJECTION)
    private Fragment mViewInjection;

    @Inject
    @Named(ModuleConstant.FRAGMENT_ACTIVITY_LIFECYCLE_METHOD)
    private Fragment mActivityLifecycleMethods;

    @Inject
    @Named(ModuleConstant.FRAGMENT_RESOURCE_INJECTION)
    private Fragment mResourceInjection;

    @Inject
    @Named(ModuleConstant.FRAGMENT_PREFERENCE_INJECTION)
    private Fragment mPreferenceInjection;

    @Inject
    @Named(ModuleConstant.FRAGMENT_SYSTEMSERVICE_INJECTION)
    private Fragment mSystemServiceInjection;

    @Inject
    @Named(ModuleConstant.FRAGMENT_FRAGMENT_LIFECYCLE_METHOD)
    private Fragment mFragmentLifecycleMethod;

    @Inject
    @Named(ModuleConstant.FRAGMENT_BROADCAST_RECEIVER)
    private Fragment mBroadcastReceiver;

    @Inject
    @Named(ModuleConstant.FRAGMENT_LISTENER_REGISTRATION)
    private Fragment mListenerRegistration;

    @Inject
    @Named(ModuleConstant.FRAGMENT_IMPLEMENTED_BY)
    private Fragment mImplementedBy;

    @Inject
    @Named(ModuleConstant.FRAGMENT_METHOD_INTERCEPTORS)
    private Fragment mMethodInterceptors;

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
        mObjectMap.put("Extra Injection",
                new ExtraInjectionActivityStrategy(10, "Transfuse!", "hello"));
        mObjectMap.put("Resource Injection", mResourceInjection);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mThis.getActivity());
        preferences.edit()
                .putString(PreferenceConstant.NAME, "transfuse!")
                .putBoolean(PreferenceConstant.IS_NOTIFICATION, true)
                .commit();
        mObjectMap.put("Preference Injection", mPreferenceInjection);

        mObjectMap.put("SystemService Injection", mSystemServiceInjection);
        mObjectMap.put("BroadcastReceiver Lifecycle Method", mBroadcastReceiver);
        mObjectMap.put("Fragment Lifecycle Method", mFragmentLifecycleMethod);
        mObjectMap.put("Service Lifecycle Method", mViewInjection); //TODO
        mObjectMap.put("Listener Registration", mListenerRegistration);
        mObjectMap.put("Call-Through Events", new CallThroughEventsActivityStrategy());
        //mObjectMap.put("Provider", mViewInjection);
        mObjectMap.put("Scope", mViewInjection);
        mObjectMap.put("ImplementedBy", mImplementedBy);
        mObjectMap.put("MethodInterceptors", mMethodInterceptors);
//        mObjectMap.put("Asynchronous", mViewInjection);
//        mObjectMap.put("UIThread", mViewInjection);
        mObjectMap.put("Events", mViewInjection);
        mObjectMap.put("Parcel", mViewInjection);
        mObjectMap.put("Factory", mViewInjection);

        for (String title : mObjectMap.keySet()) {
            mAdapter.add(title);
        }
        mThis.setListAdapter(mAdapter);
    }
}
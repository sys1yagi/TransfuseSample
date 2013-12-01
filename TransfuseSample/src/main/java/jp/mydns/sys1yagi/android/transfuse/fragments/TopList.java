package jp.mydns.sys1yagi.android.transfuse.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.OnListItemClick;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.R;

@org.androidtransfuse.annotations.Fragment(type = ListFragment.class)
public class TopList {

    @Inject
    Context mContext;

    @Inject
    @Named("top menu list")
    ArrayAdapter mAdapter;

    @Inject
    ListFragment mListFragment;

    @Inject
    @Named("view injection")
    private Fragment mViewInjection;


    @OnListItemClick
    public void onItemClick(int position) {
        //TODO Factory
        FragmentTransaction transaction = mListFragment.getActivity()
                .getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.content_frame, mViewInjection);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @OnActivityCreated
    public void activityCreated() {
        mAdapter.add("Activity Lifecycle Methods");
        mAdapter.add("View Injection");
        mAdapter.add("Extra Injection");
        mAdapter.add("Resource Injection");
        mAdapter.add("Preference Injection");
        mAdapter.add("SystemService Injection");
        mAdapter.add("Fragment");
        mAdapter.add("Service");
        mAdapter.add("Listener Registration");
        mAdapter.add("Call-Through Events");
        mAdapter.add("Application");
        mAdapter.add("Intent Factory");
        mAdapter.add("Provider");
        mAdapter.add("Scope");
        mAdapter.add("ImplementedBy");
        mAdapter.add("Asynchronous");
        mAdapter.add("UIThread");
        mAdapter.add("Events");
        mAdapter.add("Parcel");
        mAdapter.add("Factory");
        mListFragment.setListAdapter(mAdapter);
    }
}
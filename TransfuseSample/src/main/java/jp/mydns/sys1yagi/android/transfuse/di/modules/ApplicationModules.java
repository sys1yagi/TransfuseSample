package jp.mydns.sys1yagi.android.transfuse.di.modules;

import org.androidtransfuse.annotations.Provides;
import org.androidtransfuse.annotations.TransfuseModule;
import org.androidtransfuse.intentFactory.ActivityIntentFactoryStrategy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;

import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.ExtraInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.ActivityLifecycleMethods;
import jp.mydns.sys1yagi.android.transfuse.fragments.ResourceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.TopList;
import jp.mydns.sys1yagi.android.transfuse.fragments.ViewInjection;

@TransfuseModule
public class ApplicationModules {

    @Provides
    @Named("top menu list")
    public ArrayAdapter getAdapter(Context context) {
        return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
    }

    @Provides
    public FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
        return fragmentActivity.getSupportFragmentManager();
    }

    @Provides
    @Named(TopList.NAME)
    public Fragment getTopList() {
        return getFragment(TopList.class);
    }

    @Provides
    @Named(ViewInjection.NAME)
    public Fragment getViewInjection() {
        return getFragment(ViewInjection.class);
    }

    @Provides
    @Named(ActivityLifecycleMethods.NAME)
    public Fragment getActivityLifecycleMethods() {
        return getFragment(ActivityLifecycleMethods.class);
    }


    @Provides
    @Named(ResourceInjection.NAME)
    public Fragment getResourceInjection() {
        return getFragment(ResourceInjection.class);
    }


    private Fragment getFragment(Class fragmentBaseClass) {
        try {
            Class clazz = Class.forName(fragmentBaseClass.getName() + "Fragment");
            return (Fragment) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

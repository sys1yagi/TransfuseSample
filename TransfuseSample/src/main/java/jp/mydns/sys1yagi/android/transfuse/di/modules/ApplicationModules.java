package jp.mydns.sys1yagi.android.transfuse.di.modules;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;

import org.androidtransfuse.annotations.BindProviders;
import org.androidtransfuse.annotations.ContextScope;
import org.androidtransfuse.annotations.Provides;
import org.androidtransfuse.annotations.TransfuseModule;

import javax.inject.Named;

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
    @Named("top list")
    public Fragment getTopList() {
        return getFragment(TopList.class.getName() + "Fragment");
    }

    @Provides
    @Named("view injection")
    public Fragment getViewInjection() {
        return getFragment(ViewInjection.class.getName() + "Fragment");
    }

    private Fragment getFragment(String fragmentName){
        try {
            Class clazz = Class.forName(fragmentName);
            return (Fragment)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

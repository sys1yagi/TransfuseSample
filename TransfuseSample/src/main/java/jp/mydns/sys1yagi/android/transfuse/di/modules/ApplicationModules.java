package jp.mydns.sys1yagi.android.transfuse.di.modules;

import org.androidtransfuse.annotations.BindProvider;
import org.androidtransfuse.annotations.BindProviders;
import org.androidtransfuse.annotations.Provides;
import org.androidtransfuse.annotations.TransfuseModule;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;

import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.di.constant.ModuleConstant;
import jp.mydns.sys1yagi.android.transfuse.di.providers.RssLoaderProvider;
import jp.mydns.sys1yagi.android.transfuse.fragments.ActivityLifecycleMethods;
import jp.mydns.sys1yagi.android.transfuse.fragments.PreferenceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.ResourceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.TopList;
import jp.mydns.sys1yagi.android.transfuse.fragments.ViewInjection;
import jp.mydns.sys1yagi.android.transfuse.tools.IRssLoader;

@TransfuseModule
@BindProviders({
        @BindProvider(type = IRssLoader.class, provider = RssLoaderProvider.class)
})
public class ApplicationModules {

    @Provides
    @Named(ModuleConstant.FRAGMENT_TOP_MENU_LIST)
    public ArrayAdapter getAdapter(Context context) {
        return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
    }

    @Provides
    public FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
        return fragmentActivity.getSupportFragmentManager();
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_TOP_LIST)
    public Fragment getTopList() {
        return getFragment(TopList.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_VIEW_INJECTION)
    public Fragment getViewInjection() {
        return getFragment(ViewInjection.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_ACTIVITY_LIFECYCLE_METHODS)
    public Fragment getActivityLifecycleMethods() {
        return getFragment(ActivityLifecycleMethods.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_RESOURCE_INJECTION)
    public Fragment getResourceInjection() {
        return getFragment(ResourceInjection.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_PREFERENCE_INJECTION)
    public Fragment getPreferenceInjection() {
        return getFragment(PreferenceInjection.class);
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

package jp.mydns.sys1yagi.android.transfuse.di.modules;

import org.androidtransfuse.annotations.BindProvider;
import org.androidtransfuse.annotations.BindProviders;
import org.androidtransfuse.annotations.Provides;
import org.androidtransfuse.annotations.TransfuseModule;
import org.androidtransfuse.annotations.UsesPermission;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;

import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.di.constant.ModuleConstant;
import jp.mydns.sys1yagi.android.transfuse.di.providers.RssLoaderProvider;
import jp.mydns.sys1yagi.android.transfuse.fragments.ActivityLifecycleMethod;
import jp.mydns.sys1yagi.android.transfuse.fragments.Broadcast;
import jp.mydns.sys1yagi.android.transfuse.CallThroughEvents;
import jp.mydns.sys1yagi.android.transfuse.fragments.EventBus;
import jp.mydns.sys1yagi.android.transfuse.fragments.FragmentLifecycleMethod;
import jp.mydns.sys1yagi.android.transfuse.fragments.ImplementedBy;
import jp.mydns.sys1yagi.android.transfuse.fragments.ItemList;
import jp.mydns.sys1yagi.android.transfuse.fragments.ListenerRegistration;
import jp.mydns.sys1yagi.android.transfuse.fragments.MethodInterceptors;
import jp.mydns.sys1yagi.android.transfuse.fragments.PreferenceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.ResourceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.SystemServiceInjection;
import jp.mydns.sys1yagi.android.transfuse.fragments.ViewInjection;
import jp.mydns.sys1yagi.android.transfuse.tools.IRssLoader;

@TransfuseModule
@BindProviders({
        @BindProvider(type = IRssLoader.class, provider = RssLoaderProvider.class)
})
@UsesPermission(Manifest.permission.INTERNET)
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
    @Named(ModuleConstant.FRAGMENT_ITEM_LIST)
    public Fragment getTopList() {
        return getFragment(ItemList.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_VIEW_INJECTION)
    public Fragment getViewInjection() {
        return getFragment(ViewInjection.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_ACTIVITY_LIFECYCLE_METHOD)
    public Fragment getActivityLifecycleMethods() {
        return getFragment(ActivityLifecycleMethod.class);
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

    @Provides
    @Named(ModuleConstant.FRAGMENT_SYSTEMSERVICE_INJECTION)
    public Fragment getSystemServiceInjection() {
        return getFragment(SystemServiceInjection.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_FRAGMENT_LIFECYCLE_METHOD)
    public Fragment getFragmentLifecycleMethod() {
        return getFragment(FragmentLifecycleMethod.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_BROADCAST_RECEIVER)
    public Fragment getBroadcastReceiver() {
        return getFragment(Broadcast.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_LISTENER_REGISTRATION)
    public Fragment getListenerRegistration() {
        return getFragment(ListenerRegistration.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_IMPLEMENTED_BY)
    public Fragment getImplementedBy() {
        return getFragment(ImplementedBy.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_METHOD_INTERCEPTORS)
    public Fragment getMethodInterceptors() {
        return getFragment(MethodInterceptors.class);
    }

    @Provides
    @Named(ModuleConstant.FRAGMENT_EVENT_BUS)
    public Fragment getEventBus(){
        return getFragment(EventBus.class);
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

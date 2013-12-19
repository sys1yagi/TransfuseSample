package jp.mydns.sys1yagi.android.transfuse;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Intent;
import org.androidtransfuse.annotations.IntentFilter;
import org.androidtransfuse.annotations.IntentType;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnCreate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;
import javax.inject.Named;

import jp.mydns.sys1yagi.android.transfuse.di.constant.ModuleConstant;


@Activity(label = "@string/app_name", type = FragmentActivity.class)
@Layout(R.layout.activity_main)
@IntentFilter({
        @Intent(type = IntentType.ACTION, name = android.content.Intent.ACTION_MAIN),
        @Intent(type = IntentType.CATEGORY, name = android.content.Intent.CATEGORY_LAUNCHER)
})
public class Main {

    @Inject
    FragmentManager mFragmentManager;

    @Inject
    @Named(ModuleConstant.FRAGMENT_ITEM_LIST)
    Fragment mItemList;

    @OnCreate
    public void create(Bundle saved) {
        if (saved == null) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.add(R.id.content_frame, mItemList);
            transaction.commit();
        }
    }
}

package jp.mydns.sys1yagi.android.transfuse.di.providers;

import javax.inject.Provider;

import jp.mydns.sys1yagi.android.transfuse.tools.DefaultRssLoader;
import jp.mydns.sys1yagi.android.transfuse.tools.IRssLoader;

public class RssLoaderProvider implements Provider<IRssLoader>{
    @Override
    public IRssLoader get() {
        return new DefaultRssLoader();
    }
}

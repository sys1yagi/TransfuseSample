package jp.mydns.sys1yagi.android.transfuse.factories;

import org.androidtransfuse.annotations.Factory;

import jp.mydns.sys1yagi.android.transfuse.models.SampleData;

@Factory
public interface SampleDataFactory {
    SampleData getSampleData();
}

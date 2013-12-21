package jp.mydns.sys1yagi.android.transfuse.di.providers;


import javax.inject.Provider;

import jp.mydns.sys1yagi.android.transfuse.models.SampleData;

public class SampleDataProvider implements Provider<SampleData>{
    @Override
    public SampleData get() {
        SampleData sampleData = new SampleData();
        sampleData.setId(-1);
        sampleData.setName("provided data");
        sampleData.setDescription("provided data");
        return sampleData;
    }
}

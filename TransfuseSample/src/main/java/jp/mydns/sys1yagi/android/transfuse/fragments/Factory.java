package jp.mydns.sys1yagi.android.transfuse.fragments;

import android.widget.TextView;

import org.androidtransfuse.Factories;
import org.androidtransfuse.annotations.Fragment;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnActivityCreated;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.R;
import jp.mydns.sys1yagi.android.transfuse.factories.SampleDataFactory;
import jp.mydns.sys1yagi.android.transfuse.models.SampleData;

@Fragment
@Layout(R.layout.fragment_factory)
public class Factory {

    @Inject
    @View(R.id.id_text)
    TextView mId;

    @Inject
    @View(R.id.name_text)
    TextView mName;

    @Inject
    @View(R.id.description_text)
    TextView mDescription;

    @OnActivityCreated
    public void created() {
        SampleData sampleData = Factories.get(SampleDataFactory.class).getSampleData();
        mId.setText("id=" + sampleData.getId());
        mName.setText("name=" + sampleData.getName());
        mDescription.setText("description=" + sampleData.getDescription());
    }
}

package jp.mydns.sys1yagi.android.transfuse.models;

import org.parceler.Parcel;

@Parcel
public class SampleData {

    private int mId;

    private String mName;

    private String mDescription;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}

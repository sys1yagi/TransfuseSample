package jp.mydns.sys1yagi.android.transfuse;

import android.widget.TextView;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Extra;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnCreate;
import org.androidtransfuse.annotations.View;

import javax.inject.Inject;

import jp.mydns.sys1yagi.android.transfuse.models.SampleData;

@Activity
@Layout(R.layout.activity_sample_data_receive)
public class SampleDataReceive {

    @Inject
    @View(R.id.id_text)
    TextView mId;

    @Inject
    @View(R.id.name_text)
    TextView mName;

    @Inject
    @View(R.id.description_text)
    TextView mDescription;

    @Inject
    @Extra("sample_data")
    SampleData mSampleData;

    @OnCreate
    protected void create() {
        mId.setText("id=" + mSampleData.getId());
        mName.setText("name=" + mSampleData.getName());
        mDescription.setText("description=" + mSampleData.getDescription());
    }
}

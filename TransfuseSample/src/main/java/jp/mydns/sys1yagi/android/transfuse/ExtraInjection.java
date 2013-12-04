package jp.mydns.sys1yagi.android.transfuse;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Extra;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnCreate;
import org.androidtransfuse.annotations.Preference;
import org.androidtransfuse.annotations.View;

import android.widget.TextView;

import javax.inject.Inject;

@Activity
@Layout(R.layout.activity_extra_injection)
public class ExtraInjection {

    public static final String NAME = "ExtraInjection";

    @Inject
    @Extra("title")
    String mTitle;

    @Inject
    @Extra(value = "message")
    String mMessage;

    @Inject
    @Extra(value = "count", optional = false)
    Integer mCount;

    @Inject @View(R.id.title)
    TextView mTitleText;

    @Inject @View(R.id.message)
    TextView mMessageText;

    @Inject @View(R.id.count)
    TextView mCountText;

    @OnCreate
    private void init() {
        mTitleText.setText("title=" + mTitle);
        mMessageText.setText("message=" + mMessage);
        mCountText.setText("count=" + mCount);
    }
}

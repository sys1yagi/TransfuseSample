package jp.mydns.sys1yagi.android.transfuse;

import org.androidtransfuse.annotations.Activity;
import org.androidtransfuse.annotations.Extra;
import org.androidtransfuse.annotations.Layout;
import org.androidtransfuse.annotations.OnCreate;

import javax.inject.Inject;

@Activity
@Layout(R.layout.activity_extra_injection)
public class ExtraInjection {

    public static final String NAME = "ExtraInjection";

    @Inject @Extra("name")
    String name;
    @Inject @Extra(value="age", optional=true)
    Integer age;

    @OnCreate
    private void init(){

    }
}

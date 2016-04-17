package com.womeninmind.facebookAppInvite;

import android.app.Activity;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.womeninmind.facebookAppInvite.FacebookAppInviteModule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FacebookAppInvitePackage implements ReactPackage {
    private Activity mActivity;

    public FacebookAppInvitePackage(Activity activity) {
        super();
        mActivity = activity;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new FacebookAppInviteModule(reactContext, mActivity));
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}

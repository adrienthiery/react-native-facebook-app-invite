package com.womeninmind.facebookAppInvite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.model.AppInviteContent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FacebookAppInviteModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private CallbackManager callbackManager;
    private Activity parentActivity;

    public FacebookAppInviteModule(ReactApplicationContext reactContext, Activity mActivity) {
        super(reactContext);
        this.parentActivity = mActivity;

        reactContext.addActivityEventListener(this);

        FacebookSdk.sdkInitialize(reactContext.getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public String getName() {
        return "FacebookAppInvite";
    }

    @ReactMethod
    public void openAppInvite(String appLinkUrl, String previewImageUrl, final Callback callback) {
        if (AppInviteDialog.canShow()) {
            AppInviteContent content = new AppInviteContent.Builder()
                        .setApplinkUrl(appLinkUrl)
                        .setPreviewImageUrl(previewImageUrl)
                        .build();
            AppInviteDialog.show(this.parentActivity, content);
        }
    }

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

import React, {
    NativeModules
} from 'react-native';

/**
 * For more information about what the appLink is :
 * https://developers.facebook.com/docs/app-invites/ios#app_links
 */
export const openAppInvite = (
    appLink,
    appLinkImage = '',
    callback = () => {}
) => {
    console.log(NativeModules);
    return NativeModules.FacebookAppInvite.openAppInvite(
        appLink,
        appLinkImage,
        callback
    );
};

export default class FacebookAppInviteClass {
    static openAppInvite = openAppInvite;
};

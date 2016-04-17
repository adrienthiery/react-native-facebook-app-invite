import { FacebookAppInvite } from 'NativeModules';

/**
 * For more information about what the appLink is :
 * https://developers.facebook.com/docs/app-invites/ios#app_links
 */
export const openAppInvite = (
    appLink,
    appLinkImage = '',
    callback = () => {}
) => {
    return FacebookAppInvite.openAppInvite(
        appLink,
        appLinkImage,
        callback
    );
};

export default class FacebookAppInvite {
    static openAppInvite = openAppInvite;
};

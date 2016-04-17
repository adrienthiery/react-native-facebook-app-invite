//
//  FacebookAppInvite.m
//  WomenInMind
//
//  Created by OSEDEA on 2016-04-07.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "FacebookAppInvite.h"

@implementation FacebookAppInvite {
  RCTResponseSenderBlock callback;
}

RCT_EXPORT_METHOD(openAppInvite:(NSString *)appLink imageUrl:(NSString *)imageUrl callbackToDo:(RCTResponseSenderBlock)callbackToDo)
{
  RCTLog(@"Opening app invite with %@ and %@", appLink, imageUrl);
  FBSDKAppInviteContent *content =[[FBSDKAppInviteContent alloc] init];
  content.appLinkURL = [NSURL URLWithString:appLink];
  //optionally set previewImageURL
  content.appInvitePreviewImageURL = [NSURL URLWithString:imageUrl];

  // present the dialog. Assumes self implements protocol `FBSDKAppInviteDialogDelegate`
  [FBSDKAppInviteDialog showWithContent:content
                               delegate:self];
  callback = callbackToDo;
  return;

}

- (void)appInviteDialog:(FBSDKAppInviteDialog *)appInviteDialog didCompleteWithResults:(NSDictionary *)results{
  callback(@[[NSNull null]]);
}

RCT_EXPORT_MODULE();

@end

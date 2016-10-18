//
//  RNShare.h
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/8/11.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ShareSDK/ShareSDK.h>
#import <ShareSDKUI/ShareSDK+SSUI.h>
#import "RCTBridgeModule.h"

@interface RNShare : NSObject

//@property (nonatomic,strong) RCTResponseSenderBlock callBack;

-(void)share:(NSString *)title andImgUrl:(NSString *)imgUrl andUrl:(NSString *)url andContent:(NSString *)content andType:(int)type andCallBack:(RCTResponseSenderBlock)callback;

@end

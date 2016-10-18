//
//  RNShare.m
//  TCShopAPP
//
//  Created by 孝辰 吴 on 16/8/11.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RNShare.h"

@implementation RNShare


-(void)share:(NSString *)title andImgUrl:(NSString *)imgUrl andUrl:(NSString *)url andContent:(NSString *)content andType:(int)type andCallBack:(RCTResponseSenderBlock)callback{
  //1、创建分享参数
  //  NSArray* imageArray = @[[UIImage imageNamed:@"shareImg.png"]];
  //  （注意：图片必须要在Xcode左边目录里面，名称必须要传正确，如果要分享网络图片，可以这样传iamge参数 images:@[@"http://mob.com/Assets/images/logo.png?v=20150320"]）
  //  if (imageArray) {
  
  NSMutableDictionary *shareParams = [NSMutableDictionary dictionary];
  [shareParams SSDKSetupShareParamsByText:content
                                   images:@[imgUrl]//imageArray
                                      url:[NSURL URLWithString:url]
                                    title:title
                                     type:[url length]>0?SSDKContentTypeAuto:SSDKContentTypeImage];
  
    //进行分享
  [ShareSDK share:type==1?SSDKPlatformSubTypeWechatSession:SSDKPlatformSubTypeWechatTimeline //传入分享的平台类型
         parameters:shareParams
     onStateChanged:^(SSDKResponseState state, NSDictionary *userData, SSDKContentEntity *contentEntity, NSError *error) {
     
       switch (state) {
                   case SSDKResponseStateSuccess:
                   {
                     //分享成功
                     callback(@[@YES]);
                     break;
                   }
                   case SSDKResponseStateFail:
                   {
                     //分享失败
                     callback(@[@NO]);
                     break;
                   }
                   default:
                     break;
                 }
     }];
  
  //2、分享（可以弹出我们的分享菜单和编辑界面）
//  dispatch_async(dispatch_get_main_queue(), ^{
//    
//    [ShareSDK showShareActionSheet:nil items:nil shareParams:shareParams onShareStateChanged:^(SSDKResponseState state, SSDKPlatformType platformType, NSDictionary *userData, SSDKContentEntity *contentEntity, NSError *error, BOOL end) {
//      
//      switch (state) {
//        case SSDKResponseStateSuccess:
//        {
//          //分享成功
//          callback(@[@YES]);
//          break;
//        }
//        case SSDKResponseStateFail:
//        {
//          //分享失败
//          callback(@[@NO]);
//          break;
//        }
//          
//          
//        default:
//          break;
//      }
//      
//    }];
//  });

}

@end

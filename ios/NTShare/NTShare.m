//
//  NTShare.m
//  NTShare
//
//  Created by 孝辰 吴 on 2016/10/18.
//  Copyright © 2016年 TCJQ. All rights reserved.
//

#import "NTShare.h"

@implementation NTShare

RCT_EXPORT_MODULE();

/**
 *  @author wuxiaochen, 2016-08-26 20:08:05
 *
 *  微信分享，图文连接形式
 *
 *  @param NSString <#NSString description#>
 *
 *  @return <#return value description#>
 */
RCT_EXPORT_METHOD(share:(NSString *)title andImgUrl:(NSString *)imgUrl andUrl:(NSString *)url andContent:(NSString *)content andType:(int)type andCallBack:(RCTResponseSenderBlock)callback){
    RNShare *share = [[RNShare alloc]init];
    
    [share share:title andImgUrl:imgUrl andUrl:url andContent:content andType:type andCallBack:callback];
    
}

/**
 *  @author wuxiaochen, 2016-08-26 20:08:43
 *
 *  微信分享，单图分享
 */
RCT_EXPORT_METHOD(shareImg:(NSString *)imgUrl andType:(int)type andCallBack:(RCTResponseSenderBlock)callback){
    RNShare *share = [[RNShare alloc]init];
    
    [share share:@"" andImgUrl:imgUrl andUrl:@"" andContent:@"" andType:type andCallBack:callback];
    
}

@end

/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package com.ntutilshare;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class NtShareModule extends ReactContextBaseJavaModule {

	public static ReactApplicationContext context = null;

	public NtShareModule(ReactApplicationContext reactContext) {
		super(reactContext);
		context = reactContext;
	}

	@Override
	public String getName() {
		return "NtShareModule";
	}

	/**
	 *微信分享链接
	 */
	@ReactMethod
	public void share( String title, String imageUrl, String url, String content, int platform,Callback callback){
		ShareUtil.shareUrl(context, title, imageUrl, url, content, platform, callback);
	}

	/**
	 * 微信分享图片
	 */
	@ReactMethod
	public void shareImg( String imageUrl,int platform,Callback callback){
		if(imageUrl != null && imageUrl.length() > 0){
			ShareUtil.sharePhoto(context, imageUrl,  platform,callback);
		}
	}

}

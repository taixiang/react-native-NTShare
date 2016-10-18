package com.ntutilshare;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by taixiang on 16/8/26.
 */
public class ShareUtil {

	//分享链接
	public static void shareUrl(ReactApplicationContext context, String title, String imageUrl, String url, String content, int platformShare, final Callback callback){
		OnekeyShare oks = new OnekeyShare();
		if(platformShare  == 1){
			oks.setPlatform(Wechat.NAME);
		}else {
			oks.setPlatform(WechatMoments.NAME);
		}
//		oks.setTheme(OnekeyShareTheme.CLASSIC);
//		oks.setDialogMode();
		oks.disableSSOWhenAuthorize();
		oks.setTitle(title);
		oks.setImageUrl(imageUrl);
		oks.setText(content);
		oks.setUrl(url);
		oks.setCallback(new PlatformActionListener() {
			@Override
			public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
				callback.invoke(true);

			}

			@Override
			public void onError(Platform platform, int i, Throwable throwable) {
				callback.invoke(false);
			}

			@Override
			public void onCancel(Platform platform, int i) {
				callback.invoke(false);
			}
		});
		oks.show(context);
	}

	//分享图片
	public static void sharePhoto(ReactApplicationContext context,  String imageUrl,int platformShare,final Callback callback){
		OnekeyShare oks = new OnekeyShare();
		if(platformShare  == 1){
			oks.setPlatform(Wechat.NAME);
		}else {
			oks.setPlatform(WechatMoments.NAME);
		}
//		oks.setTheme(OnekeyShareTheme.CLASSIC);
//		oks.setDialogMode();
		oks.disableSSOWhenAuthorize();
		oks.setImageUrl(imageUrl);
		oks.setCallback(new PlatformActionListener() {
			@Override
			public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
				callback.invoke(true);
			}

			@Override
			public void onError(Platform platform, int i, Throwable throwable) {
				callback.invoke(false);
			}

			@Override
			public void onCancel(Platform platform, int i) {
				callback.invoke(false);
			}
		});
		oks.show(context);
	}

}

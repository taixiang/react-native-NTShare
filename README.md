# react-native-NTShare
安装：  
  `npm install react-native-ntshare`  
  `rnpm link react-native-ntshare`  
 
Android 添加:  
  `找到getPackages方法所在的类`    
  `头部添加import com.ntutilshare.NtSharePackage;`   
  `getPackages 方法里添加 new NtSharePackage()(如下)`  
  `@Override`   
    `protected List<ReactPackage> getPackages() {`  
      `return Arrays.<ReactPackage>asList(`  
         `new MainReactPackage(),`  
         `new NtSharePackage()`  
      `);`  
    `}`  
    `Application类里初始化shareSdk`  
    `ShareSDK.initSDK(this);`  
    `node_modules里react-native-ntshare 文件夹android-src-main-assets里 ShareSDK.xml 里面修改sharesdk后台注册的应用的appkey，以及微信开放平台的    AppId、AppSecret`  
    
js调用
  `const shareModule = NativeModules.NtShareModule;` 
  `platformShare 1代表微信好友，2代表微信朋友圈`  
  `微信分享链接 返回true代表成功`  
  `shareModule.share("标题","图片url地址","链接url","富文本",platformShare,(e)=>{alert(e)});`  
  `微信图片分享 返回true代表成功`  
  `shareModule.shareImg("图片url地址",platformShare,(e)=>{alert(e)});`

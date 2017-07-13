package com.alibaba.weex;

import android.widget.Toast;

import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by harrishuang on 2017/3/29.
 */

public class WXEventModule extends WXModule {

    @WXModuleAnno
    public void openURL(String url,String callbackId) {
        Toast.makeText(mWXSDKInstance.getContext(), url, Toast.LENGTH_LONG).show();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("ts", System.currentTimeMillis());
        WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callbackId, result);
    }

    @WXModuleAnno(runOnUIThread = true)
    public String printLog(String msg) {
        Toast.makeText(mWXSDKInstance.getContext(), "WXEventModule"+msg, Toast.LENGTH_LONG).show();

//        mWXSDKInstance.addUserTrackParameter();
        return "printLog=native";
//        mWXSDKInstance.getContext().startActivity(new Intent(mWXSDKInstance.getContext(),ResultActivity.class));
    }

}

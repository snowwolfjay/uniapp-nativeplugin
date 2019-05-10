package tech.lita.uni.HJ_AliBC;

import android.app.Application;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;

import com.alibaba.fastjson.JSONObject;
//import com.alibaba.baichuan.trade.biz.login.AlibcLogin
import android.content.Context;
import android.widget.Toast;
import io.dcloud.weex.AppHookProxy;

public class AliBC_AppProxy implements AppHookProxy {
    static Application mApp;
    static Context mCtx;
    @Override
    public void onCreate(final Application application) {
        //可写初始化触发逻辑
        mApp=application;
        mCtx=application.getApplicationContext();
//        Toast.makeText(mCtx, "初始化", Toast.LENGTH_SHORT).show();
        AlibcTradeSDK.asyncInit(mApp, new AlibcTradeInitCallback() {
            public void onSuccess() {
//                ans(true,888,jsCallback);
                AliBC.inited=true;
//                Toast.makeText(mCtx, "成功", Toast.LENGTH_SHORT).show();
//                final AlibcLogin alibcLogin = AlibcLogin.getInstance();
//                AlibcUserTracker.getInstance().sendInitHit4DAU("19","3.1.1.210");
            }

            public void onFailure(int code, String msg) {
//                JSONObject result = new JSONObject();
//                ans(false,code,jsCallback);

//                Toast.makeText(mCtx, "失败", Toast.LENGTH_SHORT).show();
            }

        });
    }
}

package tech.lita.uni.HJ_AliBC;

import android.app.Activity;
import android.widget.Toast;
import android.util.Log;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import android.app.Application;
import com.taobao.weex.common.WXModule;
import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.trade.biz.auth.AlibcAuth;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.android.trade.AlibcContext;
//import com.alibaba.baichuan.android.trade.
//import com.alibaba.baichuan.android.trade.
import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import java.util.HashMap;
import java.util.Map;

public class AliBCWXModule extends WXModule {
//    public String CONTENT = "content";
//    public String CONTENT_COLOR  = "contentColor";
//    public String CONTENT_ALIGN  = "contentAlign";
//    public String POSITION = "position";
//    public String BUTTONS = "buttons";
//    public String CHECKBOX = "checkBox";
//    public String TITLE_ALIGN = "titleAlign";
    private Context mCtx = AliBC_AppProxy.mCtx;

    @JSMethod(uiThread = true)
    public void init(final JSCallback jsCallback) {
//        mCtx =  mWXSDKInstance.getContext();
        //,final boolean mute if(mute!=null)
        if(AliBC.inited){
//            Toast.makeText(mCtx, "不要重复初始化", Toast.LENGTH_SHORT).show();
            ans(false,"重复的初始化",jsCallback);
            return;
        }
//        Toast.makeText(mCtx, "尝试初始化", Toast.LENGTH_SHORT).show();
        AlibcTradeSDK.asyncInit(AliBC_AppProxy.mApp, new AlibcTradeInitCallback() {
            public void onSuccess() {
                ans(true,"init success",jsCallback);
                AliBC.inited=true;
//                Toast.makeText(mContext, "成功", Toast.LENGTH_SHORT).show();
            }

            public void onFailure(int code, String msg) {
                JSONObject result = new JSONObject();
                ans(false,code+" "+msg,jsCallback);

//                Toast.makeText(mContext, "失败", Toast.LENGTH_SHORT).show();
            }

        });
//        Toast.makeText(mContext, "尝试初始化22", Toast.LENGTH_SHORT).show();
    }

    private void ans(boolean success,String msg,final  JSCallback jsCallback){
        JSONObject result = new JSONObject();
        if(success){
            result.put("success",true);
        }
        else {
            result.put("success", false);
        }
        result.put("data", msg);
        jsCallback.invoke(result);

    }
    private void show(){
//        AlibcTrade.show(mCtx, tradePage, showParams, taokeParams, trackParam, new AlibcTradeCallback() {
//
//            @Override
//            public void onTradeSuccess(TradeResult tradeResult) {
//                //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
//            }
//
//            @Override
//            public void onFailure(int code, String msg) {
//                //打开电商组件，用户操作中错误信息回调。code：错误码；msg：错误信息
//            }
//        });
    }

    @JSMethod(uiThread = true)
    public void login(final JSCallback jsCallback){
        if (mWXSDKInstance.getContext() instanceof Activity) {
            final AlibcLogin alibcLogin = AlibcLogin.getInstance();
//            alibcLogin.init(new AlibcLoginCallback() {
//                @Override
//                public void onSuccess(int i) {
//                    Toast.makeText(mCtx, "初始化成功 ",
//                            Toast.LENGTH_LONG).show();
//                }
//
//                @Override
//                public void onFailure(int code, String msg) {
//                    Toast.makeText(mCtx, "初始化失败 "+msg,Toast.LENGTH_LONG).show();
//                }
//            });
            alibcLogin.showLogin(new AlibcLoginCallback() {
                @Override
                public void onSuccess(int i) {
//                    Toast.makeText(mCtx, "登陆成功 ",
//                            Toast.LENGTH_LONG).show();
                    ans(true,JSONObject.toJSONString(AlibcLogin.getInstance().getSession()) ,jsCallback);
                }

                @Override
                public void onFailure(int code, String msg) {
//                    Toast.makeText(mCtx, "登录失败 "+msg,Toast.LENGTH_LONG).show();
                    ans(false,code+" "+msg,jsCallback);
                }
            });
        }

    }
}

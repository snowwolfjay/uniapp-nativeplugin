package tech.lita.uni.HJ_AliBC;

import android.widget.Toast;

import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.bridge.JSCallback;

public class AliBC {
//    public AliBCWXModule() {
//        super();
//    }
//     public void init(){
//        this.getContext()
//    }
    static boolean inited = false;

    static void login(View view){
        final AlibcLogin alibcLogin = AlibcLogin.getInstance();
        alibcLogin.showLogin(new AlibcLoginCallback() {
            @Override
            public void onSuccess(int i) {
                Toast.makeText(AliBC_AppProxy.mCtx, "登录成功 ",
                        Toast.LENGTH_LONG).show();
//                ans(true,alibcLogin.getSession()+"",jsCallback);
            }

            @Override
            public void onFailure(int code, String msg) {
                Toast.makeText(AliBC_AppProxy.mCtx, "登录失败 "+msg,Toast.LENGTH_LONG).show();
//                ans(false,213,jsCallback);
            }
        });
    }
}

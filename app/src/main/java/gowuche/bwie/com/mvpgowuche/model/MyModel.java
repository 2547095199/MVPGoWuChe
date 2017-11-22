package gowuche.bwie.com.mvpgowuche.model;

import gowuche.bwie.com.mvpgowuche.bean.Bean;
import gowuche.bwie.com.mvpgowuche.okhttp.AbstractUiCallBack;
import gowuche.bwie.com.mvpgowuche.okhttp.OkhttpUtils;

/**
 * Created by CZ on 2017/11/22.
 */
public class MyModel {
    public void getData(final MyModelCallback callback){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<Bean>() {

            @Override
            public void success(Bean bean) {
                callback.success(bean);
            }

            @Override
            public void failure(Exception e) {
                callback.failure(e);
            }
        });
    }

}

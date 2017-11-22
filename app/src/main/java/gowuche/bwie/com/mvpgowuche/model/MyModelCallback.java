package gowuche.bwie.com.mvpgowuche.model;

import gowuche.bwie.com.mvpgowuche.bean.Bean;

/**
 * Created by CZ on 2017/11/22.
 */
public interface MyModelCallback {
    public void success(Bean bean);
    public void failure(Exception e);

}

package gowuche.bwie.com.mvpgowuche.view3;

import gowuche.bwie.com.mvpgowuche.bean.Bean;

/**
 * Created by CZ on 2017/11/22.
 */
public interface MyView {
    public void success(Bean bean);

    public void failure(Exception e);
}

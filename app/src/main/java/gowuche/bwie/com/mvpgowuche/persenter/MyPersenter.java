package gowuche.bwie.com.mvpgowuche.persenter;

import gowuche.bwie.com.mvpgowuche.bean.Bean;
import gowuche.bwie.com.mvpgowuche.model.MyModel;
import gowuche.bwie.com.mvpgowuche.model.MyModelCallback;
import gowuche.bwie.com.mvpgowuche.view3.MyView;

/**
 * Created by CZ on 2017/11/22.
 */
public class MyPersenter {
    MyView view;
    private final MyModel model;

    public MyPersenter(MyView view) {
        this.view = view;
        model = new MyModel();
    }



    public void getData() {
        model.getData(new MyModelCallback() {
            @Override
            public void success(Bean bean) {
                if (view != null) {
                    view.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (view != null) {
                    view.failure(e);
                }
            }
        });
    }

    public void sdada() {
        this.view = null;
    }
}

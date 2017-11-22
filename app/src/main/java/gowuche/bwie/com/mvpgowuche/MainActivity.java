package gowuche.bwie.com.mvpgowuche;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gowuche.bwie.com.mvpgowuche.adapter.MyAdapter;
import gowuche.bwie.com.mvpgowuche.bean.Bean;
import gowuche.bwie.com.mvpgowuche.persenter.MyPersenter;
import gowuche.bwie.com.mvpgowuche.view3.MyView;

public class MainActivity extends AppCompatActivity implements MyView, View.OnClickListener {

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    MyPersenter persenter = new MyPersenter(this);
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //多选框的点击事件
        thirdAllselect.setOnClickListener(this);
        persenter.getData();
        //适配器
        adapter = new MyAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        thirdRecyclerview.setLayoutManager(manager);
        //recyclerview里添加数据
        thirdRecyclerview.setAdapter(adapter);
        Log.e("数据",adapter.toString());
        //适配器的事件
        adapter.setListener(new MyAdapter.UpdateUiListener(){

            @Override
            public void setToal(String total, String num, boolean allcheck) {
                thirdAllselect.setChecked(allcheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });

    }

    //添加数据
    @Override
    public void success(Bean bean) {
        adapter.add(bean);
    }
    //这是吐司失败的
    @Override
    public void failure(Exception e) {
        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
    }
    //多选框的点击事件
    @Override
    public void onClick(View view) {
        adapter.selectAll(thirdAllselect.isChecked());
    }
}

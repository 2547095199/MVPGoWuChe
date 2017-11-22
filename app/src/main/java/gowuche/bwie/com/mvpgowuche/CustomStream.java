package gowuche.bwie.com.mvpgowuche;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2017/11/22.
 */
//这是自定义view
public class CustomStream extends LinearLayout {
    //拿出控件
    @BindView(R.id.revserse)
    Button revserse;
    @BindView(R.id.content)
    EditText editText;
    @BindView(R.id.add)
    Button add;

    private int mCount = 1;

    public CustomStream(Context context) {
        super(context);
    }

    public CustomStream(Context context, AttributeSet attrs) {
        super(context, attrs);
        //链接xml
        View view = LayoutInflater.from(context).inflate(R.layout.plus_layout, null, false);
        ButterKnife.bind(this, view);
        //减号的点击事件
        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //减后在输入框里的数字是多少
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content);
                    //判断数量是否大于1，如果大于一的话可以减减，如果等于一的话则不再往下减了
                    if (count > 1) {
                        mCount = count - 1;
                        //输入框的数字
                        editText.setText(mCount + "");
                        if (listener != null) {
                            listener.click(mCount);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //加号点击事件
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //可以一直加下去
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content) + 1;
                    mCount = count;
                    editText.setText(count + "");
                    if (listener != null) {
                        listener.click(count);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //输入框
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        addView(view);
    }

    public CustomStream(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void  setEditText(int num){
        if (editText != null){
            editText.setText(num+"");
        }
    }

    private ClickListener listener;

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public interface ClickListener {
        public void click(int count);
    }
}

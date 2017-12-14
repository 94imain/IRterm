package com.example.woojinkim.irproto;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.woojinkim.irproto.data.model.NewData;
import com.example.woojinkim.irproto.data.model.Post;
import com.example.woojinkim.irproto.data.remote.APIService;
import com.example.woojinkim.irproto.data.remote.ApiUtils;
import com.google.gson.Gson;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main woojin";
    private APIService mAPIService;

    int a=R.drawable.laugh1;
    int b=R.drawable.laugh2;
    int c=R.drawable.laugh3;
    int d=R.drawable.laugh4;
    int e=R.drawable.laugh5;
    int f=R.drawable.laugh6;

    String inputmessage;

    @OnClick(R.id.btnSend) void send() {
        if(!isEmpty(editText)) {

            sendMessage(editText.getText().toString());
            Log.d(TAG, "run: here");
        }
    }

    @BindView(R.id.editText)
    EditText editText;

    @OnClick(R.id.btn1) void setBtn1 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),a);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @OnClick(R.id.btn2) void setBtn2 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),b);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @OnClick(R.id.btn3) void setBtn3 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),c);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @OnClick(R.id.btn4) void setBtn4 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),d);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @OnClick(R.id.btn5) void setBtn5 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),e);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @OnClick(R.id.btn6) void setBtn6 () {
        int start = editText.getSelectionStart();
        editText.append("^_^");
        int end = editText.getSelectionEnd();

        Spannable span = editText.getText();
        Bitmap bm = BitmapFactory.decodeResource(getResources(),f);
        span.setSpan(new ImageSpan(bm), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sendMessage(inputmessage);
    }

    @BindView(R.id.btn1)
    ImageButton btnFirst;
    @BindView(R.id.btn2)
    ImageButton btnSecond;
    @BindView(R.id.btn3)
    ImageButton btnThird;
    @BindView(R.id.btn4)
    ImageButton btnForth;
    @BindView(R.id.btn5)
    ImageButton btnFifth;
    @BindView(R.id.btn6)
    ImageButton btnSixth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAPIService = ApiUtils.getAPIService();

        inputmessage = editText.getText().toString();

        btnFirst.setImageDrawable(getDrawable(R.drawable.laugh1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.laugh2));
        btnThird.setImageDrawable(getDrawable(R.drawable.laugh3));
        btnForth.setImageDrawable(getDrawable(R.drawable.laugh4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.laugh5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.laugh6));

    }
    /*
    public void sendNewData (String newmessage, String emotion) {
        mAPIService.saveNewdata(newmessage, emotion).enqueue(new Callback<NewData>() {
            @Override
            public void onResponse(Call<NewData> call, Response<NewData> response) {
                String outmessage = response.body().newmessage;
                String emotion = response.body().emotion;
                Log.d(TAG, "onResponse: "+outmessage+" "+emotion);
            }

            @Override
            public void onFailure(Call<NewData> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.toString());
            }
        });
    }
    */

    public void sendMessage(String message) {
            mAPIService.savePost(message).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {

                    if (response.isSuccessful()) {
                        String output = response.body().inputmessage;
                        Log.i(TAG, "OK " + output);
                        if (output.contains("laugh")) {
                            Log.d(TAG, "onResponse: laugh contained");
                            setLaugh();
                        } else if (output.contains("sad")) {
                            Log.d(TAG, "onResponse: sad contaied");
                            setSad();
                        } else if (output.contains("angry")) {
                            Log.d(TAG, "onResponse: angry contaied");
                            setAngry();
                        } else if (output.contains("love")) {
                            Log.d(TAG, "onResponse: love contaied");
                            setLove();
                        } else if (output.contains("shock")) {
                            Log.d(TAG, "onResponse: shock contaied");
                            setShock();
                        } else if (output.contains("wow")) {
                            Log.d(TAG, "onResponse: wow contained");
                            setWOW();
                        } else {
                            Log.d(TAG, "onResponse: nothing contaied");
                            setAngry();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API." + t.toString());
                }
            });
    }

    public void setLaugh() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.laugh1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.laugh2));
        btnThird.setImageDrawable(getDrawable(R.drawable.laugh3));
        btnForth.setImageDrawable(getDrawable(R.drawable.laugh4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.laugh5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.laugh6));
        a=R.drawable.laugh1;
        b=R.drawable.laugh2;
        c=R.drawable.laugh3;
        d=R.drawable.laugh4;
        e=R.drawable.laugh5;
        f=R.drawable.laugh6;
    }

    public void setSad() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.sad1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.sad2));
        btnThird.setImageDrawable(getDrawable(R.drawable.sad3));
        btnForth.setImageDrawable(getDrawable(R.drawable.sad4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.sad5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.sad6));
        a=R.drawable.sad1;
        b=R.drawable.sad2;
        c=R.drawable.sad3;
        d=R.drawable.sad4;
        e=R.drawable.sad5;
        f=R.drawable.sad6;
    }

    public void setLove() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.love1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.love2));
        btnThird.setImageDrawable(getDrawable(R.drawable.love3));
        btnForth.setImageDrawable(getDrawable(R.drawable.love4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.love5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.love6));
        a=R.drawable.love1;
        b=R.drawable.love2;
        c=R.drawable.love3;
        d=R.drawable.love4;
        e=R.drawable.love5;
        f=R.drawable.love6;
    }

    public void setAngry() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.angry1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.angry2));
        btnThird.setImageDrawable(getDrawable(R.drawable.angry3));
        btnForth.setImageDrawable(getDrawable(R.drawable.angry4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.angry5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.angry6));
        a=R.drawable.angry1;
        b=R.drawable.angry2;
        c=R.drawable.angry3;
        d=R.drawable.angry4;
        e=R.drawable.angry5;
        f=R.drawable.angry6;
    }

    public void setShock() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.shock1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.shock2));
        btnThird.setImageDrawable(getDrawable(R.drawable.shock3));
        btnForth.setImageDrawable(getDrawable(R.drawable.shock4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.shock5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.shock6));
        a=R.drawable.shock1;
        b=R.drawable.shock2;
        c=R.drawable.shock3;
        d=R.drawable.shock4;
        e=R.drawable.shock5;
        f=R.drawable.shock6;
    }

    public void setWOW() {
        btnFirst.setImageDrawable(getDrawable(R.drawable.wow1));
        btnSecond.setImageDrawable(getDrawable(R.drawable.wow2));
        btnThird.setImageDrawable(getDrawable(R.drawable.wow3));
        btnForth.setImageDrawable(getDrawable(R.drawable.wow4));
        btnFifth.setImageDrawable(getDrawable(R.drawable.wow5));
        btnSixth.setImageDrawable(getDrawable(R.drawable.wow6));
        a=R.drawable.wow1;
        b=R.drawable.wow2;
        c=R.drawable.wow3;
        d=R.drawable.wow4;
        e=R.drawable.wow5;
        f=R.drawable.wow6;

    }
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

}

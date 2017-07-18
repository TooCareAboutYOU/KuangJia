package com.cnlive.meplusd.sample_okhttp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "okhttp-main";

    private static final String GET_URL = "http://120.131.13.185:8080/goldenline-portal-clt/login.html";
    private static final String POST_URL = "http://fanyi.youdao.com/";
    private static final String POST_STRING_URL = "https://123.sogou.com/";
    private static final String POST_FILE_URL = "https://api.shineup.com.cn/goldenline-portal-clt/uploadPhoto.html?plat=a";

    // 1、拿到OkHttpClient对象
    OkHttpClient okHttpClient = new OkHttpClient();

    int RESULT_LOAD_IMAGE=1;

    @Bind(R.id.tv_text1)
    TextView mTvText1;
    @Bind(R.id.img_picture)
    ImageView mImgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    void doGET(View v) {
        // 1、拿到OkHttpClient对象
        //OkHttpClient okHttpClient=new OkHttpClient();

        // 2、构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(GET_URL).build();
        executeRequest(request);
    }

    void doPOST(View v) {
        // 1、拿到OkHttpClient对象
        //OkHttpClient okHttpClient=new OkHttpClient();

        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        //构造 RequestBody
        RequestBody requestBody = formEncodingBuilder.add("uname", "admin").add("pwd", "123").build();

        // 2、构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(POST_URL).post(requestBody).build();
        executeRequest(request);
    }

    void doPostString(View v) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain;chaset=utf-8"), "{username:admin,pwd:123}");
        // 2、构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(POST_STRING_URL).post(requestBody).build();
        executeRequest(request);
    }

    //上传图片
    void doPostFile(View v) {
        Intent i = new Intent( Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imgurl(picturePath);
        }
    }

    void imgurl(String url){
        File file = new File(url);
        if (!file.exists()) {
            Toast.makeText(this, "File, no exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "File is exists", Toast.LENGTH_SHORT).show();
            mTvText1.setText(file.getPath().toString());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(file.getPath().toString(), options);
            mImgPicture.setImageBitmap(bm);
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        // 2、构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(POST_FILE_URL).post(requestBody).build();
        executeRequest(request);
    }


    void doPostUpload(View v) {
        File file = new File(Environment.getExternalStorageDirectory(), "/DCIM/Camera/IMG_20161122_114954319.jpg");  // /storage/emulated/0/DCIM/
        if (!file.exists()) {
            Toast.makeText(this, "File no exists", Toast.LENGTH_SHORT).show();
            return;
        }
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        multipartBuilder
                .type(MultipartBuilder.FORM)
                .addFormDataPart("uid", "123")
                .addFormDataPart("ulogo", "1481072527985.jpg", RequestBody.create(MediaType.parse("application/octet-stream"), file));

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        // 2、构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(POST_FILE_URL).post(requestBody).build();
        executeRequest(request);
    }


    private void executeRequest(Request request) {
        // 3、将Request封装为Call
        Call call = okHttpClient.newCall(request);
        // 4、执行Call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) { }

            @Override
            public void onResponse(Response response) throws IOException {
                final String str = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvText1.setText(str);
                    }
                });
            }
        });
    }
}

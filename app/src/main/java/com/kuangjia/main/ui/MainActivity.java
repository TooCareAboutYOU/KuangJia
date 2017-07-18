package com.kuangjia.main.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kuangjia.main.R;
import com.kuangjia.main.utils.FrescoUtil;
import com.loopj.android.image.SmartImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.image1)
    SmartImageView image1;
    @Bind(R.id.image2)
    SmartImageView image2;
    @Bind(R.id.image3)
    SmartImageView image3;
    @Bind(R.id.image4)
    SmartImageView image4;
    @Bind(R.id.image5)
    SmartImageView image5;

    @Bind(R.id.simpleImage1)
    SimpleDraweeView simpleImage1;
    @Bind(R.id.simpleImage2)
    SimpleDraweeView simpleImage2;
    @Bind(R.id.simpleImage3)
    SimpleDraweeView simpleImage3;
    @Bind(R.id.simpleImage4)
    SimpleDraweeView simpleImage4;
    @Bind(R.id.simpleImage5)
    SimpleDraweeView simpleImage5;
    @Bind(R.id.simpleImage6)
    SimpleDraweeView simpleImage6;
    @Bind(R.id.simpleImage12)
    SimpleDraweeView simpleImage12;
    @Bind(R.id.simpleImage13)
    SimpleDraweeView simpleImage13;
    @Bind(R.id.simpleImage14)
    SimpleDraweeView simpleImage14;
    @Bind(R.id.simpleImage15)
    SimpleDraweeView simpleImage15;
    @Bind(R.id.simpleImage141)
    SimpleDraweeView simpleImage141;
    @Bind(R.id.simpleImage151)
    SimpleDraweeView simpleImage151;
    @Bind(R.id.simpleImage16)
    SimpleDraweeView simpleImage16;
    @Bind(R.id.simpleImage17)
    SimpleDraweeView simpleImage17;
    @Bind(R.id.simpleImage18)
    SimpleDraweeView simpleImage18;
    @Bind(R.id.simpleImage19)
    SimpleDraweeView simpleImage19;
    @Bind(R.id.simpleImage20)
    SimpleDraweeView simpleImage20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




        simpleImage1.setImageURI(Uri.parse("http://yweb3.cnliveimg.com/img/cnlive/161121103649189_625.png"));
        simpleImage2.setImageURI(Uri.parse("http://yweb3.cnliveimg.com/img/cnlive/161121104613650_724.jpg"));
        simpleImage3.setImageURI(Uri.parse("http://y1.cnliveimg.com:8080/image/itv/2016/1107/44032bce8eb240cbb8a752880a6d16cf_159685_100.jpg"));
        simpleImage4.setImageURI(Uri.parse("http://yweb2.cnliveimg.com/img/cnlive/161121104426770_239.jpg"));
        simpleImage5.setImageURI(Uri.parse("http://y1.cnliveimg.com:8080/image/itv/2016/1107/44032bce8eb240cbb8a752880a6d16cf_159685_100.jpg"));
        simpleImage6.setImageURI(Uri.parse("http://yweb1.cnliveimg.com/img/cnlive/161121104132406_338.jpg"));


        simpleImage12.setImageURI(Uri.parse("http://yweb0.cnliveimg.com/img/cnlive/161121102931172_988.jpg"));
        simpleImage13.setImageURI(Uri.parse("http://yweb3.cnliveimg.com/img/cnlive/161121103649189_625.png"));
        simpleImage14.setImageURI(Uri.parse("http://yweb1.cnliveimg.com/img/cnlive/161121104132406_338.jpg"));
        simpleImage141.setImageURI(Uri.parse("http://y1.cnliveimg.com:8080/image/itv/2016/1107/44032bce8eb240cbb8a752880a6d16cf_159685_100.jpg"));
        simpleImage15.setImageURI(Uri.parse("http://yweb2.cnliveimg.com/img/cnlive/161121104426770_239.jpg"));
        simpleImage151.setImageURI(Uri.parse("http://yweb3.cnliveimg.com/img/cnlive/161121104613650_724.jpg"));


        image1.setImageUrl("http://yweb2.cnliveimg.com/img/cnlive/161121104426770_239.jpg");
        image2.setImageUrl("http://yweb3.cnliveimg.com/img/cnlive/161121103649189_625.png");
        image3.setImageUrl("http://yweb1.cnliveimg.com/img/cnlive/161121104132406_338.jpg");
        image4.setImageUrl("http://y1.cnliveimg.com:8080/image/itv/2016/1107/44032bce8eb240cbb8a752880a6d16cf_159685_100.jpg");
        image5.setImageUrl("http://yweb2.cnliveimg.com/img/cnlive/161121104426770_239.jpg");

        FrescoUtil.loadGifPicInApp(simpleImage16, R.drawable.gif_one1);
        FrescoUtil.loadGifPicInApp(simpleImage17, R.drawable.gif_two2);
        FrescoUtil.loadGifPicInApp(simpleImage18, R.drawable.gif_three3);
        FrescoUtil.loadGifPicInApp(simpleImage19, R.drawable.gif_four4);
        FrescoUtil.loadGifPicInApp(simpleImage20, R.drawable.gif_one);

        simpleImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GridViewPagerActivity.class));
            }
        });
        simpleImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        simpleImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UploadPictureActivity.class));
            }
        });

        simpleImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShowToolBarActivity.class));
            }
        });
        simpleImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this,ViewFlipperActivity.class));
            }
        });
        simpleImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
            }
        });

        simpleImage12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HttpDataActivity.class));
            }
        });
        // http://apis.baidu.com/chazhao/mobilesearch/phonesearch?string=15821239216&apikey=064ba7565b0030c004f1da9ef26bc1c3
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.ACTION_DOWN){
            Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}

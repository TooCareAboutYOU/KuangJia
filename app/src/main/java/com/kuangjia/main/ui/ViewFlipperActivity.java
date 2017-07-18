package com.kuangjia.main.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.facebook.drawee.view.SimpleDraweeView;
import com.kuangjia.main.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {

    @Bind(R.id.viewflipper_bussiness)
    ViewFlipper viewflipper;
    private GestureDetector gestureDetector;

    //图片数组
    private int[] imgs1 ={R.drawable.gif_one,R.drawable.gif_one1,
            R.drawable.gif_two,R.drawable.gif_two2,
            R.drawable.gif_three,R.drawable.gif_three3,
            R.drawable.gif_four,R.drawable.gif_four4};
    private String[] img={"http://yweb0.cnliveimg.com/img/cnlive/161121102931172_988.jpg",
            "http://yweb3.cnliveimg.com/img/cnlive/161121103649189_625.png",
            "http://yweb1.cnliveimg.com/img/cnlive/161121104132406_338.jpg",
            "http://yweb3.cnliveimg.com/img/cnlive/161121104613650_724.jpg",
            "http://yweb2.cnliveimg.com/img/cnlive/161121104426770_239.jpg",
            "http://y1.cnliveimg.com:8080/image/itv/2016/1107/44032bce8eb240cbb8a752880a6d16cf_159685_100.jpg"};

    private int[] imgs = {R.drawable.bussinessfistpage, R.drawable.websitebuild, R.drawable.weixinyunying,
            R.drawable.qqa, R.drawable.qiyeyouxiang, R.drawable.guofengruanjian, R.drawable.fengshengchuanmei};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);
        ButterKnife.bind(this);

        //循环加载图片到 ViewFlipper中
        for(int i=0;i<img.length;i++){
            SimpleDraweeView imagview = new SimpleDraweeView(this);
            //FrescoUtil.loadGifPicInApp(imagview, imgs[i]);
            imagview.setImageURI(Uri.parse(img[i]));
            imagview.setScaleType(SimpleDraweeView.ScaleType.FIT_XY);
            viewflipper.addView(imagview, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        }
        gestureDetector=new GestureDetector(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) { return false; }

    @Override
    public void onShowPress(MotionEvent e) { }
    /**
     * 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) { return false; }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) { return false; }

    @Override
    public void onLongPress(MotionEvent e) { }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e2.getX() - e1.getX() > 120) {            // 从左向右滑动（左进右出）
            Animation rInAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_right_in);  // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
            Animation rOutAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            viewflipper.setInAnimation(rInAnim);
            viewflipper.setOutAnimation(rOutAnim);
            viewflipper.showPrevious();  // 调用该函数来显示FrameLayout里面的上一个View。
            return true;
        } else if (e2.getX() - e1.getX() < -120) {        // 从右向左滑动（右进左出）
            Animation lInAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_left_in);       // 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）
            Animation lOutAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_left_out);     // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            viewflipper.setInAnimation(lInAnim);
            viewflipper.setOutAnimation(lOutAnim);
            viewflipper.showNext();  // 调用该函数来显示FrameLayout里面的下一个View。
            return true;
        }
        if (e2.getY() - e1.getY() > 120) {            // 从上向下滑动
            Animation rInAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_up_in);
            Animation rOutAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_up_out);

            viewflipper.setInAnimation(rInAnim);
            viewflipper.setOutAnimation(rOutAnim);
            viewflipper.showNext();  // 调用该函数来显示FrameLayout里面的上一个View。
            return true;
        } else if (e2.getY() - e1.getY() < -120) {        // 从下向上滑动
            Animation lInAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_down_in);
            Animation lOutAnim = AnimationUtils.loadAnimation(ViewFlipperActivity.this, R.anim.push_down_out);

            viewflipper.setOutAnimation(lOutAnim);
            viewflipper.setInAnimation(lInAnim);
            viewflipper.showPrevious();  // 调用该函数来显示FrameLayout里面的下一个View。
            return true;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}

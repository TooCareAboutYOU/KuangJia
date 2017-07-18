package com.kuangjia.htmljsoup;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {
    @Bind(R.id.txt_show)
    TextView txt;
    @Bind(R.id.txt_api)
    TextView tv_api;
    @Bind(R.id.txt_jsoup_html)
    TextView txtJsoupHtml;
    @Bind(R.id.txt_jsoup_url)
    TextView txtJsoupUrl;
    @Bind(R.id.txt_jsoup_body)
    TextView txtJsoupBody;
    @Bind(R.id.txt_jsoup_wendang)
    TextView txtJsoupWendang;
    @Bind(R.id.txt_jsoup_dom)
    TextView txtJsoupDom;
    @Bind(R.id.txt_jsoup_urls)
    TextView txtJsoupUrls;
    @Bind(R.id.txt_html)
    TextView txtHtml;

    private String path = "http://www.cnblogs.com/yc-755909659/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String url = "http://apis.baidu.com/apistore/weatherservice/citylist";
        String args = "cityname=%E6%9C%9D%E9%98%B3";


        tv_api.setText(request(url, args));
        Log.i("TSM", request(url, args) + "没调用？");

        UserAPI userAPI = RestAdapterUtils.getRestAPI(Config.SJR_URL, UserAPI.class);
        userAPI.getInfo(new Callback<ErrorMessage>() {
            @Override
            public void success(ErrorMessage errorMessage, Response response) {
                String str = errorMessage.getErrorMessage().toString();
                txt.setText(str.toString());
                Log.i("TSM", str);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("TSM", error.toString());
            }
        });


        /**
         * md5解密
         * "http://apis.baidu.com/chazhao/md5decod/md5decod";
         * "md5=b035b895aae7ea345897cac146a9eee3369c9ef1";
         * */

        /**
         * 天气预报
         * "http://apis.baidu.com/apistore/weatherservice/citylist"
         * "cityname=上海"
         * */

        /*
        * Jsoup
        * */
        new Thread(netWorkTask).start();
        new Thread(netWorkTask1).start();




    }


    Runnable netWorkTask = new Runnable() {
        @Override
        public void run() {
            try {
                /*解析一个HTML字符串*/
                /*解析和遍历一个HTML文档*/
                Message msg1 = new Message();
                String html = "<html><head><title>First parse</title></head>"
                        + "<body><p>Parsed HTML into a doc.</p></body></html>";
                Document doc1 = Jsoup.parse(html);
                String htl = doc1.html();
                Bundle bundle1 = new Bundle();
                bundle1.putString("a", htl);
                msg1.setData(bundle1);
                msg1.what = 1;
                handler.sendMessage(msg1);

                /*从一个URL加载一个Document*/
                Message msg2 = new Message();
                Document doc2 = Jsoup.connect("http://www.baidu.com/").get();
                Document doc22 = Jsoup.connect("http://example.com")
                        .data("query", "Java")
                        .userAgent("Mozilla")
                        .cookie("auth", "token")
                        .timeout(3000)
                        .post();
                String title = doc2.title();
                Bundle bundle2 = new Bundle();
                bundle2.putString("b", title + "\t\t" + doc22.title());
                msg2.setData(bundle2);
                msg2.what = 2;
                handler.sendMessage(msg2);

                /*解析一个body片断*/
                Message msg3 = new Message();
                String html3 = "<div><p>Lorem ipsum.</p>";
                Document doc3 = Jsoup.parse(html3);
                Element body = doc3.body();
                String htl3 = body.data();
                Bundle bundle3 = new Bundle();
                bundle3.putString("c", htl3);
                msg3.setData(bundle3);
                msg3.what = 3;
                handler.sendMessage(msg3);


            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                URL url1 = new URL("http://www.baidu.com");
                HttpURLConnection con = (HttpURLConnection) url1.openConnection();
                con.connect();
                InputStream is = con.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }

                Message msgHtml = new Message();
                Bundle builderHtml = new Bundle();
                builderHtml.putString("html", builder.toString());
                msgHtml.setData(builderHtml);
                msgHtml.what = 10;
                handler.sendMessage(msgHtml);
                System.out.println("网页源码：" + builder.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    Runnable netWorkTask1 = new Runnable() {
        @Override
        public void run() {
            try {

                /*从文件加载一个文档*/
                Message msg4 = new Message();
                File input4 = new File("file:///C:/users/lenovo/desktop/v2.5/home.html");
                Document doc4 = Jsoup.parse(input4, "UTF-8", "");
                String htl4 = doc4.html();
                Bundle bundle4 = new Bundle();
                bundle4.putString("d", htl4);
                msg4.setData(bundle4);
                msg4.what = 4;
                handler.sendMessage(msg4);


                /*使用DOM方法来遍历一个文档*/
                Message msg5 = new Message();
                File input5 = new File("/tmp/input.html");
                Document doc5 = Jsoup.parse(input5, "UTF-8", "http://example.com/");

                Element content4 = doc5.getElementById("content");
                Elements links = content4.getElementsByTag("a");
                Bundle bundle5 = new Bundle();
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text();
                    bundle5.putString("e", linkHref + "\t\t" + linkText);
                }
                msg5.setData(bundle5);
                msg5.what = 5;
                handler.sendMessage(msg5);


                /*处理URLs*/
                Message msg6 = new Message();
                //Document doc6 = Jsoup.connect("http://www.open-open.com").get();
                //Element link = doc6.select("a").first();
                //String relHref = link.attr("href"); // == "/"
                //String absHref = link.attr("abs:href"); // "http://www.open-open.com/"


                String htmlContent = HtmlService.getHtml(path);
                Bundle bundle6 = new Bundle();
                //bundle6.putString("f", relHref + "\t\t" + absHref);
                bundle6.putString("f", htmlContent);
                msg6.setData(bundle6);
                msg6.what = 6;
                handler.sendMessage(msg6);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    txtJsoupHtml.setText("1.解析HTML：" + msg.getData().getString("a"));
                    break;
                case 2:
                    txtJsoupUrl.setText("2.从URL加载一个Document：" + msg.getData().getString("b"));
                    break;
                case 3:
                    txtJsoupBody.setText("3.解析一个body片断：" + msg.getData().getString("c"));
                    break;
                case 4:
                    txtJsoupWendang.setText("4.从文件加载一个文档：" + msg.getData().getString("d"));
                    break;
                case 5:
                    txtJsoupDom.setText("5.DOM方法来遍历一个文档：" + msg.getData().getString("e"));
                    break;
                case 6:
                    txtJsoupUrls.setText("6.处理URLs：" + msg.getData().getString("f"));
                    break;
                case 10:
                    txtHtml.setText("10.网页源码：" + msg.getData().getString("html"));
                    break;
            }
        }
    };


    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;
        Log.i("TSM", "httpUrl===" + httpUrl);
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "064ba7565b0030c004f1da9ef26bc1c3");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
                Log.i("TSM", "sbf.toString===" + sbf.toString());
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("TSM", "result===" + result);

        return result;
    }


    //http://apis.baidu.com/chazhao/md5decod/md5decod?md5=b688b5274c67e5a770cd66fbfaed6c30
    // 064ba7565b0030c004f1da9ef26bc1c3
}

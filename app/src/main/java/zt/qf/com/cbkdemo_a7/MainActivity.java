package zt.qf.com.cbkdemo_a7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private List<HeaderItemBean> datas=new ArrayList<>();
    private HeaderBeanAdapter headerBeanAdapter;
    private String url="http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getHeadlines&page=%d&rows=%d";
    private int page=0;
    private int row=15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.查找listView控件
        listView = ((ListView) findViewById(R.id.listViewId));

        /**
         * 开启一个异步任务下载数据
         *
         * onPostExecutor(List<T> dd)
         * {
         *     //一定不要这样去写：datas = dd;
         *     if(dd!=null)
         *     {
         *         datas.addAll(dd);
         *         headerBeanAdapter.notifydataSetChange();
         *     }
         * }
         *
         *
         */
        //2.实例化适配器
        headerBeanAdapter = new HeaderBeanAdapter(datas,this);
        //3.设置适配器
        listView.setAdapter(headerBeanAdapter);
        //4.加载数据
        loadData();
    }

    private void loadData() {
        //datas.addAll(...)
        /*new RequestHeaderJson() {
            @Override
            public void getString(String s) {

            }
        }.execute("");*/
        new RequestHeaderJson(new RequestHeaderJson.Callback() {
            @Override
            public void response(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray data = jsonObject.optJSONArray("data");
                    ArrayList<HeaderItemBean> dds = new ArrayList<>();
                    for (int i = 0; i < data.length(); i++) {
                        HeaderItemBean headerItemBean = new HeaderItemBean(data.getJSONObject(i));
                        dds.add(headerItemBean);
                    }
                    datas.addAll(dds);
                    headerBeanAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).execute(String.format(url,page++,row));
    }
}

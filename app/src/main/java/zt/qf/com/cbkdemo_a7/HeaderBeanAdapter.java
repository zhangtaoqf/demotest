package zt.qf.com.cbkdemo_a7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/3.
 */
public class HeaderBeanAdapter extends BaseAdapter {
    private List<HeaderItemBean> datas;
    private LayoutInflater inflater;

    public HeaderBeanAdapter(List<HeaderItemBean> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public HeaderItemBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * o将数据源转化为UI控件
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_header,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }
        //设置内容

        HeaderItemBean item = getItem(position);
        //设置文字内容
        viewHolder.title.setText(item.getTitle());
        viewHolder.create_time.setText(item.getCreate_time());
        //设置图片内容

        return convertView;
    }

    class ViewHolder
    {
        private ImageView wap_thumb;
        private TextView title,create_time;
        public ViewHolder(View convertView)
        {
            wap_thumb = ((ImageView) convertView.findViewById(R.id.item_header_wap_thumbId));
            title = ((TextView) convertView.findViewById(R.id.item_header_titleId));
            create_time = ((TextView) convertView.findViewById(R.id.item_header_create_timeId));
        }
    }

}

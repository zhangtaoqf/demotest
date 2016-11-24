package zt.qf.com.cbkdemo_a7;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/3.
 *  {
 "id": "8218",
 "title": "认识凤凰单丛茶",
 "source": "原创",
 "description": "",
 "wap_thumb": "http://s1.sns.maimaicha.com/images/2016/01/06/20160106110314_22333_suolue3.jpg",
 "create_time": "01月06日11:04",
 "nickname": "bubu123"
 }
 *
 */
public class HeaderItemBean {
    private String id;
    private String title;
    private String source;
    private String description;
    private String wap_thumb;
    private String create_time;
    private String nickname;

    public HeaderItemBean() {
    }

    public HeaderItemBean(JSONObject jsonObject)
    {
        this.id = jsonObject.optString("id");
        this.title = jsonObject.optString("title");
        this.source = jsonObject.optString("source");
        this.description = jsonObject.optString("description");
        this.wap_thumb = jsonObject.optString("wap_thumb");
        this.create_time = jsonObject.optString("create_time");
        this.nickname = jsonObject.optString("nickname");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWap_thumb() {
        return wap_thumb;
    }

    public void setWap_thumb(String wap_thumb) {
        this.wap_thumb = wap_thumb;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

package com.controller;

import com.conf.ESConfig;
import com.util.Tool;
import net.sf.json.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ESController {

    //    @Autowired
//    @Qualifier("xx")
//    等同于@Resource(name = "xx")
    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String test() {
        return "ok";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String test001(@RequestParam String id, @RequestParam String name, @RequestParam String message) {
        String index = "index_aa";//index名，如果不存在自动创建
        String type = "user";//type名，如果不存在自动创建
//        String id = "1";//记录id，如果本来就存在，则视为更新操作，覆盖原来的记录

        JSONObject data = new JSONObject();
        data.element("user", name);
        data.element("post_date", "2018-02-02 16:22:37");
        data.element("message", message);

        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return Tool.put(data.toString(), url);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String test002(@RequestParam String type, @RequestParam String id) {
        String index = "index_aa";//index名
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return Tool.get(url);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String test003(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return Tool.delete(url);
    }

    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    public boolean exist(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        int code = Tool.head(url);
        return 200 == code ? true : false;
    }

    @Autowired
    private RestHighLevelClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String haha(){
        String index = "index_order";
        String type = "order";
        String id = "1";
        Map<String, Object> child1 = new HashMap<>();
        Map<String, Object> child2 = new HashMap<>();
        child1.put("name","John Smith");
        child1.put("comment","Great article");
        child1.put("age",28);
        child1.put("stars",4);
        child1.put("date","2014-09-01");

        child2.put("name","Alice White");
        child2.put("comment","More like this please");
        child2.put("age",31);
        child2.put("stars",5);
        child2.put("date","2014-10-22");

        List<Map<String, Object>> childList = new ArrayList<>();
        childList.add(child1);
        childList.add(child2);

        Map<String, Object> doc = new HashMap<>();
        doc.put("title","Nest eggs");
        doc.put("body","Making your money work...");
        doc.put("tags",new String[]{"cash","shares"});
        doc.put("comments",childList);

        IndexRequest request = new IndexRequest(index, type, id);
        request.source(doc);
        try {
            IndexResponse response = client.index(request);
            Tool.jsonPrint(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public GetResponse get(){
        String index = "index_order";
        String type = "order";
        String id = "1";
        GetRequest request = new GetRequest(index,type,id);
        try {
            GetResponse response = client.get(request);
            Tool.jsonPrint(response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

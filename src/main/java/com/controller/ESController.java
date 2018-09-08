package com.controller;

import com.conf.ESConfig;
import com.util.Tool;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ESController {

//    @Autowired
//    @Qualifier("xx")
//    等同于@Resource(name = "xx")
    @RequestMapping(value ="/ok",method = RequestMethod.GET)
    public String test(){
        return "ok";
    }

    @RequestMapping(value ="/put",method = RequestMethod.GET)
    public String test001(@RequestParam String id,@RequestParam String name,@RequestParam String message){
        String index = "index_aa";//index名，如果不存在自动创建
        String type = "user";//type名，如果不存在自动创建
//        String id = "1";//记录id，如果本来就存在，则视为更新操作，覆盖原来的记录

        JSONObject data = new JSONObject();
        data.element("user",name);
        data.element("post_date","2018-02-02 16:22:37");
        data.element("message",message);

        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return Tool.put(data.toString(),url);
    }

    @RequestMapping(value ="/get",method = RequestMethod.GET)
    public String test002(@RequestParam String type,@RequestParam String id){
        String index = "index_aa";//index名
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return  Tool.get(url);
    }

    @RequestMapping(value ="/delete",method = RequestMethod.GET)
    public String test003(@RequestParam String index,@RequestParam String type,@RequestParam String id){
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        return Tool.delete(url);
    }

    @RequestMapping(value ="/exist",method = RequestMethod.GET)
    public boolean exist(@RequestParam String index,@RequestParam String type,@RequestParam String id){
        String url = ESConfig.URL + "/" + index + "/" + type + "/" + id;
        int code = Tool.head(url);
        return 200 == code?true:false;
    }
}

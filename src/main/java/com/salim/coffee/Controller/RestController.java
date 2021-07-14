package com.salim.coffee.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController {

    @GetMapping("/index")
    public static String index(Model model){
        Map<String,String> map =new HashMap<>();
        map.clear();
        map.put("name","mehdi");
        model.addAllAttributes(map);
        return "index.html";
    }
}

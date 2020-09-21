package com.source.server;


import com.source.bean.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Log4j
@Api(value = "/userManage", description = "用户管理系统接口")
@RestController
@RequestMapping(value = "/userManage")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "登录接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(HttpServletResponse response,@RequestBody() LoginUser loginUser) {
        Map<String, String> map = new HashMap<>();
        int i = template.selectOne("login", loginUser);
        if (i == 1) {
            Cookie cookie = new Cookie("longin", "loginTrue");
            response.addCookie(cookie);
            map.put("code", "200");
            map.put("msg", "login True");
            return map;
        }
        map.put("code", "400");
        map.put("msg", "login false");
        return map;
    }

    @ApiOperation(value = "获取用户列表", httpMethod = "GET")
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List getUserList(HttpServletRequest request, @RequestParam String userName,@RequestParam String password) {
        Map<String ,Object> map = new HashMap<String ,Object>();
/*        if (!Objects.isNull(request)) {
            System.out.println("走了request空");
            map.put("code","500");
            map.put("msg","cookie is null");
            return map;
        }else {
            System.out.println(request.getCookies());
        }*/
        System.out.println(1);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(2);
            if (cookie.getName().equals("longin") && cookie.getValue().equals("loginTrue")){
                System.out.println(3);
                if (userName.equals("zhangsan") && password.equals("123123")) {
                    System.out.println(4);
                    return template.selectList("getUserList");
                }
            }
        }
        System.out.println(5);
        map.put("code","400");
        map.put("msg","cookie is error");
        List list = new ArrayList();
        list.add(map);
        return list;
    }
}

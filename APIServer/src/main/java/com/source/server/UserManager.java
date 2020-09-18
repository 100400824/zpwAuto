package com.source.server;


import com.source.bean.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
            Cookie cookie = new Cookie("longin", "true");
            response.addCookie(cookie);
            map.put("code", "200");
            map.put("msg", "login True");
            return map;
        }
        map.put("code", "400");
        map.put("msg", "login false");
        return map;
    }
}

package com.source.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "/v1", description = "全部GET请求")
@RequestMapping(value = "/v1")
public class GetServer {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数量", httpMethod = "GET")
    public Integer getUserCount() {
        return template.selectOne("getUserCount");
    }


    @RequestMapping(value = "/example", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法获取cookie", httpMethod = "GET")
    public String example(HttpServletResponse response) {
        Cookie cookie = new Cookie("loginCookie", "zpwTest");
        response.addCookie(cookie);
        return "获取cookie成功。";
    }

    @RequestMapping(value = "/checkCookie", method = RequestMethod.GET)
    @ApiOperation(value = "校验接口是否存在正确的cookie", httpMethod = "GET")
    public String checkCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "cookie is temp.";
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginCookie") && cookie.getValue().equals("zpwTest")) {
                    return "check success.";
                }
            }
        }
        return "cookie is wrong.";
    }

    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数返回产品列表-第一种", httpMethod = "GET")
    public Map<String, String> getProductList1(@RequestParam Integer one, @RequestParam Integer two) {
        Map<String, String> productList = new HashMap<>();
        productList.put("衣服A", "100");
        productList.put("裤子A", "200");
        productList.put("鞋子A", "300");
        productList.put("书包A", "400");
        return productList;
    }

    @RequestMapping(value = "/getProductList/{one}/{two}", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数返回产品列表-第二种", httpMethod = "GET")
    public Map<String, String> getProductList2(@PathVariable Integer one, @PathVariable Integer two) {
        Map<String, String> productList = new HashMap<>();
        productList.put("衣服B", "100");
        productList.put("裤子B", "200");
        productList.put("鞋子B", "300");
        productList.put("书包B", "400");
        return productList;
    }

}

package com.source.server;

import com.source.bean.StudentCourse;
import com.source.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "/v1", description = "所有的POST接口请求")
@RequestMapping("/v1")
public class PostServer {

    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public int StudentCourse(@RequestBody StudentCourse course){
        return template.insert("addStudentCourse",course);
    }

    @ApiOperation(value = "更新成绩接口",httpMethod = "POST")
    @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
    public int updateCourse(@RequestBody StudentCourse course) {
        return template.update("updateCourse",course);
    }

    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.DELETE)
    public int deleteCourse(@RequestParam int id) {
        return template.delete("deleteCourse",id);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestBody User user) {
        if (user.getUserName().equals("zpw") && user.getPassWord().equals("123123")) {
            Cookie cookie = new Cookie("loingCookie", "zpw");
            response.addCookie(cookie);
            return "登录成功";
        }

        return "账号密码错误";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表接口", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,@RequestBody User user) {
        User userInfo = new User();
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "缺少token，校验失败。";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loinCookie")
                    && cookie.getValue().equals("zpw")
                    && user.getName().equals("zpw")) {
                userInfo.setUserName("zpw");
                userInfo.setPassWord("******");
                userInfo.setName("zpw");
                userInfo.setAge("18");
                userInfo.setSex("boy");
                return userInfo.toString();
            }
        }
        return "校验失败，无法获取用户列表";
    }

}

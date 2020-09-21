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



}

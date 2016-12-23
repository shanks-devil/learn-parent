package com.shanks.learn.ui.mvc.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.shanks.learn.ui.mvc.domain.User;
import com.shanks.learn.ui.mvc.service.UserService;
import com.shanks.learn.ui.mvc.service.UserServiceRetrofit;

@Controller
@RequestMapping("/ui/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserServiceRetrofit userServiceRetrofit;

    @GetMapping(value = "")
    public String user() throws IOException {
        return "user/user_list";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<User> listUser() throws IOException {
        //return userService.listUser();
        log.info("UserController.listUser : /{}/{}/{}", "ui", "user", "list");
        return userServiceRetrofit.listUser().execute().body();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User user(@PathVariable Integer id) throws IOException {
        return userService.findById(id);
        //return userServiceRetrofit.findById(id).execute().body();
    }

    @PostMapping(value = "")
    @ResponseBody
    public User create(User user) {
        return userService.create(user);
        //return userServiceRetrofit.findById(id).execute().body();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) throws IOException {
        userService.delete(id);
        //return userServiceRetrofit.findById(id).execute().body();
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public void update(@PathVariable Integer id, User user) throws IOException {
        userService.update(id, user);
        //return userServiceRetrofit.findById(id).execute().body();
    }

}
package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    // 新增用户
    @PostMapping
    public Result add(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getId());
        System.out.println(user.getName());
        userService.save(user);
        return Result.success();
    }

    // 修改用户
    @PutMapping
    public Result update(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    // 根据id查询用户
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return Result.success(userService.findById(id));
    }

    //根据name查询
    @GetMapping("/name/{name}")
    public Result<User> findByName(@PathVariable String name) {
        return Result.success(userService.findByName(name));
    }

    // 查询所有用户
    @GetMapping
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    // 分页查询用户
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name) {
        return Result.success(userService.findPage(pageNum, pageSize, name));
    }

}

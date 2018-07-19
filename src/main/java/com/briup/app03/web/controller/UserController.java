package com.briup.app03.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app03.bean.User;
import com.briup.app03.service.IUserService;
import com.briup.app03.util.MsgResponse;

import io.swagger.annotations.Api;
@Api(description = "用户相关接口")
@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private IUserService  userService;

	@PostMapping("save User")
	public MsgResponse saveSchool( User  user) {
		try {

			 userService.save( user);
			return MsgResponse.success("用户表保存成功！！！", null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("update User")
	public MsgResponse updateSchool( User  user) {
		try {
			 userService.update( user);
			return MsgResponse.success("用户表更新成功！", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());

		}
	}

	// http://127.0.0.1:8080/user/findAlluser
	@GetMapping("findAllUser")
	public MsgResponse findAllUser() {
		try {
			// 调用service代码来进行
			List<User> list = userService.findAll();
			return MsgResponse.success("存在用户表", list);
		} catch (Exception e) {
			// 先打印错误信息让后台开发者知道问题所在
			// 报错返回错误信息。让前端开发者知道问题所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("delete")
	public MsgResponse delete(long id) {
		try {
			userService.delete(id);
			return MsgResponse.success("删除成功！", null);
			// 返回值为空 ，因为通过id删除用户对象不需要返回值

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findUserById")
	public MsgResponse findUserById(long id) {
		try {
			User user = userService.findById(id);

			return MsgResponse.success("查询成功！！",user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

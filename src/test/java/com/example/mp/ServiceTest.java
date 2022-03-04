package com.example.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mp.po.User;
import com.example.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void testGetOne() {
		LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
		wrapper.gt(User::getAge, 28);
		User one = userService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
		System.out.println(one);
	}
}

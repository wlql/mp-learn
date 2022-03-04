package com.example.mp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mp.mappers.UserMapper;
import com.example.mp.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testSelect() {
		List<User> list = userMapper.selectList(null);
		assertEquals(5, list.size());
		list.forEach(System.out::println);
	}

    @Test
	public void test3() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.select("id","name","email").likeRight("name","黄");
		List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
		maps.forEach(System.out::println);
	}
    
}

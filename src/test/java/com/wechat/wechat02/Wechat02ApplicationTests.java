package com.wechat.wechat02;


import com.wechat.dao.MemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Wechat02ApplicationTests {
	@Autowired
	private MemRepository memRepository;

	@Test
	public void contextLoads() {

	List<String> chat=memRepository.findDistinctChatroomOderbyIdDesc();
		System.out.println(chat);
	}

}

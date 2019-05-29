package com.osf.sp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osf.sp.auth.SHAEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpApplicationTests {
	
	@Test
	public void contextLoads() {
		String encodePwd = SHAEncoder.encode("1234");
		log.info("encodePwd=>{}",encodePwd);
		assertNotNull(encodePwd);
		assertEquals("49bdd45d97665a247e1f47b8e7764281efad52376ad3f0755a959430e7b5c929",encodePwd);
		assertTrue(SHAEncoder.match("1234", encodePwd));
	}

}

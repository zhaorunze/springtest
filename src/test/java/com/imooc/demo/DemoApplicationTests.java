package com.imooc.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;
import rx.functions.Action1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		Observable.interval(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
			@Override
			public void call(Long aLong) {
				LoggerFactory.getLogger(this.getClass()).info("==============" + aLong);
			}
		});

	}


}

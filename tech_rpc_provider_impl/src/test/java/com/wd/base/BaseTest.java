package com.wd.base;

import com.wd.tech.util.ContextLoader;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xyj on 2018/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = ContextLoader.class)
@Ignore
public class BaseTest {
}

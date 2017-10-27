package com.lardi;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * The base class for all Controller unit test classes
 */
@WebAppConfiguration
public class AbstractControllerUnitTest extends AbstractUnitTest {

    protected MockMvc mockMvc;

    protected  void setUp(){
//       mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}

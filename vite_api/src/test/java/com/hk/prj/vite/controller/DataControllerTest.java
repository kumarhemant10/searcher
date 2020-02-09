package com.hk.prj.vite.controller;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hk.prj.vite.AbstractTest;
import com.hk.prj.vite.constant.UrlConstants;

public class DataControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getIndices() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(UrlConstants.GET_INDICES).accept(MediaType.APPLICATION_JSON_VALUE))
        							.andExpect(status().isOk())
        							.andExpect(jsonPath("$",hasSize(greaterThan(1))));
       
    }

    @Test
    public void getColumns() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(UrlConstants.GET_COLUMNS, 1).accept(MediaType.APPLICATION_JSON_VALUE))
        						.andExpect(status().isOk())
        						.andExpect(jsonPath("$", hasSize(greaterThan(1))));

    }

    //@Test
    public void getData() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(UrlConstants.GET_DATA_BYTYPE, "Ecommere-data"))
        			.andExpect(status().isOk())
        			.andExpect(jsonPath("$", hasSize(greaterThan(1))));
        			
        				
    }
}

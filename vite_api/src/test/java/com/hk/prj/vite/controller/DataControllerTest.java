package com.hk.prj.vite.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
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
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(UrlConstants.GET_INDICES)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
       // String content = mvcResult.getResponse().getContentAsString();
        //List<String> indices = super.mapFromJson(content, List.class);
       // assertTrue(indices.size() > 0);
    }

    @Test
    public void getColumns() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(UrlConstants.GET_COLUMNS, 1)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        //List<String> indices = super.mapFromJson(content, List.class);
        // assertTrue(indices.size() > 0);
    }

    @Test
    public void getData() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(UrlConstants.GET_DATA_BYTYPE, "Shakespeare")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Object data = super.mapFromJson(content, Object.class);

         assertNotNull(data);
         System.out.print(data);
    }
}

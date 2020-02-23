/*
 * package com.hk.prj.vite.controller;
 * 
 * import static com.hk.prj.vite.constant.UrlConstants.COLUMNS; import static
 * com.hk.prj.vite.constant.UrlConstants.INDICES; import static
 * org.hamcrest.Matchers.greaterThan; import static
 * org.hamcrest.Matchers.hasSize; import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * import com.hk.prj.vite.AbstractTest;
 * 
 * public class DataControllerTest extends AbstractTest {
 * 
 * 
 * //@Test public void getIndices() throws Exception {
 * mvc.perform(MockMvcRequestBuilders.get(INDICES).accept(MediaType.
 * APPLICATION_JSON_VALUE)) .andExpect(status().isOk())
 * .andExpect(jsonPath("$",hasSize(greaterThan(1)))); }
 * 
 * //@Test public void getColumns() throws Exception {
 * mvc.perform(MockMvcRequestBuilders.get(COLUMNS,
 * 1).accept(MediaType.APPLICATION_JSON_VALUE)) .andExpect(status().isOk())
 * .andExpect(jsonPath("$", hasSize(greaterThan(1)))); }
 * 
 * 
 * }
 */
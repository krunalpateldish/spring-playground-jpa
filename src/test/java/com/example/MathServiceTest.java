package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer2 on 4/8/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathServiceTest {



    @Autowired
    private MockMvc mvc;

    @Test
    public void testForCricle() throws Exception {

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "5.32");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testForRectangle() throws Exception {

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "5.32")
                .param("height", "10");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andDo(print());

    }


    @Test
    public void testForInvalid() throws Exception {

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("width", "5.32")
                .param("height", "10");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andDo(print());

    }

}

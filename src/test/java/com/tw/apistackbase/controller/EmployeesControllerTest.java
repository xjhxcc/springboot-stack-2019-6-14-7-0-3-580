package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void should_return_employees_when_call_getAllEmployees() throws Exception {
        mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{\"id\":0,\"name\":\"aa\",\"age\":12,\"gender\":\"男\"}]"));

    }
    @Test
    public void should_return_string_when_call_addEmployee() throws Exception {
        String para="{\"id\":1,\"name\":\"bb\",\"age\":12,\"gender\":\"男\"}";
        mockMvc.perform(post("/employees").content(para)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")).andExpect(content().string(containsString("add employee success")));

    }

    @Test
    public void should_return_string_when_call_updateEmployee() throws Exception {
        String para="{\"name\":\"bb\",\"age\":20,\"gender\":\"男\"}";
        mockMvc.perform(put("/employees/1").content(para)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")).andExpect(content().string(containsString("update employee success")));

    }
    @Test
    public void should_return_string_when_call_deleteEmployee() throws Exception {
        mockMvc.perform(delete("/employees/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")).andExpect(content().string(containsString("delete employee success")));

    }



}
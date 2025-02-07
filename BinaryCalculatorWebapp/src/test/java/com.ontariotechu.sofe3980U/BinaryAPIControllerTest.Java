package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Tests the addition of two binary numbers using the API.
     * The expected result of 111 (7) + 1010 (10) in binary is 10001 (17).
     */
    @Test
    public void testAddition() throws Exception {
        mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    /**
     * Tests the JSON response when performing an addition operation.
     * The API should return a structured JSON object with operands, result, and operator.
     */
    @Test
    public void testAdditionWithJson() throws Exception {
        mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /**
     * Tests the multiplication of two binary numbers.
     * 110 (6) * 101 (5) should return 11110 (30) in binary.
     */
    @Test
    public void testMultiplication() throws Exception {
        mvc.perform(get("/multiply").param("operand1", "110").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(content().string("11110"));
    }

    /**
     * Tests the bitwise AND operation between two binary numbers.
     * 1101 (13) & 1011 (11) should return 1001 (9) in binary.
     */
    @Test
    public void testBitwiseAnd() throws Exception {
        mvc.perform(get("/and").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    /**
     * Tests the bitwise OR operation between two binary numbers.
     * 1101 (13) | 1011 (11) should return 1111 (15) in binary.
     */
    @Test
    public void testBitwiseOr() throws Exception {
        mvc.perform(get("/or").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
}

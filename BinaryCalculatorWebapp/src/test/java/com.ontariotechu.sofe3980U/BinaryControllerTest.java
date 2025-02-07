package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Tests if the default view of the application loads correctly.
     * It should return the "calculator" view with default empty operand values.
     */
    @Test
    public void testDefaultPageLoad() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    /**
     * Tests if a parameter is passed correctly to the calculator view.
     * The "operand1" value should be populated with "111" and focus should be set to true.
     */
    @Test
    public void testCalculatorWithOperandInput() throws Exception {
        mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    /**
     * Tests a binary addition operation through a POST request.
     * 111 (7) + 111 (7) should return 1110 (14) in binary.
     */
    @Test
    public void testBinaryAddition() throws Exception {
        mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    /**
     * Tests binary multiplication through a POST request.
     * 110 (6) * 101 (5) should return 11110 (30) in binary.
     */
    @Test
    public void testBinaryMultiplication() throws Exception {
        mvc.perform(post("/").param("operand1", "110").param("operator", "*").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"))
                .andExpect(model().attribute("operand1", "110"));
    }

    /**
     * Tests the bitwise AND operation via a POST request.
     * 1101 (13) & 1011 (11) should return 1001 (9) in binary.
     */
    @Test
    public void testBinaryBitwiseAnd() throws Exception {
        mvc.perform(post("/").param("operand1", "1101").param("operator", "&").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"))
                .andExpect(model().attribute("operand1", "1101"));
    }

    /**
     * Tests the bitwise OR operation via a POST request.
     * 1101 (13) | 1011 (11) should return 1111 (15) in binary.
     */
    @Test
    public void testBinaryBitwiseOr() throws Exception {
        mvc.perform(post("/").param("operand1", "1101").param("operator", "|").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"))
                .andExpect(model().attribute("operand1", "1101"));
    }
}

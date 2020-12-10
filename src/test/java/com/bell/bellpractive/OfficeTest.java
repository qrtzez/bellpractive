package com.bell.bellpractive;

import com.bell.bellpractive.model.Office;
import com.bell.bellpractive.view.OfficeView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@Transactional
public class OfficeTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getByIdOffice() throws Exception{
        this.mockMvc.perform(get("/api/office/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1));
    }

    @Test
    public void saveOfficeTest() throws Exception{
        OfficeView officeView = new OfficeView();
        officeView.setOrgId(1L);
        officeView.setName("SomeOffice");
        officeView.setAddress("SomeAddress");
        officeView.setPhone("8-963-851-12-65");
        officeView.setIsActive(true);

        this.mockMvc.perform(post("/api/office/save")
                .content(objectMapper.writeValueAsString(officeView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    public void updateOfficeTest() throws Exception{
        OfficeView officeView = new OfficeView();
        officeView.setId(1L);
        officeView.setName("SomeName");
        officeView.setName("someAddress");
        officeView.setPhone("8-963-851-12-65");
        officeView.setIsActive(true);

        this.mockMvc.perform(post("/api/office/update")
                .content(objectMapper.writeValueAsString(officeView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    public void listOfficeTest() throws Exception{
        OfficeView officeView = new OfficeView();
        officeView.setOrgId(1L);
        officeView.setName("Office Sokol");
        officeView.setPhone("8-925-234-12-15");
        officeView.setIsActive(true);

        this.mockMvc.perform(post("/api/office/list")
                .content(objectMapper.writeValueAsString(officeView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", Matchers.not(Matchers.empty())));
    }
}

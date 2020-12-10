package com.bell.bellpractive;

import com.bell.bellpractive.view.OrganizationView;
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
public class OrganizationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getByIdOrganization() throws Exception{
        this.mockMvc.perform(get("/api/organization/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1));
    }

    @Test
    public void saveOrganizationTest() throws Exception{
        OrganizationView organizationView = new OrganizationView();
        organizationView.setName("SomeName");
        organizationView.setFullName("SomeFullName");
        organizationView.setInn(11111L);
        organizationView.setKpp(2222L);
        organizationView.setAddress("SomeAddress");
        organizationView.setPhone("8-234-456-98-64");
        organizationView.setIsActive(true);

        this.mockMvc.perform(post("/api/organization/save")
                .content(objectMapper.writeValueAsString(organizationView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    public void updateOrganizationTest() throws Exception{
        OrganizationView organizationView = new OrganizationView();
        organizationView.setId(1L);
        organizationView.setName("SomeName");
        organizationView.setFullName("SomeFullName");
        organizationView.setInn(11111L);
        organizationView.setKpp(2222L);
        organizationView.setAddress("SomeAddress");
        organizationView.setPhone("8-234-456-98-64");
        organizationView.setIsActive(true);

        this.mockMvc.perform(post("/api/organization/update")
                .content(objectMapper.writeValueAsString(organizationView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    public void listOrganizationTest() throws Exception{
        OrganizationView organizationView = new OrganizationView();
        organizationView.setName("Sokol-ATS");
        organizationView.setInn(11111111L);
        organizationView.setIsActive(true);

        this.mockMvc.perform(post("/api/organization/list")
                .content(objectMapper.writeValueAsString(organizationView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", Matchers.not(Matchers.empty())));
    }


}

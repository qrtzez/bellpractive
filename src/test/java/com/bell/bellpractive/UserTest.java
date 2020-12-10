package com.bell.bellpractive;

import ch.qos.logback.core.boolex.Matcher;
import com.bell.bellpractive.view.UserListView;
import com.bell.bellpractive.view.UserUpdateView;
import com.bell.bellpractive.view.UserView;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@Transactional
public class UserTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getByIdTest() throws Exception{
       this.mockMvc.perform(get("/api/user/{id}", 1)
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.data.id").value(1));
    }

    @Test
    public void saveUserTest() throws Exception{
        UserView userView = new UserView();
        userView.setOfficeId(2L);
        userView.setFirstName("Жолобова");
        userView.setSecondName("Ольга");
        userView.setMiddleName("Андреевна");
        userView.setPosition("ОТК");
        userView.setPhone("8-521-333-22-15");
        userView.setDocName("Паспорт гражданина РФ");
        userView.setDocCode("21");
        userView.setDocNumber(55555L);
        userView.setDocDate("09-11-1996");
        userView.setCitizenshipCode("643");
        userView.setIsIdentified(true);
        this.mockMvc.perform(post("/api/user/save")
        .content(objectMapper.writeValueAsString(userView))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    public void updateUserTest() throws Exception{
        UserUpdateView userView = new UserUpdateView();
        userView.setId(1);
        userView.setOfficeId(2);
        userView.setFirstName("Жолобова");
        userView.setSecondName("Ольга");
        userView.setMiddleName("Андреевна");
        userView.setPosition("ОТК");
        userView.setPhone("8-521-333-22-15");
        userView.setDocName("Паспорт гражданина РФ");
        userView.setDocCode("21");
        userView.setDocNumber("55555");
        userView.setDocDate("09-11-1996");
        userView.setCitizenshipCode("643");
        userView.setIsIdentified(true);

        this.mockMvc.perform(post("/api/user/update")
                .content(objectMapper.writeValueAsString(userView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

    }

    @Test
    public void listUserTest() throws Exception{
        UserView userView = new UserView();
        userView.setOfficeId(1L);
        userView.setFirstName("Костя");
        userView.setSecondName("Аркатов");
        userView.setMiddleName("Николаевич");
        userView.setPosition("Developer");
        userView.setDocCode("21");
        userView.setCitizenshipCode("643");

        this.mockMvc.perform(post("/api/user/list")
                .content(objectMapper.writeValueAsString(userView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", Matchers.not(Matchers.empty())));
    }

}

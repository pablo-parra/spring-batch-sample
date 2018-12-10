package pab.par.dom.springbatchsample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto.JobInfo;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.logic.api.Studentmanagement;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBatchSampleApp.class)
@SpringBootTest
public class SpringBatchSampleAppTests {

  @Value("${heavy-job-simulation-time-sleep}")
  private int heavyJobSimulationTimeSleep;

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private Studentmanagement studentmanagement;

  private MockMvc mvc;

  private Gson gson = new GsonBuilder().create();

  private String startJobURL = "/startjob";

  private String startJobAsyncURL = "/startjobasync";

  @Before
  public void initialize() {

    this.mvc = MockMvcBuilders.webAppContextSetup(this.context)
        /* .addFilters(this.springSecurityFilterChain) */.build();
    this.studentmanagement.clearEnabledStudents();
  }

  @Test
  public void enabledStudentsTest() throws Exception {

    List<EnabledStudent> enabledStudentsBefore = this.studentmanagement.getAllEnabledStudents();

    assertThat(enabledStudentsBefore.size()).isEqualTo(0);

    MvcResult result = httpGet(this.startJobURL, new LinkedMultiValueMap<>()).andExpect(status().isAccepted())
        .andReturn();
    JobInfo response = this.gson.fromJson(result.getResponse().getContentAsString(), JobInfo.class);

    assertThat(response).isNotNull();

    List<EnabledStudent> enabledStudentsAfter = this.studentmanagement.getAllEnabledStudents();

    assertThat(enabledStudentsAfter.size()).isEqualTo(this.studentmanagement.getAllStudentsByEnabledStatus().size());
  }

  @Test
  public void enabledStudentsTestAsync() throws Exception {

    List<EnabledStudent> enabledStudentsBefore = this.studentmanagement.getAllEnabledStudents();

    assertThat(enabledStudentsBefore.size()).isEqualTo(0);

    MvcResult result = httpGet(this.startJobAsyncURL, new LinkedMultiValueMap<>()).andExpect(status().isAccepted())
        .andReturn();
    JobInfo response = this.gson.fromJson(result.getResponse().getContentAsString(), JobInfo.class);

    assertThat(response).isNotNull();

    // to allow the heave process simulation to finish before testing the results the thread is configured to sleep
    // double of the time expected to finish the process.
    // Is not the best solution but for the PoC purposes it does the trick.
    Thread.sleep(this.heavyJobSimulationTimeSleep * 2);

    List<EnabledStudent> enabledStudentsAfter = this.studentmanagement.getAllEnabledStudents();

    assertThat(enabledStudentsAfter.size()).isEqualTo(this.studentmanagement.getAllStudentsByEnabledStatus().size());
  }

  private ResultActions httpGet(String url, MultiValueMap<String, String> params) throws Exception {

    return this.mvc.perform(
        get(url).header("Accept", "application/json").header("Content-Type", "application/json").params(params));

  }

}

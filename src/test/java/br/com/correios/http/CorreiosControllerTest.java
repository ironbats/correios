package br.com.correios.http;

import br.com.correios.CorreiosApplication;
import br.com.correios.domain.CorreiosResult;
import br.com.correios.service.CorreiosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebAppConfiguration
@SpringBootTest(classes = CorreiosApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CorreiosControllerTest {


    private MockMvc mockMvc;

    @Spy
    @InjectMocks
    private CorreiosService correiosService;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void testConsultingCep() throws Exception {

        CorreiosResult cb = getBuild();
        Mockito.when(correiosService.getCorreiosResultByCep("03034000")).thenReturn(cb);

        mockMvc.perform(get("/cep/03034000")).
                andExpect(status().isOk());


    }

    private CorreiosResult getBuild() {
        return CorreiosResult.builder().
                address("Rua Araguaia").
                cep("03034000").
                complement("predio").
                UF("SP").
                city("São Paulo").
                neighborhood("Canindé").build();
    }

    @Test
    public void testFieldByFieldIntegrationCep() {

        CorreiosResult cb = getBuild();

        CorreiosResult result = correiosService.getCorreiosResultByCep("03034000");

        Assert.assertEquals(cb.getAddress(), result.getAddress());
        Assert.assertEquals(cb.getCep(), result.getCep());
        Assert.assertEquals(cb.getCity(), result.getCity());
        Assert.assertEquals(cb.getUF(), result.getUF());


    }

    @Test(expected = Exception.class)
    public void testErrorApiConsultCep(){
        CorreiosResult cb = getBuild();
        CorreiosResult result = correiosService.getCorreiosResultByCep("");
        Assert.assertEquals(cb.getAddress(), result.getAddress());
        Assert.assertEquals(cb.getCep(), result.getCep());
        Assert.assertEquals(cb.getCity(), result.getCity());
        Assert.assertEquals(cb.getUF(), result.getUF());
    }
}

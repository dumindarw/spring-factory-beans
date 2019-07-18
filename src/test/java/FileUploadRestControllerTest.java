import com.drw.fbeans.config.DocumentConfig;
import com.drw.fbeans.controllers.DocumentController;
import com.drw.fbeans.registry.DocumentServiceRegistry;
import com.drw.fbeans.services.CardeDocumentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DocumentConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FileUploadRestControllerTest {

    @Mock
    DocumentServiceRegistry documentServiceRegistry;
    @InjectMocks
    CardeDocumentService cardeDocumentService = new CardeDocumentService();
    private InputStream is;
    private MockMvc mockMvc;

    @Before
    public void init() throws FileNotFoundException {
        mockMvc = MockMvcBuilders.standaloneSetup(new DocumentController()).build();
        is = new FileInputStream(new File("src/test/resources/test.xlsx"));

    }

    @Test
    public void testUploadFile() throws Exception {

        //DocumentAdapterService<Object> service
        //      = documentServiceRegistry.getService("Cadre");


        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.xlsx", "multipart/form-data", is);

        String s = cardeDocumentService.upload(mockMultipartFile);



        /*MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/doc/upload/Cadre")
                .file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();*/
        //Assert.assertEquals(200, result.getResponse().getStatus());
        //Assert.assertNotNull(result.getResponse().getContentAsString());
        Assert.assertEquals("CadreDoc", s);
    }

}

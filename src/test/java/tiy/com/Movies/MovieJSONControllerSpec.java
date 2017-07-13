package tiy.com.Movies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.context.WebApplicationContext;
//import static org.junit.Assert.*;
//import org.mockito.Mock;
//import org.mockito.Spy; 
//import org.springframework.http.MediaType;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import static org.hamcrest.Matchers.is; 
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

/**
 * based on the example by @author Josh Long
 * available at https://spring.io/guides/tutorials/bookmarks/
 * also, stackoverflow was like a trainer to me
 * https://stackoverflow.com/questions/37458037/spring-restcontroller-junit-testing
 * and cheers to (C) Copyright 2014 Roy Russo who helped me get my second test working based on
 * his exciting work available at this site:
 * http://www.programcreek.com/java-api-examples/index.php?source_dir=spring-mvc-rest-mockito-master/src/test/java/org/royrusso/mvc/controller/UserControllerTest.java
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MovieMashup.class })

public class MovieJSONControllerSpec {
	

    @InjectMocks
    private MovieJSONController movieJSONController;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }
    
    
    @Test
    public void testGetAllMovies() throws Exception {
        this.mockMvc.perform(get("/api/getAllMovies")).andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void testGetMovie() throws Exception {

        int movieID = 1;
        mockMvc.perform(
        		get("/api/movie/" + movieID))
				.andExpect(content().contentType("application/json;charset=UTF-8"));
        		//.andExpect(jsonPath("$.title").value("Polyester"))
        		//.andExpect(MockMvcResultMatchers.status().isOk());
    }
    
//.andExpect(status().isOk()
//);
//.andExpect(jsonPath("$.title").value("Polyester"))
//);
//;
//mockMvc.perform(
//    get("/api/movie/" + movieID))
//    //.andExpect(MockMvcResultMatchers.status().isOk())
//    //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//    .andExpect(jsonPath("movie.title", is("Polyester")))
//    .andExpect(jsonPath("movie.genre", is(Genre.HORROR)));
//    //.andExpect(jsonPath("success", is(true)));
	  
}

package fr.sncf.d2d.colibri;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ColibriApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithUser("admin-5620bf5e9523fcbb3a5969c6")
	void paginationAsAdmin() throws Exception{
		this.mockMvc.perform(get("/colis")
			.queryParam("page", "0")
			.queryParam("itemsPerPage", "3")	
		).andExpectAll(
			status().isOk(),
			jsonPath("$.items", iterableWithSize(3)),
			jsonPath("$.total", is(1000))
		);
	}



}

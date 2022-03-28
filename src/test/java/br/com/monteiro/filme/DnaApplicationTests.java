package br.com.monteiro.filme;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;


@ActiveProfiles("test")
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DnaApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
    private int port;
	 
  /*
    @Autowired
    private MockMvc mockMvc;
	 
  @Test
	@Order(1)
	public void contextLoad() {
		assertNotNull(mockMvc);
	}


	@Test
	@Order(2)
	public void shouldReturnGetAllFilmes() throws Exception {
		this.mockMvc.perform(get("/api/filmes")).andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void shouldReturnGetFilme() throws Exception {
		this.mockMvc.perform(get("/api/filmes/1")).andExpect(status().isOk());
	}


	@Test
	@Order(4)
	public void shouldReturnCreateFilme() throws Exception {
		try {
			this.mockMvc.perform(post("/api/filmes").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(setObjectToCreate()))).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(5)
	public void shouldReturnRemoveFilme() throws Exception {
		this.mockMvc.perform(delete("/api/filmes/1")).andExpect(status().isNoContent());
	}

	@Test
	@Order(6)
	public void shouldReturnValidRemoveFilme() throws Exception {
		this.mockMvc.perform(get("/api/filme/1")).andExpect(status().isNotFound());
	}

	@Test
	@Order(7)
	public void shouldReturnUpdateFilme() throws Exception {

		this.mockMvc.perform(put("/api/filmes/5").contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(new ObjectMapper().writeValueAsString(setObjectToUpdate()))).andExpect(status().isOk());
	}
	
	@Test
	@Order(8)
	public void shouldReturnPremios() throws Exception {

		this.mockMvc.perform(get("/api/premios")).andExpect(status().isOk());	

	}

	private Filme setObjectToCreate() throws Exception {

		Filme filme = new Filme();
		filme.setYear(2022);
		filme.setTitle("Omicro");
		filme.setStudios("studios monteiro filmes");
		filme.setProducers("monteiro");
		filme.setWinner("yes");

		return filme;
	}

	private Filme setObjectToUpdate() throws Exception {
		Filme filme = new Filme();
		filme.setYear(2022);
		filme.setTitle("Omicro");
		filme.setStudios("studios monteiro filmes");
		filme.setProducers("monteiro");
		filme.setWinner("");

		return filme;
	}*/

}

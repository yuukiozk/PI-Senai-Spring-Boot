package com.rh.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//https://www.baeldung.com/spring-boot-testing
//https://spring.io/guides/gs/testing-web/
//https://www.javainuse.com/spring/springboot_testcases


@DisplayName("Titulo do teste")
@TestInstance(Lifecycle.PER_CLASS)
public class TesteAppRh extends AppApplicationTests {

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		System.out.println("executa antes da classe all");	
	}
	
	
	@AfterAll
	public void tearDown()
	{
		System.out.println("executa depois da classe all");
		mockMvc=null;
	}
	
	@DisplayName("Teste das Rotas : ╯°□°）╯ 😱")
	@Test
	final void testCaminhos() throws Exception {
		System.out.println("executando teste de Rotas");
		mockMvc.perform(get("/")).andExpect(status().isOk());
		
		// não suportado POST
		//mockMvc.perform(post("/"))	.andExpect(status().isOk());
		
		// rotas para testar "/home" , 	"/funcionario" , "/lista" , 
		// "/deletarFuncionario/{id}" 
		// "/editarFuncionario/{id}" POST
		// "funcionario/listafuncionario"
		// "redirect:/lista"
		
		//get
		mockMvc.perform(get("/home")).andExpect(status().isOk());
		mockMvc.perform(get("/funcionario")).andExpect(status().isOk());
		mockMvc.perform(get("/lista")).andExpect(status().isOk());
		mockMvc.perform(get("/deletarFuncionario/1")).andExpect(status().isOk());
		mockMvc.perform(get("/editarFuncionario/1")).andExpect(status().isOk());
		//post
		mockMvc.perform(post("/home")).andExpect(status().isOk());
		mockMvc.perform(post("/funcionario")).andExpect(status().isOk());
		mockMvc.perform(post("/lista")).andExpect(status().isOk());
		mockMvc.perform(post("/deletarFuncionario/1")).andExpect(status().isOk());
		mockMvc.perform(post("/editarFuncionario/1")).andExpect(status().isOk());
		
		
		/*
		 * assertAll( "lendo", () -> assertEquals(4, new Execucao().soma(3, 1),
		 * " soma de 3+1=4 "), () -> assertEquals("java", "JAVA".toLowerCase(),
		 * " exemplo de minusculo ") );
		 */
		 
	}
	
	/*
	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
				.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));

	}
	*/

}

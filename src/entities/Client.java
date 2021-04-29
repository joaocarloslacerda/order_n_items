package entities;

import java.util.Date;

public class Client {

	//criando os atributos
	private String name;
	private String email;
	private Date birthDate;
	
	//construtor padr�o, criando em mem�ria um objeto do tipo Client 
	public Client() {
	}
	
	//construtor personalizado, criando em mem�ria um objeto do tipo Client com os tr�s par�metros passados por valor
	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	//retornando o nome do cliente
	public String getName() {
		return name;
	}
	
	//setando um novo nome para o cliente no atributo name
	public void setName(String name) {
		this.name = name;
	}
	
	//retornando o email do cliente
	public String getEmail() {
		return email;
	}
	
	//setando um novo email para o cliente no atributo email
	public void setEmail(String email) {
		this.email = email;
	}
	
	//retornando a data de nascimento do cliente
	public Date getBirthDate() {
		return birthDate;
	}
	
	//adicionando a data de nascimento do cliente no atributo birthDate
	public void addBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}

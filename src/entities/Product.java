package entities;

public class Product {

	//criando os atributos
	private String name;
	private Double price;
	
	//construtor padr�o, criando objeto do tipo product em mem�ria
	public Product() {
	}
	
	//construtor personalizado, criando objeto do tipo product em mem�ria com os dois par�metros passados por valor
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	//retornando o nome do procuto
	public String getName() {
		return name;
	}
	
	//setando um novo nome no atributo name
	public void setName(String name) {
		this.name = name;
	}
	
	//retornando o pre�o do produto
	public Double getPrice() {
		return price;
	}
	
	//setando um novo valor de um determinado produto no atributo price
	public void setPrice(Double price) {
		this.price = price;
	}
	
}

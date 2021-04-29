package entities;

public class OrderItem {

	//criando os atributos
	private Integer quantity;
	private Double price;
	
	//criando o objeto product que faz a composi��o entre a classe OrderItem e a Product
	private Product product;
	
	//construtor padr�o, criando o objeto do tipo Order em memoria
	public OrderItem() {
	}
	
	//construtor personalizado, criando o objeto do tipo Order em mem�ria j� com os par�metros passados por valor
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		//price recebe o m�todo subTotal passando o pre�o unit�rio e a quantidade, este m�todo � utilizado para calcular o pre�o unit�rio de um determinado item * a quantidade solicitada
		this.price = subTotal(price, quantity);
		this.product = product;
	}
	
	//retornando a quantidade de itens
	public Integer getQuantity() {
		return quantity;
	}
	
	//setando uma quantidade de um determinado item
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	//retornando o valor total do item adicionado na lista de itens
	public Double getPrice() {
		return price;
	}
	
	//retornando o produto
	public Product getProduct() {
		return product;
	}
	
	//setando um novo produto
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//m�todo que faz o calculo do subTotal de um determinado item e retornando ao m�todo setPrice
	public Double subTotal(Double price, Integer quantity) {
		
		//calculando e retornando o valor total de um item, fazendo o seu valor unit�rio multiplicado pela a quantidade dele
		return price * quantity;
	}
}

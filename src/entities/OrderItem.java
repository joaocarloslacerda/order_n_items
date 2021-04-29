package entities;

public class OrderItem {

	//criando os atributos
	private Integer quantity;
	private Double price;
	
	//criando o objeto product que faz a composição entre a classe OrderItem e a Product
	private Product product;
	
	//construtor padrão, criando o objeto do tipo Order em memoria
	public OrderItem() {
	}
	
	//construtor personalizado, criando o objeto do tipo Order em memória já com os parâmetros passados por valor
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		//price recebe o método subTotal passando o preço unitário e a quantidade, este método é utilizado para calcular o preço unitário de um determinado item * a quantidade solicitada
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
	
	//método que faz o calculo do subTotal de um determinado item e retornando ao método setPrice
	public Double subTotal(Double price, Integer quantity) {
		
		//calculando e retornando o valor total de um item, fazendo o seu valor unitário multiplicado pela a quantidade dele
		return price * quantity;
	}
}

package entities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	//criando os atributos
	private Date moment;
	private OrderStatus status;
	
	//criando a composição entre a classe Order e a OrderItem
	private List<OrderItem> items = new ArrayList<>(); //objeto lista items do tipo OrderItem
	
	//criando objeto com a composição entre a classe order e a classe client
	private Client client;

	//criando formatação para a entrada de dados de um tipo date
	SimpleDateFormat sdf1 = new SimpleDateFormat("(dd/MM/yyyy)");
	//criando formatação para a entrada de dados de um tipo date
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	//construtor padrão, criando objeto em memória
	public Order() {
	}
	
	//construtor personalizado, criando objeto em memória com os parâmetros passados por valor
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	//retornando o momento em que foi realizado o pedido
	public Date getMoment() {
		return moment;
	}
	
	//setando no atributo moment o momento em que foi criado o pedido
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	//retornando o status de andamento do pedido
	public OrderStatus getStatus() {
		return status;
	}
	
	//setando um status de andamento referente ao pedido realizado
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	//retornando o client
	public Client getClient() {
		return client;
	}
	
	//setando um client
	public void setClient(Client client) {
		this.client = client;
	}
	
	//adicionando um item na lista de items, passando este item por parâmetro por valor
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	//removendo um item da lista de items, passando este item por parâmetro por valor
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	//calculando o preço total do pedido que está sendo realizado
	public Double total(List<OrderItem> items) {
		
		Double sum = 0.0;
		//percorre a lista de items
		for(OrderItem c : items) {
			//atribui no aatributo sum a soma do preço de cada produto
			sum = sum + c.getPrice();
		}
		//retorna a soma do preço de cada produto
		return sum;
	}
	
	public String toString() {
		//criando objeto sb do tipo StringBuilder, o StringBuilder é utilizado quando tem que ser montada uma string que é muito grande
		StringBuilder sb = new StringBuilder();
		//o sb do tipo StringBuilder permite adicionar no final da string
		
		sb.append("\nORDER SUMMARY: \n"); 
		sb.append("Order moment: ");
		//adiciona o momento em que o pedido foi realizado  no final do objeto do tipo StringBuilder
		sb.append(sdf2.format(moment));
		sb.append("\nOrder status: ");
		//adicionando o status atual do pedido
		sb.append(status);
		sb.append("\nClient: ");
		//adiciona o nome do cliente no final do objeto do tipo StringBuilder
		sb.append(client.getName() + " ");
		//adiciona a data de nascimento do cliente no final do objeto do tipo StringBuilder
		sb.append(sdf1.format(client.getBirthDate()));
		//adiciona o email do cliente no final do objeto do tipo StringBuilder
		sb.append(" - " + client.getEmail());
		sb.append("\nOrder items:\n");
		//adiciona os items do pedido no final do objeto do tipo StringBuilder
		for(OrderItem c : items) {
			//passando o nome do produto
			sb.append(c.getProduct().getName());
			//adicionando o preço unitário
			sb.append(" $" + c.getProduct().getPrice() + ", ");
			//adicionando a quantidade solicitada do produto
			sb.append("Quantity: " + c.getQuantity() + ", ");
			//adicionando o subtotal(soma do preço da quantidade de cada item )
			sb.append("Subtotal: $" + String.format("%.2f", c.getPrice()) + "\n");
		}
		//adicionando o total do valor que o pedido chegou, ele é calculado somando o preço da quantidade de cada item, e depois a soma de cada um destes resultados juntos
		sb.append("Total Price: $" + String.format("%.2f", total(items))); //com o String.format o valor está sendo printado com duas casas depois da virgula
		//retornando objeto do tipo StringBuilder já com todas as informações recebidas
		return sb.toString();
	}
}

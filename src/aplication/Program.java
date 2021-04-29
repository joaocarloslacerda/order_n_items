package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		//alterando a localidade para uma diferente da configurada por padr�o no computador
		Locale.setDefault(Locale.US);
		//criando objeto do tipo scanner que servir� para fazer a entrada de dados conforme associa��o dele com a entrada de dados padr�o(teclado)
		Scanner sc = new Scanner(System.in);
		
		//criando formata��o para a entrada de dados de um tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		//entrada dos dados referente ao cliente
		System.out.println("Enter cliente data: \n");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("\nEmail: ");
		String email = sc.nextLine();
		System.out.println("\nBirth date (DD/MM/YYYY): ");
		//a data de nascimento do cliente j� � armazenada com a formata��o criada com o objeto sdf do tipo SimpleDataFormat
		Date birthDate = sdf.parse(sc.next());
		
		//entrando com os dados do pediddo
		System.out.println("\nEnter order data: \n");
		//limpando buffer do objeto sc do tipo Scanner, sem a limpeza ele pula a entrada de dados referente ao status do pedido
		sc.nextLine();
		//informando o status do pedido
		System.out.println("Status: ");
		//passando o status do pedido para o atributo status do tipo String
		String status = sc.nextLine();
		//criando objeto listItem do tipo Order recebendo um new Order passando por par�metro o moment e o status convertido do tipo String para Enum, al�m de tamb�m um new Client passando por par�metro name, email e birthDate
		Order listItem = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		//questionando quantos items v�o ter no pedido
		System.out.println("\n\nHow many items to this order? ");
		//guardando a quantidade de items informada
		Integer quantiItems = sc.nextInt();
		
		//adicionando items no pedido
		for(int i=0; i<quantiItems; i++) {
			//entradas de dados referente a um determinado item
			System.out.printf("\nEnter #%d item data:", i+1);
			System.out.println("\nProduct Name: ");
			//limpando buffer do objeto sc do tipo Scanner, pois como ele recebeu um inteiro anteriormente, sem a limpeza ele pula a entrada de dados para o nome do produto
			sc.nextLine();
			//armazenando o nome do produto
			String productName = sc.nextLine();
			System.out.println("\nProduct price: ");
			//armazenando o pre�o do produto
			Double productPrice = sc.nextDouble();
			System.out.println("\nQuantity: ");
			//armazenando a quantidade que ser� comprada deste produto
			Integer productQuantity = sc.nextInt();
			//criando o objeto item do tipo OrdemItem que recebe um OrderItem passando os par�metros para o construtor personalizado na classe OrderItem e cria o ojeto em mem�ria, al�m de um dos par�metros sem um new Product que passa os par�metros para o construtor personalizado na classe Product
			OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			//atrav�s do objeto listItem chamando o m�todo addItem localizado na classe Order, e passando por par�metro um novo item do tipo OrderItem
			listItem.addItem(item);
		}
		//aqui est� sendo chamado o m�todo toString contido na classe Order, este m�todo tem a formata��o dos dados para printar
		System.out.println(listItem);
	//encerrando objeto sc do tipo Scanner
	sc.close();
	}
}

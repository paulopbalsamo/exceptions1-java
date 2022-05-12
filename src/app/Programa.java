package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto: ");
		int numero = scanner.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date checkinDate = simpleDateFormat.parse(scanner.next());
		System.out.print("Data de saida (dd/MM/yyyy): ");
		Date checkoutDate = simpleDateFormat.parse(scanner.next());

		if (!checkoutDate.after(checkinDate)) {
			System.out.println("Erro na Reserva!*** Data de Checkout deve ser maior que data de Entrada***");
		} else {
			Reserva reserva = new Reserva(numero, checkinDate, checkoutDate);
			System.out.println("Reserva: " + reserva.toString());

			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkinDate = simpleDateFormat.parse(scanner.next());
			System.out.print("Data de saida (dd/MM/yyyy): ");
			checkoutDate = simpleDateFormat.parse(scanner.next());

			Date nowDate = new Date();
			if (checkinDate.before(nowDate) || checkoutDate.before(checkoutDate)) {
				System.out.println("ERRO NAS DATAS DA RESERVA, MENOR QUE DATA ATUAL");
			} else if (!checkoutDate.after(checkinDate)) {
				System.out.println("Erro na Reserva!**** Data de Entrada maior que de Saida****!");
			} else {

				reserva.atualizaDatas(checkinDate, checkoutDate);
				System.out.println("Reserva: " + reserva.toString());
			}
		}

		scanner.close();
	}

}

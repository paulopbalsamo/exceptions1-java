package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numero = scanner.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date checkinDate = simpleDateFormat.parse(scanner.next());
			System.out.print("Data de saida (dd/MM/yyyy): ");
			Date checkoutDate = simpleDateFormat.parse(scanner.next());

			Reserva reserva = new Reserva(numero, checkinDate, checkoutDate);
			System.out.println("Reserva: " + reserva.toString());

			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkinDate = simpleDateFormat.parse(scanner.next());
			System.out.print("Data de saida (dd/MM/yyyy): ");
			checkoutDate = simpleDateFormat.parse(scanner.next());

			reserva.atualizaDatas(checkinDate, checkoutDate);
			System.out.println("Reserva: " + reserva.toString());
		} catch (ParseException e) {
			System.out.println("Formato da data invalido!");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("ERRO INESPERADO!");
		}

		scanner.close();
	}

}

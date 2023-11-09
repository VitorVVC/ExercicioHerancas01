package Application;

import Entities.Employee;
import Entities.OutsorcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> listaFunc = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        String resposta;
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Employee #" + (i + 1) + " data: ");
            System.out.print("Outsourced (y/n)? ");
            resposta = sc.nextLine();

            while (true) {
                if (resposta.equalsIgnoreCase("y")) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Hours: ");
                    Integer hours = sc.nextInt();
                    System.out.print("Value per hour: ");
                    Double valuePerHour = sc.nextDouble();
                    System.out.print("Additional charge: ");
                    Double additionalCharge = sc.nextDouble();
                    OutsorcedEmployee outEmp = new OutsorcedEmployee(name, hours, valuePerHour, additionalCharge);
                    listaFunc.add(outEmp);
                    sc.nextLine();
                    break;
                } else if (resposta.equalsIgnoreCase("n")) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Hours: ");
                    Integer hours = sc.nextInt();
                    System.out.print("Value per hour: ");
                    Double valuePerHour = sc.nextDouble();
                    Employee emp = new Employee(name, hours, valuePerHour);
                    listaFunc.add(emp);
                    sc.nextLine();
                    break;
                } else {
                    System.out.print("Resposta não reconhecida, tente novamente (y/n) ");
                    resposta = sc.nextLine();
                }
            }

        }
        System.out.println("PAYMENTS: ");
        for (Employee printPay : listaFunc) {
            System.out.print(printPay.getName() + " - $ " + printPay.payment() + "\n");
        }

    }
}
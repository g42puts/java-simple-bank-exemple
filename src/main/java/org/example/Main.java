package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private User user;
    private Bank bank;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.user = null;
        this.bank = null;
    }

    public void printWelcomeMessage() {
        System.out.println("Bem-vindo ao Banco Unopar!");
    }

    public void getUserInfo() {
        while (true) {
            System.out.println("Digite suas informações de usuário:");

            List<String> userData = this.getUserData();

            System.out.println("Confirme suas informações:");
            System.out.println("Nome: " + userData.get(0));
            System.out.println("Sobrenome: " + userData.get(1));
            System.out.println("CPF: " + userData.get(2));
            System.out.println("As informações estão corretas? (S/N)");

            String confirmation = scanner.nextLine().trim();
            if (confirmation.equalsIgnoreCase("S")) {
                this.user = new User(userData.get(0), userData.get(1), userData.get(2));
                this.bank = new Bank(user);
                break;
            }
        }
    }

    private List<String> getUserData() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        return Arrays.asList(name, lastName, cpf);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n### Menu Principal ###");
            System.out.println("1. Menu do Usuário");
            System.out.println("2. Menu do Banco");
            System.out.println("3. Sair do aplicativo");

            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    this.showUserMenu();
                    break;
                case 2:
                    this.showBankMenu();
                    break;
                case 3:
                    System.out.println("Saindo do aplicativo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("\n### Menu do Usuário ###");
            System.out.println("1. Trocar nome");
            System.out.println("2. Trocar sobrenome");
            System.out.println("3. Voltar para o Menu Principal");

            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Novo nome: ");
                    String newName = scanner.nextLine();
                    this.user.setName(newName);
                    System.out.println("Nome alterado com sucesso!");
                    break;
                case 2:
                    System.out.print("Novo sobrenome: ");
                    String newLastName = scanner.nextLine();
                    this.user.setLastName(newLastName);
                    System.out.println("Sobrenome alterado com sucesso!");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void showBankMenu() {
        while (true) {
            System.out.println("\n### Menu do Banco ###");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Voltar para o Menu Principal");

            System.out.print("Escolha uma opção: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    this.bank.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser retirado: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    this.bank.withdrawn(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Saldo atual: " + this.bank.getBalance());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printWelcomeMessage();
        main.getUserInfo();
        main.showMainMenu();
        main.scanner.close();
    }
}

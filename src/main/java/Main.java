import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar;

        do {
            System.out.println("Informe a população do país A:");
            int populacaoA = validarInteiroPositivo(scanner);
            System.out.println("Informe a taxa de crescimento anual do país A (em decimal, por exemplo, 0.03 para 3%):");
            double taxaCrescimentoA = validarTaxa(scanner);

            System.out.println("Informe a população do país B:");
            int populacaoB = validarInteiroPositivo(scanner);
            System.out.println("Informe a taxa de crescimento anual do país B (em decimal, por exemplo, 0.015 para 1.5%):");
            double taxaCrescimentoB = validarTaxa(scanner);

            int anos = 0;
            while (populacaoA <= populacaoB) {
                populacaoA += (int) (populacaoA * taxaCrescimentoA);
                populacaoB += (int) (populacaoB * taxaCrescimentoB);
                anos++;
            }

            System.out.println("Levará " + anos + " anos para a população do país A ultrapassar a população do país B.");

            System.out.println("Deseja realizar outra comparação? (S/N)");
            continuar = scanner.next().charAt(0);
        } while (continuar == 'S' || continuar == 's');

        scanner.close();
    }

    public static int validarInteiroPositivo(Scanner scanner) {
        int valor;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Valor inválido. Digite um número inteiro positivo:");
                scanner.next();
            }
            valor = scanner.nextInt();
        } while (valor <= 0);

        return valor;
    }

    public static double validarTaxa(Scanner scanner) {
        double valor;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido. Digite um número decimal (exemplo: 0.03 para 3%):");
                scanner.next();
            }
            valor = scanner.nextDouble();
        } while (valor <= 0);

        return valor;
    }
}

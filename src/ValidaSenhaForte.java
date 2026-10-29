import java.util.Scanner;

   
public class ValidaSenhaForte {

    // Metodo que avalia a senha e retorna uma mensagem
    public static String avaliarSenha(String senha) {

        // Regra 1: verificar o tamanho minimo
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no minimo 8 caracteres.";
        }

        // Regra 2: verificar se existe pelo menos um numero
        boolean temNumero = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isDigit(caractere)) {
                temNumero = true;
            }
        }

        if (!temNumero) {
            return "DICA: Adicione pelo menos um numero a sua senha.";
        }

        // Regra 3: bloquear senhas obvias
        String[] senhasObvias = {
            "12345678",
            "senha123",
            "admin123"
        };

        for (int i = 0; i < senhasObvias.length; i++) {
            if (senha.equals(senhasObvias[i])) {
                return "ALERTA: Esta senha e muito comum ou obvia.";
            }
        }

        // Regra 4: verificar se existe pelo menos uma letra maiuscula
        boolean temMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isUpperCase(caractere)) {
                temMaiuscula = true;
            }
        }

        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiuscula a sua senha.";
        }

        // Se todas as regras forem atendidas
        return "SUCESSO: Sua senha passou nos criterios basicos!";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String senha;
        String resultado;

        // Repetir as tentativas ate a aprovacao
        do {
            System.out.print("Digite uma senha ficticia: ");
            senha = scanner.nextLine();

            resultado = avaliarSenha(senha);

            System.out.println(resultado);
            System.out.println();

        } while (!resultado.equals(
            "SUCESSO: Sua senha passou nos criterios basicos!"
        ));

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
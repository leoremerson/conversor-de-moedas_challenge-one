import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoConversoes {
    private static final String conversoes = "conversões.txt";

    public static void registrar(String texto) {
        Path caminho = Paths.get(conversoes);
        int contador = 1;
        if (Files.exists(caminho)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(conversoes))) {
                while (reader.readLine() != null) {
                    contador++;
                }
            } catch (IOException e) {
                System.out.println("Erro ao contar as conversões: " + e.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(conversoes, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String dataHora = LocalDateTime.now().format(formatter);
            String linha = String.format("%d [%s] %s\n", contador, dataHora, texto);
            writer.write(linha);
        } catch (IOException e) {
            System.out.println("Erro ao registrar histórico: " + e.getMessage());
        }
    }

    public static void mostrar() {
        System.out.println("\n==== Histórico de Conversões ====");
        Path caminho = Paths.get(conversoes);

        if (!Files.exists(caminho)) {
            System.out.println("Nenhuma conversão registrada ainda.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(conversoes))) {
            String linha;
            boolean vazio = true;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                vazio = false;
            }
            if (vazio) {
                System.out.println("O histórico está vazio no momento.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o histórico: " + e.getMessage());
        }
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ecreva o nome do arquivo: ");
        String arquivo = scanner.nextLine();

        System.out.print("Qual vértice?: ");
        int numero = scanner.nextInt();

        try {
            Grafo grafo = carregarGrafo(arquivo);

            int grauEntrada = grafo.getGrauEntrada(numero);
            int grauSaida = grafo.getGrauSaida(numero);
            List<Integer> conjuntoSucessores = grafo.getConjuntoSucessores(numero);
            List<Integer> conjuntoPredecessores = grafo.getConjuntoPredecessores(numero);

            System.out.println("Grau de Entrada: " + grauEntrada);
            System.out.println("Grau de Saida: " + grauSaida);
            System.out.println("Conjunto Sucessores: " + conjuntoSucessores);
            System.out.println("Conjunto Predecessores: " + conjuntoPredecessores);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Grafo carregarGrafo(String arquivo) throws IOException {
        Path path = Paths.get("./data/", arquivo + ".txt").normalize();
        Pattern pattern = Pattern.compile("\\d+");
        Grafo grafo = null;
        boolean check = true;

        for (String line : Files.readAllLines(path)) {
            Matcher matcher = pattern.matcher(line);
            List<Integer> list = new LinkedList<>();

            while (matcher.find()) {
                String group = matcher.group();
                Integer num = Integer.valueOf(group);
                list.add(num);
            }

            if (check) {
                grafo = new Grafo(list.get(0));
                check = false;
            } else {
                grafo.addAresta(list.get(0), list.get(1));
            }
        }

        return grafo;
    }
}
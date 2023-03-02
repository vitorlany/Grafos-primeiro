import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Grafo {
    private int[][] array;
    private int numVertices;
    private int numArestas;
    private int proximaAresta = 1;

    Grafo(int vertices, int arestas) {
        this.numVertices = vertices;
        this.numArestas = arestas;
        this.array = new int[vertices + 1][arestas + 1];
    }

    public void addAresta(int sai, int entra) {
        this.array[sai][this.proximaAresta] = -1;
        this.array[entra][this.proximaAresta] = 1;
        this.proximaAresta++;
    }

    public int getGrauEntrada(int vertice) {
        return getGrau(vertice, 1);
    }

    public int getGrauSaida(int vertice) {
        return getGrau(vertice, -1);
    }

    private int getGrau(int vertice, int num) {
        int count = 0;
        for (int i = 1; i <= this.numArestas; i++) {
            int integer = this.array[vertice][i];
            if (integer == num) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getConjuntoSucessores(int vertice) {
        return getConjunto(vertice, -1);
    }

    public List<Integer> getConjuntoPredecessores(int vertice) {
        return getConjunto(vertice, 1);
    }

    private List<Integer> getConjunto(int vertice, int num) {
        List<Integer> conjunto = new LinkedList<>();
        for (int i = 1; i <= this.numArestas; i++) {
            int valor = this.array[vertice][i];
            if (valor == num) {
                for (int j = 1; j <= this.numVertices; j++) {
                    int pesquisa = this.array[j][i];
                    if (pesquisa == (num * (-1))) {
                        conjunto.add(j);
                    }
                }
            }
        }
        return conjunto;
    }

    @Override
    public String toString() {
        return "Grafo{" +
                "array=" + Arrays.deepToString(array) +
                '}';
    }
}

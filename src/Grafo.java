import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    private final List<LinkedList<Integer>> grafoSucessores = new ArrayList<>();
    private final List<LinkedList<Integer>> grafoPredecessores = new ArrayList<>();

    Grafo(int vertices) {
        for (int i = 0; i <= vertices; i++) {
            grafoSucessores.add(new LinkedList<>());
            grafoPredecessores.add(new LinkedList<>());
        }
    }

    public void addAresta(int sai, int entra) {
        this.grafoSucessores.get(sai).add(entra);
        this.grafoPredecessores.get(entra).add(sai);
    }

    public int getGrauEntrada(int vertice) {
        return grafoPredecessores.get(vertice).size();
    }

    public int getGrauSaida(int vertice) {
        return grafoSucessores.get(vertice).size();
    }

    public List<Integer> getConjuntoSucessores(int vertice) {
        return grafoSucessores.get(vertice);
    }

    public List<Integer> getConjuntoPredecessores(int vertice) {
        return grafoPredecessores.get(vertice);
    }
}

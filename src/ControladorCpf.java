package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ControladorCpf {

    // HashSet: impede CPFs duplicados no sistema
    private Set<String> cpfsCadastrados = new HashSet<>();

    // ArrayList: guarda historico de bloqueios na ordem em que aconteceram
    private List<String> cpfsBloqueados = new ArrayList<>();

    // HashMap: acesso rapido ao nome do titular pelo CPF
    private Map<String, String> cpfParaNome = new HashMap<>();

    // cadastra um CPF novo - retorna false se ja existir
    public boolean registrar(String cpf, String nome) {
        if (cpf == null || cpf.isBlank()) {
            System.out.println("CPF invalido: nulo ou vazio.");
            return false;
        }

        // add() do HashSet ja rejeita duplicata e retorna false
        boolean inserido = cpfsCadastrados.add(cpf);

        if (!inserido) {
            System.out.println("CPF " + cpf + " ja esta cadastrado no sistema.");
            return false;
        }

        cpfParaNome.put(cpf, nome);
        System.out.println("CPF " + cpf + " registrado para: " + nome);
        return true;
    }

    // verifica existencia no Set - O(1), sem precisar percorrer lista
    public boolean existe(String cpf) {
        return cpfsCadastrados.contains(cpf);
    }

    // busca nome pelo CPF usando o Map como indice
    public String buscarNome(String cpf) {
        return cpfParaNome.get(cpf);
    }

    // move o CPF para a lista de bloqueados sem remove-lo do sistema
    public void bloquear(String cpf) {
        if (!cpfsCadastrados.contains(cpf)) {
            System.out.println("CPF " + cpf + " nao encontrado para bloquear.");
            return;
        }

        if (cpfsBloqueados.contains(cpf)) {
            System.out.println("CPF " + cpf + " ja esta bloqueado.");
            return;
        }

        // ArrayList.add() preserva a ordem cronologica dos bloqueios
        cpfsBloqueados.add(cpf);
        System.out.println("CPF " + cpf + " bloqueado.");
    }

    // remove o CPF da lista de bloqueados - remove() por valor no ArrayList
    public void desbloquear(String cpf) {
        boolean removido = cpfsBloqueados.remove(cpf);

        if (removido) {
            System.out.println("CPF " + cpf + " desbloqueado.");
        } else {
            System.out.println("CPF " + cpf + " nao estava bloqueado.");
        }
    }

    public boolean estaBloqueado(String cpf) {
        return cpfsBloqueados.contains(cpf);
    }

    // apaga o CPF das tres estruturas de uma vez
    public void remover(String cpf) {
        if (!cpfsCadastrados.contains(cpf)) {
            System.out.println("CPF " + cpf + " nao encontrado.");
            return;
        }

        cpfsCadastrados.remove(cpf);
        cpfsBloqueados.remove(cpf);
        cpfParaNome.remove(cpf);

        System.out.println("CPF " + cpf + " removido do sistema.");
    }

    // retorna copia para nao expor o Set interno
    public List<String> listarCadastrados() {
        return new ArrayList<>(cpfsCadastrados);
    }

    // retorna copia do historico de bloqueios
    public List<String> listarBloqueados() {
        return new ArrayList<>(cpfsBloqueados);
    }

    // percorre o Map para exibir CPF + nome + status de cada titular
    public void exibirTodos() {
        if (cpfsCadastrados.isEmpty()) {
            System.out.println("Nenhum CPF cadastrado.");
            return;
        }

        System.out.println("\n--- CPFs Cadastrados ---");

        for (Map.Entry<String, String> entrada : cpfParaNome.entrySet()) {
            String cpf    = entrada.getKey();
            String nome   = entrada.getValue();
            String status = cpfsBloqueados.contains(cpf) ? "[BLOQUEADO]" : "[ATIVO]";
            System.out.println("CPF: " + cpf + " | Nome: " + nome + " " + status);
        }
    }

    // usa o ArrayList para mostrar bloqueios em ordem cronologica
    public void exibirHistoricoBloqueios() {
        if (cpfsBloqueados.isEmpty()) {
            System.out.println("Nenhum CPF bloqueado ate o momento.");
            return;
        }

        System.out.println("\n--- Historico de Bloqueios ---");

        for (int i = 0; i < cpfsBloqueados.size(); i++) {
            String cpf  = cpfsBloqueados.get(i);
            String nome = cpfParaNome.get(cpf);
            System.out.println((i + 1) + ". CPF: " + cpf + " | Nome: " + nome);
        }
    }

    public void exibirResumo() {
        System.out.println("\n--- Resumo ControladorCpf ---");
        System.out.println("Total cadastrados : " + cpfsCadastrados.size());
        System.out.println("Total bloqueados  : " + cpfsBloqueados.size());
        System.out.println("Total ativos      : " + (cpfsCadastrados.size() - cpfsBloqueados.size()));
    }
}
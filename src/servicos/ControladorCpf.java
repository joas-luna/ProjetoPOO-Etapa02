package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ControladorCpf {

    private Set<String> cpfsCadastrados = new HashSet<>();
    private List<String> cpfsBloqueados = new ArrayList<>();
    private Map<String, String> cpfParaNome = new HashMap<>();

    public boolean registrar(String cpf, String nome) {
        if (cpf == null || cpf.isBlank()) {
            System.out.println("CPF invalido: nulo ou vazio.");
            return false;
        }

        boolean inserido = cpfsCadastrados.add(cpf);

        if (!inserido) {
            System.out.println("CPF " + cpf + " ja esta cadastrado no sistema.");
            return false;
        }

        cpfParaNome.put(cpf, nome);
        System.out.println("CPF " + cpf + " registrado para: " + nome);
        return true;
    }

    public boolean existe(String cpf) {
        return cpfsCadastrados.contains(cpf);
    }

    public String buscarNome(String cpf) {
        return cpfParaNome.get(cpf);
    }

}
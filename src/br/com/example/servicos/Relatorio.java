package br.com.example.servicos;

import java.util.List;

import br.com.example.dtos.Consulta;
import br.com.example.servicos.abstratos.Pagamento;

public class Relatorio {

    // mostra todas as consultas

    public static void gerarRelatorio(List<Consulta> consultas, int totalConsultas,
                                      List<Atendimento> atendimentos, int totalAtendimentos) {
        System.out.println("\n=== RELATORIO GERAL ===");
        for (int i = 0; i < totalConsultas; i++) {
            System.out.println(consultas.get(i).exibirResumo());
            // verifica se tem diagnostico
            String diag = buscarDiagnostico(i, atendimentos, totalAtendimentos);
            if (!diag.equals("")) {
                System.out.println("  Diagnostico: " + diag);
            }
            System.out.println("---");
        }
    }

    // filtra por profissional

    public static void gerarRelatorio(List<Consulta> consultas, int totalConsultas,
                                      List<Atendimento> atendimentos, int totalAtendimentos,
                                      String nomeProfissional) {
        System.out.println("\n=== RELATORIO - " + nomeProfissional + " ===");
        boolean achou = false;
        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getNomeDoProfissional().equals(nomeProfissional)) {
                System.out.println(consultas.get(i).exibirResumo());
                String diag = buscarDiagnostico(i, atendimentos, totalAtendimentos);
                if (!diag.equals("")) {
                    System.out.println("  Diagnostico: " + diag);
                }
                System.out.println("---");
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhuma consulta encontrada para esse profissional.");
        }
    }

    // filtra por periodo (data inicio e fim)

    public static void gerarRelatorio(List<Consulta> consultas, int totalConsultas,
                                      List<Atendimento> atendimentos, int totalAtendimentos,
                                      String dataInicio, String dataFim) {
        System.out.println("\n=== RELATORIO - " + dataInicio + " a " + dataFim + " ===");
        for (int i = 0; i < totalConsultas; i++) {
            if (estaNoIntervalo(consultas.get(i).getData(), dataInicio, dataFim)) {
                System.out.println(consultas.get(i).exibirResumo());
                String diag = buscarDiagnostico(i, atendimentos, totalAtendimentos);
                if (!diag.equals("")) {
                    System.out.println("  Diagnostico: " + diag);
                }
                System.out.println("---");
            }
        }
    }

    // resumo financeiro do dia
    public static void gerarResumoFinanceiro(List<Consulta> consultas, int totalConsultas,
                                             List<Pagamento> pagamentos, int totalPagamentos,
                                             List<Double> multas, int totalMultas) {
        int realizadas = 0;
        int canceladas = 0;
        double totalFaturado = 0;
        double totalEmMultas = 0;

        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getStatus().equals("realizada")) realizadas++;
            if (consultas.get(i).getStatus().equals("cancelada")) canceladas++;
        }

        for (int i = 0; i < totalPagamentos; i++) {
            totalFaturado = totalFaturado + pagamentos.get(i).getValorFinal();
        }

        for (int i = 0; i < totalMultas; i++) {
            totalEmMultas = totalEmMultas + multas.get(i);
        }

        System.out.println("\n=== RESUMO FINANCEIRO ===");
        System.out.println("Atendimentos realizados: " + realizadas);
        System.out.println("Total faturado: R$" + Math.round(totalFaturado * 100.0) / 100.0);
        System.out.println("Cancelamentos: " + canceladas);
        System.out.println("Total em multas: R$" + Math.round(totalEmMultas * 100.0) / 100.0);
    }

    // busca diagnostico de um atendimento pelo indice da consulta
   
    public static String buscarDiagnostico(int indiceConsulta, List<Atendimento> atendimentos, int total) {
        for (int i = 0; i < total; i++) {
            if (atendimentos.get(i).getIndiceConsulta() == indiceConsulta) {
                return atendimentos.get(i).getDiagnostico();
            }
        }
        return "";
    }

    // compara datas convertendo pra numero inteiro (AAAAMMDD)
    public static boolean estaNoIntervalo(String data, String inicio, String fim) {
        int valorData = converterDataParaNumero(data);
        int valorInicio = converterDataParaNumero(inicio);
        int valorFim = converterDataParaNumero(fim);
        return valorData >= valorInicio && valorData <= valorFim;
    }

    // converte DD/MM/AAAA pra um numero tipo 20260519 pra poder comparar
    private static int converterDataParaNumero(String data) {
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));
        return ano * 10000 + mes * 100 + dia;
    }
}

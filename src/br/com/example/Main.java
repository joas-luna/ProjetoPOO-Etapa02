package br.com.example;

import java.util.NoSuchElementException;

import br.com.example.servicos.ClinicaServico;
import br.com.example.utilitarios.Entrada;
import br.com.example.utilitarios.Saida;


public class Main {
    public static void main(String[] args) {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("=== CLINICA VIDAPLENA ===");
            System.out.println("1 - Pacientes");
            System.out.println("2 - Profissionais");
            System.out.println("3 - Consultas");
            System.out.println("4 - Atendimentos");
            System.out.println("5 - Pagamentos (interditado)");
            System.out.println("6 - Relatorios (interditado)");
            System.out.println("0/Enter - Sair");
            System.out.print("Escolha: ");

            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                break;
            } catch(NoSuchElementException e) {
                break;
            }
    
            switch (op) {
                case 1: menuPacientes(); break;
                case 2: menuProfissionais(); break;
                case 3: menuConsultas(); break;
                case 4: menuAtendimentos(); break;
                case 5: System.out.println("\n\nInterditado momentaneamente...\n\n\n"); /* menuPagamentos(); */break;
                case 6: System.out.println("\n\nInterditado momentaneamente...\n\n\n"); /* menuRelatorios(); */break;
                case 0: break;
                default: System.out.println("Opção invalida!"); break;
            }
        }

        System.out.println("Sistema encerrado.");
        Entrada.sc.close();
    }

    public static void menuPacientes() {
        int op = -1;
        
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- PACIENTES ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Complementar cadastro");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Listar todos");
            System.out.println("5 - Desativar");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }
    
            switch (op) {
                case 1: ClinicaServico.cadastrarPaciente(); break;
                case 2: ClinicaServico.complementarPaciente(); break;
                case 3: ClinicaServico.buscarPaciente(); break;
                case 4: ClinicaServico.listarPacientes(); break;
                case 5: ClinicaServico.desativarPaciente(); break;
                case 0: break;
                default: break;
            }
        }
    }

    public static void menuProfissionais() {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- PROFISSIONAIS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar cadastro");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Filtrar por especialidade");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }

            switch (op) {
                // case 1: cadastrarProfissional(); break;
                case 2: ClinicaServico.atualizarProfissional(); break;
                case 3: ClinicaServico.listarProfissionais(); break;
                case 4: ClinicaServico.filtrarProfissionais(); break;
                case 0: break;
                default: break;
            }
        }
    }

    public static void menuConsultas() {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- CONSULTAS ---");
            System.out.println("1 - Agendar (escolher profissional)");
            System.out.println("2 - Agendar (busca por especialidade)");
            System.out.println("3 - Cancelar");
            System.out.println("4 - Remarcar");
            System.out.println("5 - Listar todas");
            System.out.println("6 - Buscar por CPF");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }

            switch (op) {
                case 1: ClinicaServico.agendarComProfissional(); break;
                case 2: ClinicaServico.agendarPorEspecialidade(); break;
                case 3: ClinicaServico.cancelarConsulta(); break;
                case 4: ClinicaServico.remarcarConsulta(); break;
                case 5: ClinicaServico.listarConsultas(); break;
                case 6: ClinicaServico.buscarConsultasPorPaciente(); break;
                case 0: break;
                default: break;
            }
        }
    }

    public static void menuAtendimentos() {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- ATENDIMENTOS ---");
            System.out.println("1 - Registrar atendimento");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }

            if (op == 1) ClinicaServico.registrarAtendimento();
        }
    }

    public static void menuPagamentos() {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- PAGAMENTOS ---");
            System.out.println("1 - Pagamento direto");
            System.out.println("2 - Pagamento automatico");
            System.out.println("3 - Listar pagamentos");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }

            switch (op) {
                case 1: ClinicaServico.pagamentoDireto(); break;
                case 2: ClinicaServico.pagamentoAutomatico(); break;
                case 3: ClinicaServico.listarPagamentos(); break;
                case 0: break;
                default: break;
            }
        }
    }

    public static void menuRelatorios() {
        int op = -1;
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- RELATORIOS ---");
            System.out.println("1 - Geral");
            System.out.println("2 - Por profissional");
            System.out.println("3 - Por periodo");
            System.out.println("4 - Resumo financeiro");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            try {
                op = Integer.parseInt(Entrada.sc.nextLine());
            } catch(NumberFormatException e) {
                return;
            } catch(NoSuchElementException e) {
                return;
            }

            ClinicaServico.gerarRelatorio(op);
        }
    }
}

package br.com.example;

import br.com.example.servicos.ClinicaServico;
import br.com.example.utilitarios.Entrada;
import br.com.example.utilitarios.Saida;


public class Main {
    public static void main(String[] args) {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
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

            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[10G"));
                escolhaInvalida = false;
            }

            
            opStr = Entrada.removerEspacos(Entrada.confirmar(Entrada.input(), 10));

            if(opStr.equals("")) {
                break;
            }
            
            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }
            
            switch (op) {
                case 1: menuPacientes(); break;
                case 2: menuProfissionais(); break;
                case 3: menuConsultas(); break;
                case 4: menuAtendimentos(); break;
                case 5: menuPagamentos(); break;
                case 6: menuRelatorios(); break;
                case 0: break;
                default: escolhaInvalida = true; break;
            }
        }

        Saida.limparTerminal();
        System.out.println(Saida.ciano("""
            .___________________________________________________________________________________________.
            |                                                                                           |
            |                                                                                           |

            = <-> = <-> = <-> = <-> = <-> = <-> = SISTEMA ENCERRADO = <-> = <-> = <-> = <-> = <-> = <-> =
            
            |                                                                                           |
            |                                                                                           |
            *-------------------------------------------------------------------------------------------*"""));
        Entrada.sc.close();
    }

    public static void menuPacientes() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
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
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
                escolhaInvalida = false;
            }

            opStr = Entrada.removerEspacos(Entrada.input());
            
            if(opStr.equals("")) {
                return;
            }

            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }

            switch (op) {
                case 1: ClinicaServico.cadastrarPaciente(); break;
                case 2: ClinicaServico.complementarPaciente(); break;
                case 3: ClinicaServico.buscarPaciente(); break;
                case 4: ClinicaServico.listarPacientes(); break;
                case 5: ClinicaServico.desativarPaciente(); break;
                case 0: break;
                default: escolhaInvalida = true; break;
            }
        }
    }

    public static void menuProfissionais() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- PROFISSIONAIS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar cadastro");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Filtrar por especialidade");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
            }

            escolhaInvalida = false;

            opStr = Entrada.removerEspacos(Entrada.input());

            if(opStr.equals("")) {
                return;
            }

            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }


            switch (op) {
                // case 1: ClinicaServico.cadastrarProfissional(); break;
                case 2: ClinicaServico.atualizarProfissional(); break;
                case 3: ClinicaServico.listarProfissionais(); break;
                case 4: ClinicaServico.filtrarProfissionais(); break;
                case 0: break;
                default: escolhaInvalida = true; break;
            }
        }
    }

    public static void menuConsultas() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
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
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
            }

            escolhaInvalida = false;

            opStr = Entrada.removerEspacos(Entrada.input());

            if(opStr.equals("")) {
                return;
            }

            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }


            switch (op) {
                case 1: ClinicaServico.agendarComProfissional(); break;
                case 2: ClinicaServico.agendarPorEspecialidade(); break;
                case 3: ClinicaServico.cancelarConsulta(); break;
                case 4: ClinicaServico.remarcarConsulta(); break;
                case 5: ClinicaServico.listarConsultas(); break;
                case 6: ClinicaServico.buscarConsultasPorPaciente(); return;
                case 0: break;
                default: escolhaInvalida = true; break;
            }
        }
    }

    public static void menuAtendimentos() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- ATENDIMENTOS ---");
            System.out.println("1 - Registrar atendimento");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
            }

            escolhaInvalida = false;

            opStr = Entrada.removerEspacos(Entrada.input());

            if(opStr.equals("")) {
                return;
            }

            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }


            if (op == 1) ClinicaServico.registrarAtendimento();
        }
    }

    public static void menuPagamentos() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- PAGAMENTOS ---");
            System.out.println("1 - Pagamento direto");
            System.out.println("2 - Pagamento automatico");
            System.out.println("3 - Listar pagamentos");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
            }

            escolhaInvalida = false;

            opStr = Entrada.removerEspacos(Entrada.input());

            if(opStr.equals("")) {
                return;
            }

            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                escolhaInvalida = true;
                continue;
            }


            switch (op) {
                case 1: ClinicaServico.pagamentoDireto(); break;
                case 2: ClinicaServico.pagamentoAutomatico(); break;
                case 3: ClinicaServico.listarPagamentos(); break;
                case 0: break;
                default: escolhaInvalida = true; break;
            }
        }
    }

    public static void menuRelatorios() {
        Integer op = -1;
        boolean escolhaInvalida = false;
        String opStr;
        
        while (op != 0) {
            Saida.limparTerminal();

            System.out.println("--- RELATORIOS ---");
            System.out.println("1 - Geral");
            System.out.println("2 - Por profissional");
            System.out.println("3 - Por periodo");
            System.out.println("4 - Resumo financeiro");
            System.out.println("0/Enter - Voltar");
            System.out.print("Opcao: ");
            
            if(escolhaInvalida) {
                System.out.print(Saida.vermelho("\t\t\tInválido!\r\u001B[8G"));
            }

            opStr = Entrada.removerEspacos(Entrada.input());

            if(opStr.equals("")) {
                return;
            }
            
            try {
                op = Integer.parseInt(opStr);
            } catch(NumberFormatException e) {
                continue;
                }

            escolhaInvalida = ClinicaServico.gerarRelatorio(op);
        }
    }
}  

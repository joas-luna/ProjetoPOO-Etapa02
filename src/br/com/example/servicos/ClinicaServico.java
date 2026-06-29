package br.com.example.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.example.dtos.Consulta;
import br.com.example.dtos.Convenio;
import br.com.example.entidades.Paciente;
import br.com.example.entidades.abstratos.Profissional;
import br.com.example.servicos.abstratos.Pagamento;
import br.com.example.utilitarios.Entrada;
import br.com.example.validadores.Data;

public class ClinicaServico {
    private static Scanner sc = Entrada.sc;

    private static List<Paciente> pacientes = new ArrayList<>();
    private static int totalPacientes = 0;

    private static List<Profissional> profissionais = new ArrayList<>();
    private static int totalProfissionais = 0;

    private static List<Consulta> consultas = new ArrayList<>();
    private static int totalConsultas = 0;

    private static List<Atendimento> atendimentos = new ArrayList<>();
    private static int totalAtendimentos = 0;

    private static List<Pagamento> pagamentos = new ArrayList<>();
    private static int totalPagamentos = 0;

    private static List<Double> multas = new ArrayList<>();
    private static int totalMultas = 0;

    
    // ---- PACIENTES ----

    public static void cadastrarPaciente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
    
        // verifica se ja existe
        if (buscarIndicePaciente(cpf) != -1) {
            System.out.println("CPF ja cadastrado!");
            return;
        }
    
        System.out.print("Tipo (1-Minimo / 2-Com idade e tel / 3-Completo): ");
        int tipo = Integer.parseInt(sc.nextLine());
        String dataDeNascimento;
    
        if (tipo == 1) {
            pacientes.add(new Paciente(nome, cpf));
        } else if (tipo == 2) {
            System.out.print("Data de nascimento: ");
            dataDeNascimento = Data.validarData(sc.nextLine(), sc);

            System.out.print("Telefone: ");
            String tel = sc.nextLine();
            
            pacientes.add(new Paciente(nome, cpf, dataDeNascimento, tel));
        } else {
            System.out.print("Data de nascimento: ");
            dataDeNascimento = Data.validarData(sc.nextLine(), sc);
            
            System.out.print("Telefone: ");
            String tel = sc.nextLine();
            
            System.out.print("Convenio: ");
            Convenio conv = new Convenio(sc.nextLine());
            
            pacientes.add(new Paciente(nome, cpf, dataDeNascimento, tel, conv));
        }

        totalPacientes++;
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public static void complementarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        int idx = buscarIndicePaciente(cpf);
        if (idx == -1) {
            System.out.println("Paciente nao encontrado.");
            return;
        }
    
        System.out.print("Vai informar convenio? (1-Nao / 2-Sim): ");
        int tipo = Integer.parseInt(sc.nextLine());
    
        System.out.print("Data de nascimento: ");
        String dataDeNascimento = Data.validarData(sc.nextLine(), sc);

        System.out.print("Telefone: ");
        String tel = sc.nextLine();
    
        if (tipo == 1) {
            pacientes.get(idx).complementar(dataDeNascimento, tel);
        } else {
            System.out.print("Convenio: ");
            Convenio conv = new Convenio(sc.nextLine());

            pacientes.get(idx).complementar(dataDeNascimento, tel, conv);
        }

        System.out.println("Cadastro atualizado!");
    }

    public static void buscarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        int idx = buscarIndicePaciente(cpf);
        if (idx == -1) {
            System.out.println("Paciente nao encontrado.");
        } else {
            System.out.println(pacientes.get(idx).exibirResumo());
        }
    }

    public static void listarPacientes() {
        if (totalPacientes == 0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        for (int i = 0; i < totalPacientes; i++) {
            System.out.println(pacientes.get(i).exibirResumo());
        }
    }

    public static void desativarPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        int idx = buscarIndicePaciente(cpf);
        if (idx == -1) {
            System.out.println("Paciente nao encontrado.");
        } else {
            pacientes.get(idx).desativar();
            System.out.println("Paciente desativado.");
        }
    }

    public static int buscarIndicePaciente(String cpf) {
        for (int i = 0; i < totalPacientes; i++) {
            if (pacientes.get(i).getCpf().equals(cpf)) return i;
        }
        return -1;
    }

    // ---- PROFISSIONAIS ----

    // public static void cadastrarProfissional() {
    //     System.out.print("Nome: ");
    //     String nome = sc.nextLine();
    //     System.out.print("Especialidade (clinica geral/fisioterapia/psicologia/nutricao): ");
    //     String esp = sc.nextLine().trim().toLowerCase();
    // 
    //     if (!Profissional.especialidadeValida(esp)) {
    //         System.out.println("Especialidade invalida!");
    //         return;
    //     }
    // 
    //     System.out.print("Tipo (1-Minimo / 2-Com registro e valor / 3-Completo): ");
    //     int tipo = Integer.parseInt(sc.nextLine());
    // 
    //     if (tipo == 1) {
    //         profissionais.add(new Profissional(nome, "", esp));
    //     } else if (tipo == 2) {
    //         System.out.print("Registro: ");
    //         String reg = sc.nextLine();
// 
    //         System.out.print("Valor consulta: ");
    //         double valor = Double.parseDouble(sc.nextLine());
// 
    //         profissionais.add(new Profissional(nome, "", esp, valor, reg));
    //     } else {
    //         System.out.print("Registro: ");
    //         String reg = sc.nextLine();
// 
    //         System.out.print("Valor consulta: ");
    //         double valor = Double.parseDouble(sc.nextLine());
            // 
    //         System.out.print("Quantos dias atende? ");
    //         int qtd = Integer.parseInt(sc.nextLine());
// 
    //         if (qtd > 7) qtd = 7;
            // 
    //         List<String> dias = new String[7];
            // 
    //         for (int i = 0; i < qtd; i++) {
    //             System.out.print("Dia " + (i+1) + ": ");
    //             dias[i] = sc.nextLine();
    //         }
            // 
    //         profissionais.add(new Profissional(nome, "", esp, valor, reg, dias, qtd));
    //     }
    //     totalProfissionais++;
    //     System.out.println("Profissional cadastrado!");
    // }

    public static void atualizarProfissional() {
        System.out.print("Nome do profissional: ");
        String nome = sc.nextLine();
        int idx = buscarIndiceProfissional(nome);
        if (idx == -1) {
            System.out.println("Profissional nao encontrado.");
            return;
        }

        System.out.print("Vai informar dias? (1-Nao / 2-Sim): ");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.print("Registro: ");
        String reg = sc.nextLine();
        System.out.print("Valor consulta: ");
        double valor = Double.parseDouble(sc.nextLine());

        if (tipo == 1) {
            profissionais.get(idx).atualizar(reg, valor);
        } else {
            System.out.print("Quantos dias? ");
            int qtd = Integer.parseInt(sc.nextLine());
            List<String> dias = new ArrayList<>();
            for (int i = 0; i < qtd; i++) {
                System.out.print("Dia " + (i+1) + ": ");
                dias.set(i, sc.nextLine());
            }
            profissionais.get(idx).atualizar(reg, valor, dias, qtd);
        }
        System.out.println("Profissional atualizado!");
    }

    public static void listarProfissionais() {
        if (totalProfissionais == 0) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }
        for (int i = 0; i < totalProfissionais; i++) {
            System.out.println(profissionais.get(i).exibirResumo());
        }
    }

    public static void filtrarProfissionais() {
        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        boolean achou = false;
        for (int i = 0; i < totalProfissionais; i++) {
            if (profissionais.get(i).getEspecialidade().equalsIgnoreCase(esp)) {
                System.out.println(profissionais.get(i).exibirResumo());
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum profissional com essa especialidade.");
    }

    public static int buscarIndiceProfissional(String nome) {
        for (int i = 0; i < totalProfissionais; i++) {
            if (profissionais.get(i).getNome().equals(nome)) return i;
        }
        return -1;
    }

    // ---- CONSULTAS ----

    public static void agendarComProfissional() {
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        int idxPac = buscarIndicePaciente(cpf);
        if (idxPac == -1) {
            System.out.println("Paciente nao encontrado.");
            return;
        }
        if (!pacientes.get(idxPac).ativo) {
            System.out.println("Paciente inativo. Nao e possivel agendar.");
            return;
        }

        System.out.print("Nome do profissional: ");
        String nomeProf = sc.nextLine();
        int idxProf = buscarIndiceProfissional(nomeProf);
        if (idxProf == -1) {
            System.out.println("Profissional nao encontrado.");
            return;
        }
        if (profissionais.get(idxProf).getValorConsulta() == 0) {
            System.out.println("Profissional sem valor definido. Nao pode agendar.");
            return;
        }

        System.out.print("Data (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horario (HH:MM): ");
        String horario = sc.nextLine();

        // verifica dia da semana
        String diaSemana = descobrirDiaSemana(data);
        if (!profissionais.get(idxProf).atendeNoDia(diaSemana)) {
            System.out.println("Profissional nao atende nesse dia.");
            return;
        }

        // verifica conflito
        if (temConflito(nomeProf, data, horario)) {
            System.out.println("Horario ocupado!");
            String sugestao = sugerirHorario(nomeProf, data);
            if (sugestao.equals("")) {
                System.out.println("Nenhum horario disponivel nesse dia.");
                return;
            }
            System.out.println("Sugestao: " + sugestao);
            System.out.print("Aceita? (1-Sim / 2-Nao): ");
            int aceita = Integer.parseInt(sc.nextLine());
            if (aceita == 1) {
                horario = sugestao;
            } else {
                return;
            }
        }

        System.out.print("Informar tipo? (1-Nao / 2-Sim): ");
        int infoTipo = Integer.parseInt(sc.nextLine());

        if (infoTipo == 1) {
            consultas.set(infoTipo, new Consulta(cpf, nomeProf, data, horario));
        } else {
            System.out.print("Tipo (inicial/retorno/avaliacao): ");
            String tipo = sc.nextLine();
            consultas.set(infoTipo, new Consulta(cpf, nomeProf, data, horario, tipo));
        }
        totalConsultas++;
        System.out.println("Consulta agendada com sucesso!");
    }

    public static void agendarPorEspecialidade() {
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        int idxPac = buscarIndicePaciente(cpf);
        if (idxPac == -1) {
            System.out.println("Paciente nao encontrado.");
            return;
        }
        if (!pacientes.get(idxPac).ativo) {
            System.out.println("Paciente inativo. Nao e possivel agendar.");
            return;
        }

        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horario (HH:MM): ");
        String horario = sc.nextLine();

        String diaSemana = descobrirDiaSemana(data);

        // procura profissional disponivel
        int idxProf = -1;
        for (int i = 0; i < totalProfissionais; i++) {
            if (profissionais.get(i).getEspecialidade().equals(esp)
                    && profissionais.get(i).getValorConsulta() > 0
                    && profissionais.get(i).atendeNoDia(diaSemana)
                    && !temConflito(profissionais.get(i).getNome(), data, horario)) {
                idxProf = i;
                break;
            }
        }

        if (idxProf == -1) {
            System.out.println("Nenhum profissional disponivel.");
            return;
        }

        consultas.set(idxPac, new Consulta(cpf, profissionais.get(idxProf).getNome(), data, horario));
        totalConsultas++;
        System.out.println("Consulta agendada com " + profissionais.get(idxProf).getNome() + "!");
    }

    public static void cancelarConsulta() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horario (HH:MM): ");
        String horario = sc.nextLine();

        // localiza a consulta
        int idx = -1;
        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getCPF().equals(cpf) && consultas.get(i).getData().equals(data)
                    && consultas.get(i).getHorario().equals(horario)) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Consulta nao encontrada.");
            return;
        }
        if (consultas.get(idx).getStatus().equals("realizada")) {
            System.out.println("Consulta ja realizada. Nao pode cancelar.");
            return;
        }
        if (consultas.get(idx).getStatus().equals("cancelada")) {
            System.out.println("Consulta ja cancelada.");
            return;
        }

        // calculo da multa
        System.out.print("Horario atual (HH:MM): ");
        String horaAtual = sc.nextLine();

        int hConsulta = Integer.parseInt(horario.substring(0, 2));
        int hAgora = Integer.parseInt(horaAtual.substring(0, 2));
        int diff = hConsulta - hAgora;

        if (diff < 2) {
            System.out.println("Multa de R$50.00 aplicada!");
            multas.set(totalMultas, 50.0);
            totalMultas++;
        }

        System.out.print("Informar motivo? (1-Nao / 2-Sim): ");
        int temMotivo = Integer.parseInt(sc.nextLine());

        if (temMotivo == 1) {
            consultas.get(idx).cancelar();
        } else {
            System.out.print("Motivo: ");
            String motivo = sc.nextLine();
            String msg = consultas.get(idx).cancelar(motivo);
            System.out.println(msg);
        }
        System.out.println("Consulta cancelada.");
    }

    public static void remarcarConsulta() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data original (DD/MM/AAAA): ");
        String dataOrig = sc.nextLine();
        System.out.print("Horario original (HH:MM): ");
        String horarioOrig = sc.nextLine();

        int idx = -1;
        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getCPF().equals(cpf) && consultas.get(i).getData().equals(dataOrig)
                    && consultas.get(i).getHorario().equals(horarioOrig)
                    && consultas.get(i).getStatus().equals("agendada")) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Consulta agendada nao encontrada.");
            return;
        }

        System.out.print("Apenas trocar horario no mesmo dia? (1-Sim / 2-Nao): ");
        int tipo = Integer.parseInt(sc.nextLine());

        String novaData;
        String novoHorario;

        if (tipo == 1) {
            novaData = dataOrig;
            System.out.print("Novo horario: ");
            novoHorario = sc.nextLine();
        } else {
            System.out.print("Nova data (DD/MM/AAAA): ");
            novaData = sc.nextLine();
            System.out.print("Novo horario (HH:MM): ");
            novoHorario = sc.nextLine();
        }

        String nomeProf = consultas.get(idx).getNomeDoProfissional();
        int idxProf = buscarIndiceProfissional(nomeProf);
        if (idxProf == -1) {
            System.out.println("Profissional associado nao encontrado.");
            return;
        }

        // se mudou de dia, verifica se prof atende
        if (tipo == 2) {
            String dia = descobrirDiaSemana(novaData);
            if (!profissionais.get(idxProf).atendeNoDia(dia)) {
                System.out.println("Profissional nao atende nesse dia.");
                return;
            }
        }

        if (temConflito(nomeProf, novaData, novoHorario)) {
            System.out.println("Horario ocupado. Nao foi possivel remarcar.");
            return;
        }

        consultas.get(idx).remarcar();
        consultas.set(idx, new Consulta(cpf, nomeProf, novaData, novoHorario, consultas.get(idx).getTipo()));
        totalConsultas++;
        System.out.println("Consulta remarcada com sucesso!");
    }

    public static void listarConsultas() {
        if (totalConsultas == 0) {
            System.out.println("Nenhuma consulta.");
            return;
        }
        for (int i = 0; i < totalConsultas; i++) {
            System.out.println("[" + i + "] " + consultas.get(i).exibirResumo());
        }
    }

    public static void buscarConsultasPorPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        boolean achou = false;
        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getCPF().equals(cpf)) {
                System.out.println("[" + i + "] " + consultas.get(i).exibirResumo());
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma consulta encontrada.");
    }

    // verifica se ja tem consulta nesse horario com esse profissional
    public static boolean temConflito(String nomeProf, String data, String horario) {
        for (int i = 0; i < totalConsultas; i++) {
            if (consultas.get(i).getNomeDoProfissional().equals(nomeProf)
                    && consultas.get(i).getData().equals(data)
                    && consultas.get(i).getHorario().equals(horario)
                    && consultas.get(i).getStatus().equals("agendada")) {
                return true;
            }
        }
        return false;
    }

    // sugere proximo horario livre (de hora em hora, 08h ate 18h)
    public static String sugerirHorario(String nomeProf, String data) {
        for (int h = 8; h <= 18; h++) {
            String teste;
            if (h < 10) {
                teste = "0" + h + ":00";
            } else {
                teste = h + ":00";
            }
            if (!temConflito(nomeProf, data, teste)) {
                return teste;
            }
        }
        return "";
    }

    // descobre dia da semana a partir da data
    // operação opcional
    public static String descobrirDiaSemana(String data) {
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6, 10));

        // ajuste pra formula funcionar com janeiro e fevereiro
        if (mes < 3) {
            mes = mes + 12;
            ano = ano - 1;
        }

        int k = ano % 100;
        int j = ano / 100;

        // formula de zeller
        int resultado = (dia + (13 * (mes + 1)) / 5 + k + k/4 + j/4 - 2*j) % 7;
        if (resultado < 0) resultado = resultado + 7;

        // 0=sabado, 1=domingo, 2=segunda...
        final String[] nomes = {"sabado", "domingo", "segunda", "terca", "quarta", "quinta", "sexta"};
        //System.out.println("DEBUG dia semana: " + nomes[resultado]); // pra testar
        return nomes[resultado];
    }

    // ---- ATENDIMENTOS ----

    public static void registrarAtendimento() {
        System.out.print("Indice da consulta: ");
        int idxConsulta = Integer.parseInt(sc.nextLine());

        if (idxConsulta < 0 || idxConsulta >= totalConsultas) {
            System.out.println("Indice invalido.");
            return;
        }
        if (!consultas.get(idxConsulta).getStatus().equals("agendada")) {
            System.out.println("So pode registrar atendimento em consulta agendada.");
            return;
        }

        System.out.print("Observacoes: ");
        String obs = sc.nextLine();

        System.out.print("Tipo de registro (1-So obs / 2-Com diagnostico / 3-Completo): ");
        int tipo = Integer.parseInt(sc.nextLine());

        if (tipo == 1) {
            atendimentos.set(totalAtendimentos, new Atendimento(idxConsulta, obs));

        } else if (tipo == 2) {
            System.out.print("Diagnostico: ");
            String diag = sc.nextLine();
            atendimentos.set(totalAtendimentos, new Atendimento(idxConsulta, obs, diag));

        } else {
            System.out.print("Diagnostico: ");
            String diag = sc.nextLine();

            System.out.print("Como informar procedimentos? (1-Um por vez / 2-Todos de uma vez): ");
            int forma = Integer.parseInt(sc.nextLine());

            List<String> procs = new ArrayList<>();
            int qtdProcs = 0;

            if (forma == 1) {
                String proc = "";
                while (!proc.equals("fim") && qtdProcs < 10) {
                    System.out.print("Procedimento (ou 'fim'): ");
                    proc = sc.nextLine();
                    if (!proc.equals("fim")) {
                        procs.set(qtdProcs, proc);
                        qtdProcs++;
                    }
                }
            } else {
                System.out.print("Quantos? ");
                qtdProcs = Integer.parseInt(sc.nextLine());
                if (qtdProcs > 10) qtdProcs = 10;
                for (int i = 0; i < qtdProcs; i++) {
                    System.out.print("Proc " + (i+1) + ": ");
                    procs.set(i, sc.nextLine());
                }
            }
            atendimentos.set(totalAtendimentos, new Atendimento(idxConsulta, obs, diag, procs, qtdProcs));
        }

        consultas.get(idxConsulta).realizar();
        totalAtendimentos++;
        System.out.println("\n--- RESUMO ---");
        System.out.println(atendimentos.get(totalAtendimentos - 1).exibirResumo());
        System.out.println("Consulta marcada como realizada.");
    }

    // ---- PAGAMENTOS ----

    public static void pagamentoDireto() {
        System.out.print("Indice da consulta: ");
        int idxConsulta = Integer.parseInt(sc.nextLine());

        if (idxConsulta < 0 || idxConsulta >= totalConsultas) {
            System.out.println("Indice invalido.");
            return;
        }

        System.out.print("Valor: ");
        double valor = Double.parseDouble(sc.nextLine());
        System.out.print("Tipo (dinheiro/cartao/convenio): ");
        String tipoPag = sc.nextLine();

        if (tipoPag.equals("cartao")) {
            System.out.print("Parcelas (1 a 3): ");
            int parc = Integer.parseInt(sc.nextLine());
            if (parc < 1) parc = 1;
            if (parc > 3) parc = 3;
            pagamentos.set(totalPagamentos, new PagamentoDinheiro(idxConsulta, valor, tipoPag, parc));
            if (parc > 1) {
                double vlrParc = Math.round((valor / parc) * 100.0) / 100.0;
                System.out.println("Pagamento em " + parc + "x de R$" + vlrParc);
            }
        } else {
            pagamentos.set(totalPagamentos, new PagamentoDinheiro(idxConsulta, valor, tipoPag));
        }
        totalPagamentos++;
        System.out.println("Pagamento registrado!");
    }

    public static void pagamentoAutomatico() {
        System.out.print("Indice da consulta: ");
        int idxConsulta = Integer.parseInt(sc.nextLine());

        if (idxConsulta < 0 || idxConsulta >= totalConsultas) {
            System.out.println("Indice invalido.");
            return;
        }

        //obtem valor do profissional
        String nomeProf = consultas.get(idxConsulta).getNomeDoProfissional();
        int idxProf = buscarIndiceProfissional(nomeProf);
        double valorBase = profissionais.get(idxProf).getValorConsulta();

        //verifica convenio e tipo
        String cpfPac = consultas.get(idxConsulta).getCPF();
        int idxPac = buscarIndicePaciente(cpfPac);

        boolean temConvenio = !pacientes.get(idxPac).getConvenio().equals(null);
        boolean ehRetorno = consultas.get(idxConsulta).getTipo().equals("retorno");

        double desconto = 0;
        if (ehRetorno) desconto = desconto + 20;
        if (temConvenio) desconto = desconto + 40;

        System.out.print("Tem multa pendente? (1-Nao / 2-Sim): ");
        int temMulta = Integer.parseInt(sc.nextLine());
        double valorMulta = 0;

        double valorFinal;
        if (temMulta == 1 && desconto == 0) {
            valorFinal = Pagamento.calcularValor(valorBase);
        } else if (temMulta == 1) {
            valorFinal = Pagamento.calcularValor(valorBase, desconto);
        } else {
            System.out.print("Valor da multa: ");
            valorMulta = Double.parseDouble(sc.nextLine());
            valorFinal = Pagamento.calcularValor(valorBase, desconto, valorMulta);
        }

      //mostra detalhes
        System.out.println("Valor base: R$" + valorBase);
        System.out.println("Desconto: " + desconto + "%");
        if (valorMulta > 0) System.out.println("Multa: R$" + valorMulta);
        double vlrFinalArredondado = Math.round(valorFinal * 100.0) / 100.0;
        System.out.println("Valor final: R$" + vlrFinalArredondado);

        System.out.print("Tipo (dinheiro/cartao/convenio): ");
        String tipoPag = sc.nextLine();

        if (tipoPag.equals("cartao")) {
            System.out.print("Parcelas (1 a 3): ");
            int parc = Integer.parseInt(sc.nextLine());
            if (parc < 1) parc = 1;
            if (parc > 3) parc = 3;
            pagamentos.set(totalPagamentos, new PagamentoDinheiro(idxConsulta, valorFinal, tipoPag, parc));
            double vlrParc = Math.round((valorFinal / parc) * 100.0) / 100.0;
            System.out.println("Pagamento em " + parc + "x de R$" + vlrParc);
        } else {
            pagamentos.set(totalPagamentos, new PagamentoDinheiro(idxConsulta, valorFinal, tipoPag));
        }
        totalPagamentos++;
        System.out.println("Pagamento registrado!");
    }
    
    public static void listarPagamentos() {
        if (totalPagamentos == 0) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        for (int i = 0; i < totalPagamentos; i++) {
            System.out.println(pagamentos.get(i).exibirResumo());
        }
    }

    // ---- RELATORIOS ----

    public static void gerarRelatorio(int opcao) {
        switch (opcao) {
            case 1:
                Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos);
                break;
            case 2:
                System.out.print("Nome do profissional: ");
                String nome = sc.nextLine();
                Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos, nome);
                break;
            case 3:
                System.out.print("Data inicio (DD/MM/AAAA): ");
                String ini = sc.nextLine();
                System.out.print("Data fim (DD/MM/AAAA): ");
                String fim = sc.nextLine();
                Relatorio.gerarRelatorio(consultas, totalConsultas, atendimentos, totalAtendimentos, ini, fim);
                break;
            case 4:
                Relatorio.gerarResumoFinanceiro(consultas, totalConsultas, pagamentos, totalPagamentos, multas, totalMultas);
                break;
            case 0: break;
            default: System.out.println("Opcao invalida!"); break;
        }
    }
}

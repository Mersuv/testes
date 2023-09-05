import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Usuário {
    private String nome;
    private String cidade;
    private String email;

    public Usuário(String nome, String cidade, String email) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
    }

    // Getters e setters

    @Override
    public String toString() {
        return "Usuário{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Evento implements Serializable {
    private String nome;
    private String endereço;
    private String categoria;
    private LocalDateTime datahora;
    private String descrição;

    public Evento(String nome, String endereço, String categoria, LocalDateTime datahora, String descrição) {
        this.nome = nome;
        this.endereço = endereço;
        this.categoria = categoria;
        this.datahora = datahora;
        this.descrição = descrição;
    }

    public LocalDateTime getDataHora() {
        return datahora;
    }

    // Getters e setters

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", endereço='" + endereço + '\'' +
                ", categoria='" + categoria + '\'' +
                ", datahora=" + datahora +
                ", descrição='" + descrição + '\'' +
                '}';
    }
}

class GerenciadorEventos {
    private List<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Evento> getEventosFuturos() {
        LocalDateTime agora = LocalDateTime.now();
        List<Evento> eventosFuturos = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getDataHora().isAfter(agora)) {
                eventosFuturos.add(evento);
            }
        }
        eventosFuturos.sort(Comparator.comparing(Evento::getDataHora));
        return eventosFuturos;
    }

    public void salvarEventosEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarEventosDeArquivo(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                for (Object eventoObj : (List<?>) obj) {
                    if (eventoObj instanceof Evento) {
                        eventos.add((Evento) eventoObj);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class AplicativoEventos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
        String nomeArquivoEventos = "eventos.data";

        // Carregar eventos do arquivo, se disponível
        gerenciadorEventos.carregarEventosDeArquivo(nomeArquivoEventos);

        while (true) {
            System.out.println("1. Criar Usuário");
            System.out.println("2. Criar Evento");
            System.out.println("3. Ver Eventos Futuros");
            System.out.println("4. Salvar e Sair");
            System.out.print("Selecione uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite a cidade do usuário: ");
                    String cidadeUsuario = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String emailUsuario = scanner.nextLine();
                    Usuário usuário = new Usuário(nomeUsuario, cidadeUsuario, emailUsuario);
                    System.out.println("Usuário criado: " + usuário);
                    break;

                case 2:
                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite o endereço do evento: ");
                    String endereçoEvento = scanner.nextLine();
                    System.out.print("Digite a categoria do evento: ");
                    String categoriaEvento = scanner.nextLine();
                    System.out.print("Digite a descrição do evento: ");
                    String descriçãoEvento = scanner.nextLine();
                    System.out.print("Digite o ano do evento: ");
                    int ano = scanner.nextInt();
                    System.out.print("Digite o mês do evento (1-12): ");
                    int mês = scanner.nextInt();
                    System.out.print("Digite o dia do evento: ");
                    int dia = scanner.nextInt();
                    System.out.print("Digite a hora do evento (0-23): ");
                    int hora = scanner.nextInt();
                    System.out.print("Digite o minuto do evento (0-59): ");
                    int minuto = scanner.nextInt();
                    LocalDateTime dataHoraEvento = LocalDateTime.of(ano, mês, dia, hora, minuto);
                    Evento evento = new Evento(nomeEvento, endereçoEvento, categoriaEvento, dataHoraEvento, descriçãoEvento);
                    gerenciadorEventos.adicionarEvento(evento);
                    System.out.println("Evento criado: " + evento);
                    break;

                case 3:
                    List<Evento> eventosFuturos = gerenciadorEventos.getEventosFuturos();
                    System.out.println("Eventos Futuros:");
                    for (Evento e : eventosFuturos) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    gerenciadorEventos.salvarEventosEmArquivo(nomeArquivoEventos);
                    System.out.println("Eventos salvos. Saindo...");
                    System.exit(0);

                default:
                    System.out.println("Escolha inválida. Por favor, selecione uma opção válida.");
            }
            scanner.close();
        }
    }
}

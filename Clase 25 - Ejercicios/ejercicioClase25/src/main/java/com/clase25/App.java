package com.clase25;

import com.clase25.dao.*;
import com.clase25.modelos.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class App {
    private static EventoDAO eventoDAO = new EventoDAOImpl();
    private static ParticipanteDAO participanteDAO = new ParticipanteDAOImpl();
    private static InscripcionDAO inscripcionDAO = new InscripcionDAOImpl();
    private static OrganizadorDAO organizadorDAO = new OrganizadorDAOImpl();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Insertar Evento");
            System.out.println("2. Insertar Participante");
            System.out.println("3. Insertar Inscripción");
            System.out.println("4. Insertar Organizador");
            System.out.println("5. Consultar Eventos");
            System.out.println("6. Consultar Participantes");
            System.out.println("7. Consultar Inscripciones");
            System.out.println("8. Consultar Organizadores");
            System.out.println("9. Consultar Eventos y Participantes");
            System.out.println("10. Eliminar Todos los Datos");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    insertarEvento();
                    break;
                case 2:
                    insertarParticipante();
                    break;
                case 3:
                    insertarInscripcion();
                    break;
                case 4:
                    insertarOrganizador();
                    break;
                case 5:
                    consultarEventos();
                    break;
                case 6:
                    consultarParticipantes();
                    break;
                case 7:
                    consultarInscripciones();
                    break;
                case 8:
                    consultarOrganizadores();
                    break;
                case 9:
                    consultarEventosParticipantes();
                    break;
                case 10:
                    eliminarDatos();
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 11);
    }

    private static void insertarEvento() {
        Evento evento = new Evento();
        System.out.print("Nombre del evento: ");
        evento.setNombre(scanner.nextLine());
        System.out.print("Fecha (yyyy-MM-dd HH:mm): ");
        String fechaStr = scanner.nextLine();
        evento.setFecha(LocalDateTime.parse(fechaStr, FORMATTER)); // Usar el formateador
        System.out.print("Lugar: ");
        evento.setLugar(scanner.nextLine());
        eventoDAO.insertarEvento(evento);
        System.out.println("Evento insertado exitosamente.");
    }

    private static void insertarParticipante() {
        Participante participante = new Participante();
        System.out.print("Nombre del participante: ");
        participante.setNombre(scanner.nextLine());
        System.out.print("Email: ");
        participante.setEmail(scanner.nextLine());
        System.out.print("Teléfono: ");
        participante.setTelefono(scanner.nextLine());
        System.out.print("ID de inscripción (opcional, dejar en blanco si no tiene): ");
        String idInscripcion = scanner.nextLine();
        if (!idInscripcion.isEmpty()) {
            participante.setIdInscripcion(Integer.parseInt(idInscripcion));
        }
        participanteDAO.insertarParticipante(participante);
        System.out.println("Participante insertado exitosamente.");
    }

    private static void insertarInscripcion() {
        Inscripcion inscripcion = new Inscripcion();
        System.out.print("Estado de la inscripción: ");
        inscripcion.setEstadoInscripcion(scanner.nextLine());
        System.out.print("Fecha de inscripción (yyyy-mm-dd hh:mm): ");
        inscripcion.setFechaInscripcion(LocalDateTime.parse(scanner.nextLine()));
        inscripcionDAO.insertarInscripcion(inscripcion);
        System.out.println("Inscripción insertada exitosamente.");
    }

    private static void insertarOrganizador() {
        Organizador organizador = new Organizador();
        System.out.print("Nombre del organizador: ");
        organizador.setNombre(scanner.nextLine());
        System.out.print("Contacto: ");
        organizador.setContacto(scanner.nextLine());
        System.out.print("Descripción de la organización: ");
        organizador.setDescOrganizacion(scanner.nextLine());
        System.out.print("ID de evento (opcional, dejar en blanco si no tiene): ");
        String idEvento = scanner.nextLine();
        if (!idEvento.isEmpty()) {
            organizador.setIdEvento(Integer.parseInt(idEvento));
        }
        organizadorDAO.insertarOrganizador(organizador);
        System.out.println("Organizador insertado exitosamente.");
    }

    private static void consultarEventos() {
        List<Evento> eventos = eventoDAO.consultarEventos();
        System.out.println("Eventos:");
        for (Evento e : eventos) {
            System.out.printf("ID: %d, Nombre: %s, Fecha: %s, Lugar: %s%n",
                    e.getId(), e.getNombre(), e.getFecha(), e.getLugar());
        }
    }

    private static void consultarParticipantes() {
        List<Participante> participantes = participanteDAO.consultarParticipantes();
        System.out.println("Participantes:");
        for (Participante p : participantes) {
            System.out.printf("ID: %d, Nombre: %s, Email: %s, Teléfono: %s, ID Inscripción: %s%n",
                    p.getId(), p.getNombre(), p.getEmail(), p.getTelefono(),
                    p.getIdInscripcion() != null ? p.getIdInscripcion() : "N/A");
        }
    }

    private static void consultarInscripciones() {
        List<Inscripcion> inscripciones = inscripcionDAO.consultarInscripciones();
        System.out.println("Inscripciones:");
        for (Inscripcion i : inscripciones) {
            System.out.printf("ID: %d, Estado: %s, Fecha: %s%n",
                    i.getId(), i.getEstadoInscripcion(), i.getFechaInscripcion());
        }
    }

    private static void consultarOrganizadores() {
        List<Organizador> organizadores = organizadorDAO.consultarOrganizadores();
        System.out.println("Organizadores:");
        for (Organizador o : organizadores) {
            System.out.printf("ID: %d, Nombre: %s, Contacto: %s, Descripción: %s, ID Evento: %s%n",
                    o.getId(), o.getNombre(), o.getContacto(), o.getDescOrganizacion(),
                    o.getIdEvento() != null ? o.getIdEvento() : "N/A");
        }
    }

    private static void consultarEventosParticipantes() {
        List<EventoParticipante> eventosParticipantes = eventoDAO.consultarEventosParticipantes();
        System.out.println("Eventos y Participantes:");
        for (EventoParticipante ep : eventosParticipantes) {
            System.out.printf("Evento: %s, Participante: %s%n",
                    ep.getNombreEvento(), ep.getNombreParticipante());
        }
    }

    private static void eliminarDatos() {
        eventoDAO.eliminarEventos();
        participanteDAO.eliminarParticipantes();
        inscripcionDAO.eliminarInscripciones();
        organizadorDAO.eliminarOrganizadores();
        System.out.println("Todos los datos han sido eliminados.");
    }
}

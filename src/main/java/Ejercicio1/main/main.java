package Ejercicio1.main;

import Ejercicio1.database.ConnectionManager;
import Ejercicio1.database.RegistroParticipanteImpl;
import Ejercicio1.model.Participantes;
import Ejercicio1.model.RegistroParticipantes;
import Ejercicio1.ui.VentanaAgregarParticipante;

import java.sql.SQLException;
import java.awt.EventQueue;

class main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConnectionManager.crearTabla();
                    new VentanaAgregarParticipante(new Participantes(new RegistroParticipanteImpl())).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
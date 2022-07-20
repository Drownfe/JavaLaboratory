package Data;
import java.util.List;

import Bicycle.Ticket;
import Bicycle.TicketHistory;
import Except.DAccess;
import Except.DReading;
import Except.DWriting;


public interface Access {
    boolean exists(String filename) throws DAccess;
    void createFile(String fileName) throws DAccess;
    void writeFile(String fileName, Ticket ticket, boolean anexar) throws DWriting;
    void writeFile(String fileName, List<TicketHistory> ticketFileList, boolean attach) throws DWriting;
    void writeFile2(String fileName, List<String> header, boolean attach) throws DWriting;
    void readFile(String fileName, List<String> array) throws DReading;
    void create(String nombreArchivo) throws DAccess;
    void remove (String nombreArchivo) throws DAccess;
}

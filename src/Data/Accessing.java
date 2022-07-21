package Data;
import java.io.*;
import java.util.List;

import Bicycle.TicketHistory;
import Except.DAccess;
import Except.DReading;
import Except.DWriting;
import Bicycle.Ticket;

public class Accessing implements Access{

    @Override
    public boolean exists(String filename) throws DAccess {
        var file = new File(filename);
        return file.exists();
    }
    @Override
    public void createFile(String fileName) throws DAccess {
    }
    @Override
    public void writeFile(String fileName, Ticket ticket, boolean anexar) throws DWriting {
    }
    @Override
    public void writeFile(String fileName, List<TicketHistory> ticketFileList, boolean attach) throws DWriting {
    }
    @Override
    public void writeFile2(String fileName, List<String> header, boolean attach) throws DWriting {
    }
    @Override
    public void readFile(String fileName, List<String> array) throws DReading {
    }
    @Override
    public void create(String nombreArchivo) throws DAccess {
    }

    @Override
    public void remove(String fileName) throws DAccess {
        var file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}

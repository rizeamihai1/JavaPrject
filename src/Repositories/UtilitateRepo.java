package Repositories;
import Models.*;
import java.util.*;

public interface UtilitateRepo {
    void addUtilitate(Utilitate utilitate);
    void removeUtilitate(int idUtilitate);
    Utilitate getUtilitateById(int idUtilitate);
    List<Utilitate> getAllUtilitati();
    void updateUtilitate(Utilitate utilitate);
}

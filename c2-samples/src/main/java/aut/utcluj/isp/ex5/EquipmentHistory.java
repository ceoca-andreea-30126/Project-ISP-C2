package aut.utcluj.isp.ex5;

import aut.utcluj.isp.ex4.EquipmentHistoryDetails;
import aut.utcluj.isp.ex4.Operation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author stefan
 */
public class EquipmentHistory implements IEquipmentHistory {
    private List<EquipmentHistoryDetails> historyDetailsList;

    public EquipmentHistory() {
        historyDetailsList = new ArrayList<>();
    }

    public void addEquipmentHistory(final String owner, final Operation operation, final LocalDateTime providedDate) {
//        throw new UnsupportedOperationException("Not supported yet.");
        EquipmentHistoryDetails equipmentHistoryDetails = new EquipmentHistoryDetails(owner, operation, providedDate);
        historyDetailsList.add(equipmentHistoryDetails);
    }

    public List<EquipmentHistoryDetails> filterEquipmentHistoryByOperation(final Operation operation) {
//        throw new UnsupportedOperationException("Not supported yet.");
        List<EquipmentHistoryDetails> equipmentHistoryDetailsList = new ArrayList<>();
        for (EquipmentHistoryDetails equipmentHistoryDetails : historyDetailsList)
            if (equipmentHistoryDetails.getOperation().equals(operation))
                equipmentHistoryDetailsList.add(equipmentHistoryDetails);
        return equipmentHistoryDetailsList;
    }

    public List<EquipmentHistoryDetails> sortEquipmentHistoryByDateDesc() {
//        throw new UnsupportedOperationException("Not supported yet.");
        Collections.reverseOrder(Comparator.comparing(EquipmentHistoryDetails::getDate));
        return historyDetailsList;
    }

    public List<EquipmentHistoryDetails> sortEquipmentHistoryByDate() {
        //throw new UnsupportedOperationException("Not supported yet.");
        historyDetailsList.sort(Comparator.comparing(EquipmentHistoryDetails::getDate));
        //Collections.sort(historyDetailsList, Collections.reverseOrder());
        return historyDetailsList;
    }

    public List<EquipmentHistoryDetails> getHistoryDetailsList() {
        return historyDetailsList;
    }
}

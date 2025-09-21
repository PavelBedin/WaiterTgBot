package Handlers.Commands.Models;

import java.util.Map;

public class WaiterAccount {
    private final Map<Integer, Double> tableAccount;
    private final double totalAccount;

    public WaiterAccount(Map<Integer, Double> tableAccount) {
        this.tableAccount = tableAccount;
        this.totalAccount = tableAccount.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getTotalAccount() {
        return totalAccount;
    }

    public Map<Integer, Double> getTableAccount() {
        return tableAccount;
    }
}

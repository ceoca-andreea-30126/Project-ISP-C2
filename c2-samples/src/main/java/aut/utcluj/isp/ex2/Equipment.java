package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class Equipment {
    private String name;
    private String serialNumber;

    public Equipment(String serialNumber) {
        if (serialNumber.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.name = "NONE";
        this.serialNumber = serialNumber;
    }

    public Equipment(String name, String serialNumber) {
        if (name.isEmpty() || serialNumber.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String toString() {
        return name + "_" + serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(name, equipment.name) &&
                Objects.equals(serialNumber, equipment.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serialNumber);
    }
}

package com.bistrocontrol.bistro_control.model;

public class ReservedTableStatus {
    
    private Long tableId;

    private int tableSeats;

    private String status;

    private Long reserveId;

    public ReservedTableStatus() {
        this.tableId = tableId;
        this.tableSeats = tableSeats;
        this.status = status;
        this.reserveId = reserveId;
    }

    public ReservedTableStatus(Long tableId, int tableSeats, Long reserveId, String status) {
        this.tableId = tableId;
        this.tableSeats = tableSeats;
        this.status = status;
        this.reserveId = reserveId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public int getTableSeats() {
        return tableSeats;
    }

    public void setTableSeats(int tableSeats) {
        this.tableSeats = tableSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }  

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tableId == null) ? 0 : tableId.hashCode());
        result = prime * result + tableSeats;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReservedTableStatus other = (ReservedTableStatus) obj;
        if (tableId == null) {
            if (other.tableId != null)
                return false;
        } else if (!tableId.equals(other.tableId))
            return false;
        if (tableSeats != other.tableSeats)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ReservedTableStatus [tableId=" + tableId + ", tableSeats=" + tableSeats + ", status=" + status + ", reserveId=" + reserveId + "]";
    }
    
}
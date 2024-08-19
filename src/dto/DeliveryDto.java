package dto;

import common.DeliveryStatus;
import lombok.Generated;

public class DeliveryDto {
    private int id;
    private int release_id;
    private int admin_id;
    private int warehouse_id;
    private int user_id;
    private String created_at;
    private String updated_at;
    private String start_date;
    private String end_date;
    private String remarks;
    private DeliveryStatus deliveryStatus;

    public DeliveryDto(int release_id, String remarks) {
        this.release_id = release_id;
        this.remarks = remarks;
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public int getRelease_id() {
        return this.release_id;
    }

    @Generated
    public int getAdmin_id() {
        return this.admin_id;
    }

    @Generated
    public int getWarehouse_id() {
        return this.warehouse_id;
    }

    @Generated
    public int getUser_id() {
        return this.user_id;
    }

    @Generated
    public String getCreated_at() {
        return this.created_at;
    }

    @Generated
    public String getUpdated_at() {
        return this.updated_at;
    }

    @Generated
    public String getStart_date() {
        return this.start_date;
    }

    @Generated
    public String getEnd_date() {
        return this.end_date;
    }

    @Generated
    public String getRemarks() {
        return this.remarks;
    }

    @Generated
    public DeliveryStatus getDeliveryStatus() {
        return this.deliveryStatus;
    }

    @Generated
    public void setId(int id) {
        this.id = id;
    }

    @Generated
    public void setRelease_id(int release_id) {
        this.release_id = release_id;
    }

    @Generated
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    @Generated
    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    @Generated
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Generated
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Generated
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Generated
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Generated
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Generated
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Generated
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DeliveryDto)) {
            return false;
        } else {
            DeliveryDto other = (DeliveryDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getRelease_id() != other.getRelease_id()) {
                return false;
            } else if (this.getAdmin_id() != other.getAdmin_id()) {
                return false;
            } else if (this.getWarehouse_id() != other.getWarehouse_id()) {
                return false;
            } else if (this.getUser_id() != other.getUser_id()) {
                return false;
            } else {
                Object this$created_at = this.getCreated_at();
                Object other$created_at = other.getCreated_at();
                if (this$created_at == null) {
                    if (other$created_at != null) {
                        return false;
                    }
                } else if (!this$created_at.equals(other$created_at)) {
                    return false;
                }

                label88: {
                    Object this$updated_at = this.getUpdated_at();
                    Object other$updated_at = other.getUpdated_at();
                    if (this$updated_at == null) {
                        if (other$updated_at == null) {
                            break label88;
                        }
                    } else if (this$updated_at.equals(other$updated_at)) {
                        break label88;
                    }

                    return false;
                }

                label81: {
                    Object this$start_date = this.getStart_date();
                    Object other$start_date = other.getStart_date();
                    if (this$start_date == null) {
                        if (other$start_date == null) {
                            break label81;
                        }
                    } else if (this$start_date.equals(other$start_date)) {
                        break label81;
                    }

                    return false;
                }

                label74: {
                    Object this$end_date = this.getEnd_date();
                    Object other$end_date = other.getEnd_date();
                    if (this$end_date == null) {
                        if (other$end_date == null) {
                            break label74;
                        }
                    } else if (this$end_date.equals(other$end_date)) {
                        break label74;
                    }

                    return false;
                }

                Object this$remarks = this.getRemarks();
                Object other$remarks = other.getRemarks();
                if (this$remarks == null) {
                    if (other$remarks != null) {
                        return false;
                    }
                } else if (!this$remarks.equals(other$remarks)) {
                    return false;
                }

                Object this$deliveryStatus = this.getDeliveryStatus();
                Object other$deliveryStatus = other.getDeliveryStatus();
                if (this$deliveryStatus == null) {
                    if (other$deliveryStatus != null) {
                        return false;
                    }
                } else if (!this$deliveryStatus.equals(other$deliveryStatus)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DeliveryDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getRelease_id();
        result = result * 59 + this.getAdmin_id();
        result = result * 59 + this.getWarehouse_id();
        result = result * 59 + this.getUser_id();
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $updated_at = this.getUpdated_at();
        result = result * 59 + ($updated_at == null ? 43 : $updated_at.hashCode());
        Object $start_date = this.getStart_date();
        result = result * 59 + ($start_date == null ? 43 : $start_date.hashCode());
        Object $end_date = this.getEnd_date();
        result = result * 59 + ($end_date == null ? 43 : $end_date.hashCode());
        Object $remarks = this.getRemarks();
        result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
        Object $deliveryStatus = this.getDeliveryStatus();
        result = result * 59 + ($deliveryStatus == null ? 43 : $deliveryStatus.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "DeliveryDto(id=" + var10000 + ", release_id=" + this.getRelease_id() + ", admin_id=" + this.getAdmin_id() + ", warehouse_id=" + this.getWarehouse_id() + ", user_id=" + this.getUser_id() + ", created_at=" + this.getCreated_at() + ", updated_at=" + this.getUpdated_at() + ", start_date=" + this.getStart_date() + ", end_date=" + this.getEnd_date() + ", remarks=" + this.getRemarks() + ", deliveryStatus=" + this.getDeliveryStatus() + ")";
    }

    @Generated
    public DeliveryDto() {
    }

    @Generated
    public DeliveryDto(int id, int release_id, int admin_id, int warehouse_id, int user_id, String created_at, String updated_at, String start_date, String end_date, String remarks, DeliveryStatus deliveryStatus) {
        this.id = id;
        this.release_id = release_id;
        this.admin_id = admin_id;
        this.warehouse_id = warehouse_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.start_date = start_date;
        this.end_date = end_date;
        this.remarks = remarks;
        this.deliveryStatus = deliveryStatus;
    }
}

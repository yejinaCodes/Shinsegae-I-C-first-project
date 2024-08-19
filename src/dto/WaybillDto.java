package dto;

import lombok.Generated;

public class WaybillDto {
    private int id;
    private String waybill_number;
    private int delivery_id;
    private int release_id;
    private String created_at;
    private String updated_at;

    public WaybillDto(String waybill_number, int delivery_id) {
        this.waybill_number = waybill_number;
        this.delivery_id = delivery_id;
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getWaybill_number() {
        return this.waybill_number;
    }

    @Generated
    public int getDelivery_id() {
        return this.delivery_id;
    }

    @Generated
    public int getRelease_id() {
        return this.release_id;
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
    public void setId(int id) {
        this.id = id;
    }

    @Generated
    public void setWaybill_number(String waybill_number) {
        this.waybill_number = waybill_number;
    }

    @Generated
    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    @Generated
    public void setRelease_id(int release_id) {
        this.release_id = release_id;
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof WaybillDto)) {
            return false;
        } else {
            WaybillDto other = (WaybillDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getDelivery_id() != other.getDelivery_id()) {
                return false;
            } else if (this.getRelease_id() != other.getRelease_id()) {
                return false;
            } else {
                label54: {
                    Object this$waybill_number = this.getWaybill_number();
                    Object other$waybill_number = other.getWaybill_number();
                    if (this$waybill_number == null) {
                        if (other$waybill_number == null) {
                            break label54;
                        }
                    } else if (this$waybill_number.equals(other$waybill_number)) {
                        break label54;
                    }

                    return false;
                }

                Object this$created_at = this.getCreated_at();
                Object other$created_at = other.getCreated_at();
                if (this$created_at == null) {
                    if (other$created_at != null) {
                        return false;
                    }
                } else if (!this$created_at.equals(other$created_at)) {
                    return false;
                }

                Object this$updated_at = this.getUpdated_at();
                Object other$updated_at = other.getUpdated_at();
                if (this$updated_at == null) {
                    if (other$updated_at != null) {
                        return false;
                    }
                } else if (!this$updated_at.equals(other$updated_at)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof WaybillDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getDelivery_id();
        result = result * 59 + this.getRelease_id();
        Object $waybill_number = this.getWaybill_number();
        result = result * 59 + ($waybill_number == null ? 43 : $waybill_number.hashCode());
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        Object $updated_at = this.getUpdated_at();
        result = result * 59 + ($updated_at == null ? 43 : $updated_at.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "WaybillDto(id=" + var10000 + ", waybill_number=" + this.getWaybill_number() + ", delivery_id=" + this.getDelivery_id() + ", release_id=" + this.getRelease_id() + ", created_at=" + this.getCreated_at() + ", updated_at=" + this.getUpdated_at() + ")";
    }

    @Generated
    public WaybillDto() {
    }

    @Generated
    public WaybillDto(int id, String waybill_number, int delivery_id, int release_id, String created_at, String updated_at) {
        this.id = id;
        this.waybill_number = waybill_number;
        this.delivery_id = delivery_id;
        this.release_id = release_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}

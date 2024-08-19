//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dto;

import lombok.Generated;

public class ShippingInstructionDto {
    private int id;
    private int release_id;
    private int delivery_id;
    private String created_at;

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public int getRelease_id() {
        return this.release_id;
    }

    @Generated
    public int getDelivery_id() {
        return this.delivery_id;
    }

    @Generated
    public String getCreated_at() {
        return this.created_at;
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
    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    @Generated
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ShippingInstructionDto)) {
            return false;
        } else {
            ShippingInstructionDto other = (ShippingInstructionDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getRelease_id() != other.getRelease_id()) {
                return false;
            } else if (this.getDelivery_id() != other.getDelivery_id()) {
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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ShippingInstructionDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getRelease_id();
        result = result * 59 + this.getDelivery_id();
        Object $created_at = this.getCreated_at();
        result = result * 59 + ($created_at == null ? 43 : $created_at.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "ShippingInstructionDto(id=" + var10000 + ", release_id=" + this.getRelease_id() + ", delivery_id=" + this.getDelivery_id() + ", created_at=" + this.getCreated_at() + ")";
    }

    @Generated
    public ShippingInstructionDto() {
    }

    @Generated
    public ShippingInstructionDto(int id, int release_id, int delivery_id, String created_at) {
        this.id = id;
        this.release_id = release_id;
        this.delivery_id = delivery_id;
        this.created_at = created_at;
    }
}

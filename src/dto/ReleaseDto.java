package dto;

import common.ReleaseStatus;
import lombok.Generated;

public class ReleaseDto {
    private int id;
    private int user_id;
    private String product_id;
    private String customer_name;
    private String customer_address;
    private int amount;
    private ReleaseStatus releaseStatus;
    private String remarks;
    private String request_date;
    private String update_date;

    public ReleaseDto(String customer_name, String customer_address, int amount, String product_id, ReleaseStatus releaseStatus, String remarks) {
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.amount = amount;
        this.product_id = product_id;
        this.releaseStatus = ReleaseStatus.PENDING;
        this.remarks = remarks;
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public int getUser_id() {
        return this.user_id;
    }

    @Generated
    public String getProduct_id() {
        return this.product_id;
    }

    @Generated
    public String getCustomer_name() {
        return this.customer_name;
    }

    @Generated
    public String getCustomer_address() {
        return this.customer_address;
    }

    @Generated
    public int getAmount() {
        return this.amount;
    }

    @Generated
    public ReleaseStatus getReleaseStatus() {
        return this.releaseStatus;
    }

    @Generated
    public String getRemarks() {
        return this.remarks;
    }

    @Generated
    public String getRequest_date() {
        return this.request_date;
    }

    @Generated
    public String getUpdate_date() {
        return this.update_date;
    }

    @Generated
    public void setId(int id) {
        this.id = id;
    }

    @Generated
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Generated
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Generated
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Generated
    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    @Generated
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Generated
    public void setReleaseStatus(ReleaseStatus releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    @Generated
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Generated
    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    @Generated
    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReleaseDto)) {
            return false;
        } else {
            ReleaseDto other = (ReleaseDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (this.getUser_id() != other.getUser_id()) {
                return false;
            } else if (this.getAmount() != other.getAmount()) {
                return false;
            } else {
                label102: {
                    Object this$product_id = this.getProduct_id();
                    Object other$product_id = other.getProduct_id();
                    if (this$product_id == null) {
                        if (other$product_id == null) {
                            break label102;
                        }
                    } else if (this$product_id.equals(other$product_id)) {
                        break label102;
                    }

                    return false;
                }

                Object this$customer_name = this.getCustomer_name();
                Object other$customer_name = other.getCustomer_name();
                if (this$customer_name == null) {
                    if (other$customer_name != null) {
                        return false;
                    }
                } else if (!this$customer_name.equals(other$customer_name)) {
                    return false;
                }

                label88: {
                    Object this$customer_address = this.getCustomer_address();
                    Object other$customer_address = other.getCustomer_address();
                    if (this$customer_address == null) {
                        if (other$customer_address == null) {
                            break label88;
                        }
                    } else if (this$customer_address.equals(other$customer_address)) {
                        break label88;
                    }

                    return false;
                }

                Object this$releaseStatus = this.getReleaseStatus();
                Object other$releaseStatus = other.getReleaseStatus();
                if (this$releaseStatus == null) {
                    if (other$releaseStatus != null) {
                        return false;
                    }
                } else if (!this$releaseStatus.equals(other$releaseStatus)) {
                    return false;
                }

                label74: {
                    Object this$remarks = this.getRemarks();
                    Object other$remarks = other.getRemarks();
                    if (this$remarks == null) {
                        if (other$remarks == null) {
                            break label74;
                        }
                    } else if (this$remarks.equals(other$remarks)) {
                        break label74;
                    }

                    return false;
                }

                Object this$request_date = this.getRequest_date();
                Object other$request_date = other.getRequest_date();
                if (this$request_date == null) {
                    if (other$request_date != null) {
                        return false;
                    }
                } else if (!this$request_date.equals(other$request_date)) {
                    return false;
                }

                Object this$update_date = this.getUpdate_date();
                Object other$update_date = other.getUpdate_date();
                if (this$update_date == null) {
                    if (other$update_date == null) {
                        return true;
                    }
                } else if (this$update_date.equals(other$update_date)) {
                    return true;
                }

                return false;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ReleaseDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = true;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getUser_id();
        result = result * 59 + this.getAmount();
        Object $product_id = this.getProduct_id();
        result = result * 59 + ($product_id == null ? 43 : $product_id.hashCode());
        Object $customer_name = this.getCustomer_name();
        result = result * 59 + ($customer_name == null ? 43 : $customer_name.hashCode());
        Object $customer_address = this.getCustomer_address();
        result = result * 59 + ($customer_address == null ? 43 : $customer_address.hashCode());
        Object $releaseStatus = this.getReleaseStatus();
        result = result * 59 + ($releaseStatus == null ? 43 : $releaseStatus.hashCode());
        Object $remarks = this.getRemarks();
        result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
        Object $request_date = this.getRequest_date();
        result = result * 59 + ($request_date == null ? 43 : $request_date.hashCode());
        Object $update_date = this.getUpdate_date();
        result = result * 59 + ($update_date == null ? 43 : $update_date.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getId();
        return "ReleaseDto(id=" + var10000 + ", user_id=" + this.getUser_id() + ", product_id=" + this.getProduct_id() + ", customer_name=" + this.getCustomer_name() + ", customer_address=" + this.getCustomer_address() + ", amount=" + this.getAmount() + ", releaseStatus=" + this.getReleaseStatus() + ", remarks=" + this.getRemarks() + ", request_date=" + this.getRequest_date() + ", update_date=" + this.getUpdate_date() + ")";
    }

    @Generated
    public ReleaseDto() {
    }

    @Generated
    public ReleaseDto(int id, int user_id, String product_id, String customer_name, String customer_address, int amount, ReleaseStatus releaseStatus, String remarks, String request_date, String update_date) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.amount = amount;
        this.releaseStatus = releaseStatus;
        this.remarks = remarks;
        this.request_date = request_date;
        this.update_date = update_date;
    }
}

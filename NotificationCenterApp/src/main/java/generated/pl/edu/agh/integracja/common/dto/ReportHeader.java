
package generated.pl.edu.agh.integracja.common.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "reportId",
    "notificationDate",
    "actionName",
    "address"
})
public class ReportHeader {

    @JsonProperty("reportId")
    private String reportId;
    @JsonProperty("notificationDate")
    private String notificationDate;
    @JsonProperty("actionName")
    private String actionName;
    @JsonProperty("address")
    private String address;

    /**
     * 
     * @return
     *     The reportId
     */
    @JsonProperty("reportId")
    public String getReportId() {
        return reportId;
    }

    /**
     * 
     * @param reportId
     *     The reportId
     */
    @JsonProperty("reportId")
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public ReportHeader withReportId(String reportId) {
        this.reportId = reportId;
        return this;
    }

    /**
     * 
     * @return
     *     The notificationDate
     */
    @JsonProperty("notificationDate")
    public String getNotificationDate() {
        return notificationDate;
    }

    /**
     * 
     * @param notificationDate
     *     The notificationDate
     */
    @JsonProperty("notificationDate")
    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public ReportHeader withNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
        return this;
    }

    /**
     * 
     * @return
     *     The actionName
     */
    @JsonProperty("actionName")
    public String getActionName() {
        return actionName;
    }

    /**
     * 
     * @param actionName
     *     The actionName
     */
    @JsonProperty("actionName")
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public ReportHeader withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public ReportHeader withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reportId).append(notificationDate).append(actionName).append(address).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReportHeader) == false) {
            return false;
        }
        ReportHeader rhs = ((ReportHeader) other);
        return new EqualsBuilder().append(reportId, rhs.reportId).append(notificationDate, rhs.notificationDate).append(actionName, rhs.actionName).append(address, rhs.address).isEquals();
    }

}

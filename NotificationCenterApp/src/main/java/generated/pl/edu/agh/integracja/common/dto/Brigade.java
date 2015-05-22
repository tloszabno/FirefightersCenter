
package generated.pl.edu.agh.integracja.common.dto;

import java.util.Date;
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
    "name",
    "membersNumber",
    "distanceInKm",
    "departureTime",
    "arrivalTime",
    "pumpworkTime"
})
public class Brigade {

    @JsonProperty("name")
    private String name;
    @JsonProperty("membersNumber")
    private Integer membersNumber;
    @JsonProperty("distanceInKm")
    private Integer distanceInKm;
    @JsonProperty("departureTime")
    private Date departureTime;
    @JsonProperty("arrivalTime")
    private Date arrivalTime;
    @JsonProperty("pumpworkTime")
    private String pumpworkTime;

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Brigade withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The membersNumber
     */
    @JsonProperty("membersNumber")
    public Integer getMembersNumber() {
        return membersNumber;
    }

    /**
     * 
     * @param membersNumber
     *     The membersNumber
     */
    @JsonProperty("membersNumber")
    public void setMembersNumber(Integer membersNumber) {
        this.membersNumber = membersNumber;
    }

    public Brigade withMembersNumber(Integer membersNumber) {
        this.membersNumber = membersNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The distanceInKm
     */
    @JsonProperty("distanceInKm")
    public Integer getDistanceInKm() {
        return distanceInKm;
    }

    /**
     * 
     * @param distanceInKm
     *     The distanceInKm
     */
    @JsonProperty("distanceInKm")
    public void setDistanceInKm(Integer distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public Brigade withDistanceInKm(Integer distanceInKm) {
        this.distanceInKm = distanceInKm;
        return this;
    }

    /**
     * 
     * @return
     *     The departureTime
     */
    @JsonProperty("departureTime")
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * 
     * @param departureTime
     *     The departureTime
     */
    @JsonProperty("departureTime")
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Brigade withDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    /**
     * 
     * @return
     *     The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 
     * @param arrivalTime
     *     The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Brigade withArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    /**
     * 
     * @return
     *     The pumpworkTime
     */
    @JsonProperty("pumpworkTime")
    public String getPumpworkTime() {
        return pumpworkTime;
    }

    /**
     * 
     * @param pumpworkTime
     *     The pumpworkTime
     */
    @JsonProperty("pumpworkTime")
    public void setPumpworkTime(String pumpworkTime) {
        this.pumpworkTime = pumpworkTime;
    }

    public Brigade withPumpworkTime(String pumpworkTime) {
        this.pumpworkTime = pumpworkTime;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(membersNumber).append(distanceInKm).append(departureTime).append(arrivalTime).append(pumpworkTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Brigade) == false) {
            return false;
        }
        Brigade rhs = ((Brigade) other);
        return new EqualsBuilder().append(name, rhs.name).append(membersNumber, rhs.membersNumber).append(distanceInKm, rhs.distanceInKm).append(departureTime, rhs.departureTime).append(arrivalTime, rhs.arrivalTime).append(pumpworkTime, rhs.pumpworkTime).isEquals();
    }

}

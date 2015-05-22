
package generated.integracja.common.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * RQ to firefightersPost
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "address",
    "city",
    "actionName",
    "description",
    "latitude",
    "longitude",
    "notifiactionDate",
    "creator",
    "orderedResources",
    "requestedFirefightersUnitNumber"
})
public class FireNotificationIDTO {

    @JsonProperty("type")
    private String type;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("actionName")
    private String actionName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("notifiactionDate")
    private Date notifiactionDate;
    @JsonProperty("creator")
    private String creator;
    @JsonProperty("orderedResources")
    private List<OrderedResource> orderedResources = new ArrayList<OrderedResource>();
    @JsonProperty("requestedFirefightersUnitNumber")
    private Integer requestedFirefightersUnitNumber;

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public FireNotificationIDTO withType(String type) {
        this.type = type;
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

    public FireNotificationIDTO withAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public FireNotificationIDTO withCity(String city) {
        this.city = city;
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

    public FireNotificationIDTO withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public FireNotificationIDTO withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public FireNotificationIDTO withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public FireNotificationIDTO withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * 
     * @return
     *     The notifiactionDate
     */
    @JsonProperty("notifiactionDate")
    public Date getNotifiactionDate() {
        return notifiactionDate;
    }

    /**
     * 
     * @param notifiactionDate
     *     The notifiactionDate
     */
    @JsonProperty("notifiactionDate")
    public void setNotifiactionDate(Date notifiactionDate) {
        this.notifiactionDate = notifiactionDate;
    }

    public FireNotificationIDTO withNotifiactionDate(Date notifiactionDate) {
        this.notifiactionDate = notifiactionDate;
        return this;
    }

    /**
     * 
     * @return
     *     The creator
     */
    @JsonProperty("creator")
    public String getCreator() {
        return creator;
    }

    /**
     * 
     * @param creator
     *     The creator
     */
    @JsonProperty("creator")
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public FireNotificationIDTO withCreator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * 
     * @return
     *     The orderedResources
     */
    @JsonProperty("orderedResources")
    public List<OrderedResource> getOrderedResources() {
        return orderedResources;
    }

    /**
     * 
     * @param orderedResources
     *     The orderedResources
     */
    @JsonProperty("orderedResources")
    public void setOrderedResources(List<OrderedResource> orderedResources) {
        this.orderedResources = orderedResources;
    }

    public FireNotificationIDTO withOrderedResources(List<OrderedResource> orderedResources) {
        this.orderedResources = orderedResources;
        return this;
    }

    /**
     * 
     * @return
     *     The requestedFirefightersUnitNumber
     */
    @JsonProperty("requestedFirefightersUnitNumber")
    public Integer getRequestedFirefightersUnitNumber() {
        return requestedFirefightersUnitNumber;
    }

    /**
     * 
     * @param requestedFirefightersUnitNumber
     *     The requestedFirefightersUnitNumber
     */
    @JsonProperty("requestedFirefightersUnitNumber")
    public void setRequestedFirefightersUnitNumber(Integer requestedFirefightersUnitNumber) {
        this.requestedFirefightersUnitNumber = requestedFirefightersUnitNumber;
    }

    public FireNotificationIDTO withRequestedFirefightersUnitNumber(Integer requestedFirefightersUnitNumber) {
        this.requestedFirefightersUnitNumber = requestedFirefightersUnitNumber;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(address).append(city).append(actionName).append(description).append(latitude).append(longitude).append(notifiactionDate).append(creator).append(orderedResources).append(requestedFirefightersUnitNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FireNotificationIDTO) == false) {
            return false;
        }
        FireNotificationIDTO rhs = ((FireNotificationIDTO) other);
        return new EqualsBuilder().append(type, rhs.type).append(address, rhs.address).append(city, rhs.city).append(actionName, rhs.actionName).append(description, rhs.description).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(notifiactionDate, rhs.notifiactionDate).append(creator, rhs.creator).append(orderedResources, rhs.orderedResources).append(requestedFirefightersUnitNumber, rhs.requestedFirefightersUnitNumber).isEquals();
    }

}

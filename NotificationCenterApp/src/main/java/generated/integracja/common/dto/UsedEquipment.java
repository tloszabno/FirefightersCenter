
package generated.integracja.common.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "workTimeInH",
    "fuelType"
})
public class UsedEquipment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("workTimeInH")
    private Integer workTimeInH;
    @JsonProperty("fuelType")
    private String fuelType;

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

    public UsedEquipment withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The workTimeInH
     */
    @JsonProperty("workTimeInH")
    public Integer getWorkTimeInH() {
        return workTimeInH;
    }

    /**
     * 
     * @param workTimeInH
     *     The workTimeInH
     */
    @JsonProperty("workTimeInH")
    public void setWorkTimeInH(Integer workTimeInH) {
        this.workTimeInH = workTimeInH;
    }

    public UsedEquipment withWorkTimeInH(Integer workTimeInH) {
        this.workTimeInH = workTimeInH;
        return this;
    }

    /**
     * 
     * @return
     *     The fuelType
     */
    @JsonProperty("fuelType")
    public String getFuelType() {
        return fuelType;
    }

    /**
     * 
     * @param fuelType
     *     The fuelType
     */
    @JsonProperty("fuelType")
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public UsedEquipment withFuelType(String fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(workTimeInH).append(fuelType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UsedEquipment) == false) {
            return false;
        }
        UsedEquipment rhs = ((UsedEquipment) other);
        return new EqualsBuilder().append(name, rhs.name).append(workTimeInH, rhs.workTimeInH).append(fuelType, rhs.fuelType).isEquals();
    }

}

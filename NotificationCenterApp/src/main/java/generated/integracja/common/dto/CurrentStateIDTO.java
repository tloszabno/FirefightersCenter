
package generated.integracja.common.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * RS from firefightersPost
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "availableEquipment",
    "availableUnits"
})
public class CurrentStateIDTO {

    @JsonProperty("availableEquipment")
    private List<AvailableEquipment> availableEquipment = new ArrayList<AvailableEquipment>();
    @JsonProperty("availableUnits")
    private Integer availableUnits;

    /**
     * 
     * @return
     *     The availableEquipment
     */
    @JsonProperty("availableEquipment")
    public List<AvailableEquipment> getAvailableEquipment() {
        return availableEquipment;
    }

    /**
     * 
     * @param availableEquipment
     *     The availableEquipment
     */
    @JsonProperty("availableEquipment")
    public void setAvailableEquipment(List<AvailableEquipment> availableEquipment) {
        this.availableEquipment = availableEquipment;
    }

    public CurrentStateIDTO withAvailableEquipment(List<AvailableEquipment> availableEquipment) {
        this.availableEquipment = availableEquipment;
        return this;
    }

    /**
     * 
     * @return
     *     The availableUnits
     */
    @JsonProperty("availableUnits")
    public Integer getAvailableUnits() {
        return availableUnits;
    }

    /**
     * 
     * @param availableUnits
     *     The availableUnits
     */
    @JsonProperty("availableUnits")
    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public CurrentStateIDTO withAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(availableEquipment).append(availableUnits).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CurrentStateIDTO) == false) {
            return false;
        }
        CurrentStateIDTO rhs = ((CurrentStateIDTO) other);
        return new EqualsBuilder().append(availableEquipment, rhs.availableEquipment).append(availableUnits, rhs.availableUnits).isEquals();
    }

}

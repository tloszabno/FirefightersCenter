
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
    "damageName"
})
public class OtherDamage {

    @JsonProperty("damageName")
    private String damageName;

    /**
     * 
     * @return
     *     The damageName
     */
    @JsonProperty("damageName")
    public String getDamageName() {
        return damageName;
    }

    /**
     * 
     * @param damageName
     *     The damageName
     */
    @JsonProperty("damageName")
    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public OtherDamage withDamageName(String damageName) {
        this.damageName = damageName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(damageName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OtherDamage) == false) {
            return false;
        }
        OtherDamage rhs = ((OtherDamage) other);
        return new EqualsBuilder().append(damageName, rhs.damageName).isEquals();
    }

}

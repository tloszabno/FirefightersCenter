
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
    "name",
    "surname"
})
public class Firefighter {

    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;

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

    public Firefighter withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The surname
     */
    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname
     *     The surname
     */
    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Firefighter withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(surname).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Firefighter) == false) {
            return false;
        }
        Firefighter rhs = ((Firefighter) other);
        return new EqualsBuilder().append(name, rhs.name).append(surname, rhs.surname).isEquals();
    }

}

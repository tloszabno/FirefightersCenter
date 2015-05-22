
package generated.pl.edu.agh.integracja.common.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * RQ to notification center: confirm/finish notification
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "state"
})
public class NotificationIDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("state")
    private NotificationIDTO.State state;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public NotificationIDTO withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public NotificationIDTO.State getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(NotificationIDTO.State state) {
        this.state = state;
    }

    public NotificationIDTO withState(NotificationIDTO.State state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(state).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NotificationIDTO) == false) {
            return false;
        }
        NotificationIDTO rhs = ((NotificationIDTO) other);
        return new EqualsBuilder().append(id, rhs.id).append(state, rhs.state).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum State {

        CONFIRMED("CONFIRMED"),
        FINISHED("FINISHED");
        private final String value;
        private static Map<String, NotificationIDTO.State> constants = new HashMap<String, NotificationIDTO.State>();

        static {
            for (NotificationIDTO.State c: values()) {
                constants.put(c.value, c);
            }
        }

        private State(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static NotificationIDTO.State fromValue(String value) {
            NotificationIDTO.State constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

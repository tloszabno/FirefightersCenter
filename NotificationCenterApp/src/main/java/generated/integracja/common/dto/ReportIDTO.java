
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
 * RQ from firefightersPost, RS from notification center
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "notificationId",
    "postName",
    "actionName",
    "accidentType",
    "community",
    "areaSize",
    "objectName",
    "owner",
    "otherDamages",
    "creator",
    "usedEquipment",
    "firefighters",
    "brigades"
})
public class ReportIDTO {

    @JsonProperty("notificationId")
    private String notificationId;
    @JsonProperty("postName")
    private String postName;
    @JsonProperty("actionName")
    private String actionName;
    @JsonProperty("accidentType")
    private String accidentType;
    @JsonProperty("community")
    private String community;
    @JsonProperty("areaSize")
    private String areaSize;
    @JsonProperty("objectName")
    private String objectName;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("otherDamages")
    private List<OtherDamage> otherDamages = new ArrayList<OtherDamage>();
    @JsonProperty("creator")
    private String creator;
    @JsonProperty("usedEquipment")
    private List<UsedEquipment> usedEquipment = new ArrayList<UsedEquipment>();
    @JsonProperty("firefighters")
    private List<Firefighter> firefighters = new ArrayList<Firefighter>();
    @JsonProperty("brigades")
    private List<Brigade> brigades = new ArrayList<Brigade>();

    /**
     * 
     * @return
     *     The notificationId
     */
    @JsonProperty("notificationId")
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * 
     * @param notificationId
     *     The notificationId
     */
    @JsonProperty("notificationId")
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public ReportIDTO withNotificationId(String notificationId) {
        this.notificationId = notificationId;
        return this;
    }

    /**
     * 
     * @return
     *     The postName
     */
    @JsonProperty("postName")
    public String getPostName() {
        return postName;
    }

    /**
     * 
     * @param postName
     *     The postName
     */
    @JsonProperty("postName")
    public void setPostName(String postName) {
        this.postName = postName;
    }

    public ReportIDTO withPostName(String postName) {
        this.postName = postName;
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

    public ReportIDTO withActionName(String actionName) {
        this.actionName = actionName;
        return this;
    }

    /**
     * 
     * @return
     *     The accidentType
     */
    @JsonProperty("accidentType")
    public String getAccidentType() {
        return accidentType;
    }

    /**
     * 
     * @param accidentType
     *     The accidentType
     */
    @JsonProperty("accidentType")
    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    public ReportIDTO withAccidentType(String accidentType) {
        this.accidentType = accidentType;
        return this;
    }

    /**
     * 
     * @return
     *     The community
     */
    @JsonProperty("community")
    public String getCommunity() {
        return community;
    }

    /**
     * 
     * @param community
     *     The community
     */
    @JsonProperty("community")
    public void setCommunity(String community) {
        this.community = community;
    }

    public ReportIDTO withCommunity(String community) {
        this.community = community;
        return this;
    }

    /**
     * 
     * @return
     *     The areaSize
     */
    @JsonProperty("areaSize")
    public String getAreaSize() {
        return areaSize;
    }

    /**
     * 
     * @param areaSize
     *     The areaSize
     */
    @JsonProperty("areaSize")
    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }

    public ReportIDTO withAreaSize(String areaSize) {
        this.areaSize = areaSize;
        return this;
    }

    /**
     * 
     * @return
     *     The objectName
     */
    @JsonProperty("objectName")
    public String getObjectName() {
        return objectName;
    }

    /**
     * 
     * @param objectName
     *     The objectName
     */
    @JsonProperty("objectName")
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public ReportIDTO withObjectName(String objectName) {
        this.objectName = objectName;
        return this;
    }

    /**
     * 
     * @return
     *     The owner
     */
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ReportIDTO withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * 
     * @return
     *     The otherDamages
     */
    @JsonProperty("otherDamages")
    public List<OtherDamage> getOtherDamages() {
        return otherDamages;
    }

    /**
     * 
     * @param otherDamages
     *     The otherDamages
     */
    @JsonProperty("otherDamages")
    public void setOtherDamages(List<OtherDamage> otherDamages) {
        this.otherDamages = otherDamages;
    }

    public ReportIDTO withOtherDamages(List<OtherDamage> otherDamages) {
        this.otherDamages = otherDamages;
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

    public ReportIDTO withCreator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * 
     * @return
     *     The usedEquipment
     */
    @JsonProperty("usedEquipment")
    public List<UsedEquipment> getUsedEquipment() {
        return usedEquipment;
    }

    /**
     * 
     * @param usedEquipment
     *     The usedEquipment
     */
    @JsonProperty("usedEquipment")
    public void setUsedEquipment(List<UsedEquipment> usedEquipment) {
        this.usedEquipment = usedEquipment;
    }

    public ReportIDTO withUsedEquipment(List<UsedEquipment> usedEquipment) {
        this.usedEquipment = usedEquipment;
        return this;
    }

    /**
     * 
     * @return
     *     The firefighters
     */
    @JsonProperty("firefighters")
    public List<Firefighter> getFirefighters() {
        return firefighters;
    }

    /**
     * 
     * @param firefighters
     *     The firefighters
     */
    @JsonProperty("firefighters")
    public void setFirefighters(List<Firefighter> firefighters) {
        this.firefighters = firefighters;
    }

    public ReportIDTO withFirefighters(List<Firefighter> firefighters) {
        this.firefighters = firefighters;
        return this;
    }

    /**
     * 
     * @return
     *     The brigades
     */
    @JsonProperty("brigades")
    public List<Brigade> getBrigades() {
        return brigades;
    }

    /**
     * 
     * @param brigades
     *     The brigades
     */
    @JsonProperty("brigades")
    public void setBrigades(List<Brigade> brigades) {
        this.brigades = brigades;
    }

    public ReportIDTO withBrigades(List<Brigade> brigades) {
        this.brigades = brigades;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(notificationId).append(postName).append(actionName).append(accidentType).append(community).append(areaSize).append(objectName).append(owner).append(otherDamages).append(creator).append(usedEquipment).append(firefighters).append(brigades).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReportIDTO) == false) {
            return false;
        }
        ReportIDTO rhs = ((ReportIDTO) other);
        return new EqualsBuilder().append(notificationId, rhs.notificationId).append(postName, rhs.postName).append(actionName, rhs.actionName).append(accidentType, rhs.accidentType).append(community, rhs.community).append(areaSize, rhs.areaSize).append(objectName, rhs.objectName).append(owner, rhs.owner).append(otherDamages, rhs.otherDamages).append(creator, rhs.creator).append(usedEquipment, rhs.usedEquipment).append(firefighters, rhs.firefighters).append(brigades, rhs.brigades).isEquals();
    }

}

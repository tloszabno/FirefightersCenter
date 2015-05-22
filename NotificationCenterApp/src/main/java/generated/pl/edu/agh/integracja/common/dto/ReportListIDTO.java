
package generated.pl.edu.agh.integracja.common.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * RS from notification center
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "reportHeaders"
})
public class ReportListIDTO {

    @JsonProperty("reportHeaders")
    private List<ReportHeader> reportHeaders = new ArrayList<ReportHeader>();

    /**
     * 
     * @return
     *     The reportHeaders
     */
    @JsonProperty("reportHeaders")
    public List<ReportHeader> getReportHeaders() {
        return reportHeaders;
    }

    /**
     * 
     * @param reportHeaders
     *     The reportHeaders
     */
    @JsonProperty("reportHeaders")
    public void setReportHeaders(List<ReportHeader> reportHeaders) {
        this.reportHeaders = reportHeaders;
    }

    public ReportListIDTO withReportHeaders(List<ReportHeader> reportHeaders) {
        this.reportHeaders = reportHeaders;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(reportHeaders).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReportListIDTO) == false) {
            return false;
        }
        ReportListIDTO rhs = ((ReportListIDTO) other);
        return new EqualsBuilder().append(reportHeaders, rhs.reportHeaders).isEquals();
    }

}

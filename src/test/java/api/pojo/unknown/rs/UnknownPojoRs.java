package api.pojo.unknown.rs;

import api.pojo.base.rs.BasePojoRs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * List<RECOURSE> pojo
 * <a href="https://reqres.in/api/unknown">...</a>
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnknownPojoRs extends BasePojoRs {
    public ArrayList<Datum> data;

    @Data
    public static class Datum {

        public int id;
        public String name;
        public int year;
        public String color;
        @JsonProperty("pantone_value")
        public String pantoneValue;
    }
}

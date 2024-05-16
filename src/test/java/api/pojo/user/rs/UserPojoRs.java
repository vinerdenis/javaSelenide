package api.pojo.user.rs;

import api.pojo.base.rs.BasePojoRs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * Pojo to get users list.
 * <a href="https://reqres.in/api/users?page=2">...</a>.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojoRs extends BasePojoRs {
    public ArrayList<Datum> data;

    @Data
    public static class Datum{
        public int id;
        public String email;
        @JsonProperty("first_name")
        public String firstName;
        @JsonProperty("last_name")
        public String lastName;
        public String avatar;
    }
}

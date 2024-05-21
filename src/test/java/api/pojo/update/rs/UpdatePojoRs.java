package api.pojo.update.rs;

import api.pojo.base.rs.BasePojoRs;
import lombok.Data;

import java.util.Date;

/**
 * POJO to update user
 * Request
 * /api/users/2
 */
@Data
public class UpdatePojoRs extends BasePojoRs {
    public String name;
    public String job;
    public String updatedAt;
}

package api.pojo.update.rq;

import api.pojo.base.rq.BasePojoRq;
import lombok.Builder;

/**
 * POJO to update user
 * Request
 * /api/users/2
 */

@Builder
public class UpdatePojoRq extends BasePojoRq {

    public String name;
    public String job;
}

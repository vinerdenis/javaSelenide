package api.pojo.register.rq;

import api.pojo.base.rq.BasePojoRq;
import lombok.Builder;

/**
 * Pojo to register user
 * <a href="https://reqres.in/api/register">...</a>
 */

@Builder
public class RegisterPojoRq extends BasePojoRq {
    public String email;
    public String password;
}

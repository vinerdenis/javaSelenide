package api.pojo.register.rs;

import api.pojo.base.rs.BasePojoRs;

/**
 * Pojo to register user
 * <a href="https://reqres.in/api/register">...</a>
 */
public class RegisterPojoRs extends BasePojoRs {
    public int id;
    public String token;
    public String error;
}

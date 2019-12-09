package ManagedBean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Enumerations.Role;


@ManagedBean
@ApplicationScoped
public class DataBean {

public Role[] getRoles() { return Role.values();}
}

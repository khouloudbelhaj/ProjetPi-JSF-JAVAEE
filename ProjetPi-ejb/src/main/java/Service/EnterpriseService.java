package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interfaces.IEnterpriseServiceRemote;
import model.Company;

@Stateless
@LocalBean
public class EnterpriseService implements IEnterpriseServiceRemote {
	
	@PersistenceContext(unitName = "new")
	EntityManager em;

	@Override
	public Company getEnterprise(int companyId) {
		return em.find(Company.class, companyId);
	}

	@Override
	public List<Company> getAllEnterprises() {
		return em.createQuery("select c from Company c",Company.class).getResultList();
	}

}

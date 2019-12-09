package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interfaces.CompanyServiceRemote;
import model.Company;


@Stateless
@LocalBean
public class CompanyService implements CompanyServiceRemote{
	
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Company> getAllCompanies() {
		List<Company> c = em.createQuery("SELECT x FROM Company x", Company.class).getResultList();

		return c;
	}
	

	@Override
	public Company findCompanyById(int id) {
		Company e = em.find(Company.class, id);
		return e;
	}
	

}

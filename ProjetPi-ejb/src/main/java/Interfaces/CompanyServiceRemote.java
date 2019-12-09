package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Company;

@Remote
public interface CompanyServiceRemote {
	
	public List<Company> getAllCompanies();
	public Company findCompanyById(int id);

}

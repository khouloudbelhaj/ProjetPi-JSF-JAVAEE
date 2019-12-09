package Interfaces;

import java.util.List;

import model.Company;

public interface IEnterpriseServiceRemote {
	public List<Company> getAllEnterprises();
	public Company getEnterprise(int companyId);
	
}

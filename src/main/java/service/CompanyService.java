package service;

import dto.request.company.GetCompanyInformationRequest;
import dto.request.company.UpdateCompanyRequest;
import dto.request.company.AddCompanyRequest;
import dto.response.company.CompanyResponse;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyResponse> createCompany(AddCompanyRequest request);
    Optional<CompanyResponse> removeCompanyById(String id);
    Optional<CompanyResponse> updateCompany(UpdateCompanyRequest updateRequest);
    List<CompanyResponse> findCompany(GetCompanyInformationRequest request);
    List<CompanyResponse> findAll (int pageNo, int pageSize);
}

package service.business;

import dto.request.company.AddCompanyRequest;
import dto.request.company.GetInformationCompanyRequest;
import dto.request.company.UpdateCompanyRequest;
import dto.response.company.CompanyResponse;
import exception.CompanyNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import service.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class CompanyImp implements CompanyService {
    private static final Supplier<CompanyNotFoundException> companyNotFoundExceptionSupplier =
            () -> new CompanyNotFoundException("Company Not Found!");
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    public CompanyImp(ModelMapper modelMapper, BookingRepository bookingRepository) {
        this.modelMapper = modelMapper;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Optional<CompanyResponse> createCompany(AddCompanyRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<CompanyResponse> removeCompanyById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CompanyResponse> updateCompany(UpdateCompanyRequest updateRequest) {
        return Optional.empty();
    }

    @Override
    public List<CompanyResponse> findCompany(GetInformationCompanyRequest request) {
        return null;
    }

    @Override
    public List<CompanyResponse> findAll(int pageNo, int pageSize) {
        return null;
    }
}

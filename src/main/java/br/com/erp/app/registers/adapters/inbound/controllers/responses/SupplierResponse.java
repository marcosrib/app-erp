package br.com.erp.app.registers.adapters.inbound.controllers.responses;

import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeOfPersonEnum;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class SupplierResponse {

    private Long id;
    private String fantasyName;
    private String companyName;
    private String email;
    private String cellPhoneNumber;
    private String phoneNumber;
    private String cpfCnpj;
    private SupplierTypeOfPersonEnum typeOfPerson;

    public static SupplierResponse fromDomain(Supplier supplier) {
        return  SupplierResponse
                .builder()
                .id(supplier.getId())
                .email(supplier.getEmail())
                .cpfCnpj(supplier.getCpfCnpj())
                .cellPhoneNumber(supplier.getPhoneNumber())
                .companyName(supplier.getCompanyName())
                .fantasyName(supplier.getFantasyName())
                .typeOfPerson(supplier.getTypeOfPerson())
                .phoneNumber(supplier.getPhoneNumber())
                .build();
    }

    public static List<SupplierResponse> fromDomainToList(List<Supplier> suppliers) {
        return suppliers.stream().map(SupplierResponse::fromDomain).collect(Collectors.toList());
    }
}

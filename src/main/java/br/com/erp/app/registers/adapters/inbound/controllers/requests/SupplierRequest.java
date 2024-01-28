package br.com.erp.app.registers.adapters.inbound.controllers.requests;

import br.com.erp.app.common.annotationcustom.CpfCnpj;
import br.com.erp.app.registers.application.core.domain.Supplier;
import br.com.erp.app.registers.application.core.domain.enums.SupplierTypeOfPersonEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierRequest(
        @NotBlank(message = "nome fantasia {name.not.empty}")
        String fantasyName,
        String companyName,
        @Email(message = "{email.invalid}")
        String email,
        @Size(max = 9, message = "O celular {max.characters}")
        @Size(min = 9, message = "O celular {min.characters}")
        String cellPhone,
        @Size(max = 9, message = "O telefone {max.characters}")
        @Size(min = 9, message = "O telefone {min.characters}")
        String phone,
        @CpfCnpj
        String cpfCnpj,
        SupplierTypeOfPersonEnum type
) {
    public Supplier toSupplierDomain() {
        return Supplier
                .builder()
                .companyName(companyName)
                .cellPhoneNumber(cellPhone)
                .cpfCnpj(cpfCnpj)
                .fantasyName(fantasyName)
                .phoneNumber(phone)
                .email(email)
                .typeOfPerson(type)
                .build();
    }
}

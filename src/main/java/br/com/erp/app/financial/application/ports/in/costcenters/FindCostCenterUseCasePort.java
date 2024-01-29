package br.com.erp.app.financial.application.ports.in.costcenters;

import br.com.erp.app.financial.application.core.domain.CostCenter;

import java.util.List;

public interface FindCostCenterUseCasePort {
    List<CostCenter> findAll();
}

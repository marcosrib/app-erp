package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.common.exceptions.ResourceNotFoundException;
import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.out.chartaccounts.FindChartAccountAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class FindChartAccountAdapter implements FindChartAccountAdapterPort {

    private final ChartAccountRepository chartAccountRepository;

    public FindChartAccountAdapter(ChartAccountRepository chartAccountRepository) {
        this.chartAccountRepository = chartAccountRepository;
    }

    @Override
    public ChartAccount findChartAccountById(Integer id) {
        var chartAccountEntity = chartAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cart.accounts.not.found"));
        return ChartAccount.convertChartAccountEntityToChartAccount(chartAccountEntity);
    }
}

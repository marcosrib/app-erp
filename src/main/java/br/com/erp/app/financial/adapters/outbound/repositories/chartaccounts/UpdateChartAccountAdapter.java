package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.out.chartaccounts.UpdateChartAccountAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateChartAccountAdapter implements UpdateChartAccountAdapterPort {

    private final ChartAccountRepository chartAccountRepository;

    public UpdateChartAccountAdapter(ChartAccountRepository chartAccountRepository) {
        this.chartAccountRepository = chartAccountRepository;
    }

    @Override
    public void update(ChartAccount chartAccount) {
        var chartAccountEntity =  ChartAccountEntityMapper.convertChartAccountToChartAccountEntity(chartAccount);
        chartAccountRepository.save(chartAccountEntity);
    }
}

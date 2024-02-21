package br.com.erp.app.financial.adapters.outbound.repositories.chartaccounts;

import br.com.erp.app.financial.application.core.domain.ChartAccount;
import br.com.erp.app.financial.application.ports.out.chartaccounts.CreateChartAccountAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class CreateChartAccountAdapter  implements CreateChartAccountAdapterPort {

    private final ChartAccountRepository chartAccountRepository;

    public CreateChartAccountAdapter(ChartAccountRepository chartAccountRepository) {
        this.chartAccountRepository = chartAccountRepository;
    }

    @Override
    public void create(ChartAccount chartAccount) {
     var chartAccountEntity =  ChartAccountEntityMapper.convertChartAccountToChartAccountEntity(chartAccount);
     chartAccountRepository.save(chartAccountEntity);
    }
}

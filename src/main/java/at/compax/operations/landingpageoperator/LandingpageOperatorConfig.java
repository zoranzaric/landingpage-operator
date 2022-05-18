package at.compax.operations.landingpageoperator;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

@Configuration
public class LandingpageOperatorConfig {
  @Bean
  public NamespaceReconciler namespaceController() {
    return new NamespaceReconciler();
  }

  // Register all controller beans
  @Bean(initMethod = "start", destroyMethod = "stop")
  @SuppressWarnings("rawtypes")
  public Operator operator(List<Reconciler> controllers) {
    Operator operator = new Operator(DefaultConfigurationService.instance());
    controllers.forEach(operator::register);
    return operator;
  }
}

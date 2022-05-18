package at.compax.operations.landingpageoperator;

import io.fabric8.kubernetes.api.model.Namespace;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;

@ControllerConfiguration
public class NamespaceReconciler implements Reconciler<Namespace> {
  @Override
  public UpdateControl<Namespace> reconcile(Namespace namespace, Context context) {
    System.out.println("reconcile namespace " + namespace.getMetadata().getName());

    return UpdateControl.noUpdate();
  }
}

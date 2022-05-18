package at.compax.operations.landingpageoperator;

import io.fabric8.kubernetes.api.model.Namespace;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;

@ControllerConfiguration
public class NamespaceReconciler implements Reconciler<Namespace>, ResourceContro {

  public NamespaceReconciler() {
  }

  @Override
  public UpdateControl<Namespace> reconcile(Namespace namespace, Context context) {
    System.out.println("reconcile namespace " + namespace.getMetadata().getName());
    String url = namespace.getMetadata().getLabels().get("landingpage-url");
    if (url != null) {
      System.out.println(namespace.getMetadata().getName() + " landingpage-url=" + url);
    } else {
      System.out.println(namespace.getMetadata().getName() + " landingpage-url-");
    }

    return UpdateControl.noUpdate();
  }
}

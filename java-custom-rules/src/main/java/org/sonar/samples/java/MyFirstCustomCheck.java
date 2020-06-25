package org.sonar.samples.java.checks;
 
import com.google.common.collect.ImmutableList;
 
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;
 
import java.util.List;
 
@Rule(
  key = "MyFirstCustomCheck",
  name = "Return type and parameter of a method should not be the same",
  description = "For a method having a single parameter, the types of its return value and its parameter should never be the same.",
  priority = Priority.CRITICAL,
  tags = {"bug"})
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {
 
  @Override
  public List<Kind> nodesToVisit() {
    return ImmutableList.of();
  }
 
}

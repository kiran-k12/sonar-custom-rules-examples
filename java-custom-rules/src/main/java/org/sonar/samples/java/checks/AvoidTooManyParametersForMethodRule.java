package org.sonar.samples.java.checks;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import com.google.common.collect.ImmutableList;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.tree.MethodTree;
import java.util.List;

@Rule(Key = "AvoidTooManyParametersForMethod", description = "Method should not have more than 5 meters", priority = Priority.MAJOR, tags = {"bug"} )
public class AvoidTooManyParametersForMethodRule extends IssuableSubscriptionVisitor{
  
  @Override
  public List<Kind> nodesToVisit() {
    return ImmutableList.of(Tree.Kind.METHOD);
  }
  
  public void visitNode(Tree tree){
    MethodTree methodTree = (MethodTree) tree;
    MethodSymbol methodSymbol = methodTree.symbol();
    if(methodSymbol.parameterTypes().size() > 5) {
      reportIssue(tree, "Too Many Parameters"); 
    }
  }
  
}

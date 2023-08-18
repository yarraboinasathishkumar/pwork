package designpattern;

// Abstract Expression
interface Expression {
    public boolean interpret(String context);
}

// Terminal Expression
class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}

// Nonterminal Expression
class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

// Client code
public class InterpreterClient {
    /***
     *
     * In this example, the Interpreter design pattern is used to define a grammar and interpret
     * sentences in that grammar.
     *
     * The Expression interface declares the interpret() method, which takes a context and
     * returns a boolean value based on the interpretation.
     *
     * The TerminalExpression class is a terminal expression that implements the Expression interface.
     * It represents a single element in the grammar and checks if the context contains the specified data.
     *
     * The AndExpression and OrExpression classes are nonterminal expressions that implement the Expression interface.
     * They represent the logical "AND" and "OR" operations on two expressions.
     *
     * The client code defines the grammar rules and creates the corresponding expressions using the
     * TerminalExpression and NonterminalExpression classes. It then calls the interpret() method
     * on the expressions with different contexts to check the interpretation.
     *
     * In this example, the grammar rules are:
     *
     * John and Robert are male
     * Julie is a married woman
     * The client code checks if "John" is male and if "Julie" is a married woman by calling the interpret()
     * method on the corresponding expressions.
     *
     * By using the Interpreter pattern, we can define a language and provide a way to interpret sentences
     * in that language. It can be useful in cases where complex rules or expressions need to be
     * evaluated based on a given context.
     * @return
     */
    // Rules: John and Robert are male, Julie is a married woman
    public static Expression getMaleExpression() {
        Expression john = new TerminalExpression("John");
        Expression robert = new TerminalExpression("Robert");
        return new OrExpression(john, robert);
    }

    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression maleExpression = getMaleExpression();
        Expression marriedWomanExpression = getMarriedWomanExpression();

        System.out.println("John is male? " + maleExpression.interpret("John"));
        System.out.println("Julie is a married woman? " + marriedWomanExpression.interpret("Married Julie"));
    }
}

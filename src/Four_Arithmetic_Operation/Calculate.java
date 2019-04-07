package Four_Arithmetic_Operation;

import java.util.Stack;

public class Calculate {
	
    private Stack<String> numberStack = null;
    
    private Stack<Character> symbolStack = null;

    public String calculate(String numStr) {
        numStr = removeStrSpace(numStr); 
        if (numStr.length() > 1 && !"=".equals(numStr.charAt(numStr.length() - 1) + "")) {
            numStr += "=";
        }
        if (!isStandard(numStr)) {
            System.err.println("错误：算术表达式有误！");
            return "0";
        }
        numberStack = new Stack<String>();
        symbolStack = new Stack<Character>();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (isNumber(ch) || ch == '/') {
                temp.append(ch);
            } else {
                String tempStr = temp.toString(); 
                if (!tempStr.isEmpty()) {
                    numberStack.push(tempStr);
                    temp = new StringBuffer();
                }
                while (!comparePri(ch) && !symbolStack.empty()) {
                    String a = numberStack.pop();
                    String b = numberStack.pop();
                    Fraction f1 = null;
                    Fraction f2 = null;
                    if (a.contains("/")) {
                        String[] alist = a.split("/");
                        f1 = new Fraction(Integer.parseInt(alist[0]), Integer.parseInt(alist[1]));
                    } else {
                        f1 = new Fraction(Integer.parseInt(a), 1);
                    }
                    if (b.contains("/")) {
                        String[] blist = b.split("/");
                        f2 = new Fraction(Integer.parseInt(blist[0]), Integer.parseInt(blist[1]));
                    } else {
                        f2 = new Fraction(Integer.parseInt(b), 1);
                    }
                    switch (symbolStack.pop()) {
                        case '+':
                            numberStack.push(f2.plus(f1).print());
                            break;
                        case '-':
                            numberStack.push(f2.minus(f1).print());
                            break;
                        case '*':
                            numberStack.push(f2.multiply(f1).print());
                            break;
                        case '÷':
                            if (f1.fenzi==0){
                                System.err.println("错误：除数为0");
                                return null;
                            }
                            numberStack.push(f2.divide(f1).print());
                            break;
                        default:
                            break;
                    }
                }
                if (ch != '=') {
                    symbolStack.push(new Character(ch));
                    if (ch == ')') {
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
            }
        }

        return numberStack.pop();
    }

    private String removeStrSpace(String str) {
        return str != null ? str.replaceAll(" ", "") : "";
    }

    private boolean isStandard(String numStr) {
        if (numStr == null || numStr.isEmpty()) 
            return false;
        Stack<Character> stack = new Stack<Character>();
        boolean b = false;
        for (int i = 0; i < numStr.length(); i++) {
            char n = numStr.charAt(i);
            if (!(isNumber(n) || "(".equals(n + "") || ")".equals(n + "")
                    || "+".equals(n + "") || "-".equals(n + "")
                    || "*".equals(n + "") || "÷".equals(n + "") || "/".equals(n + "")
                    || "=".equals(n + ""))) {
                return false;
            }

            if ("(".equals(n + "")) {
                stack.push(n);
            }
            if (")".equals(n + "")) {
                if (stack.isEmpty() || !"(".equals((char) stack.pop() + "")) // 括号是否匹配
                    return false;
            }
            if ("=".equals(n + "")) {
                if (b)
                    return false;
                b = true;
            }
        }
        if (!stack.isEmpty())
            return false;
        if (!("=".equals(numStr.charAt(numStr.length() - 1) + "")))
            return false;
        return true;
    }

    private boolean isNumber(char num) {
        if (num >= '0' && num <= '9')
            return true;
        return false;
    }

    private boolean comparePri(char symbol) {
        if (symbolStack.empty()) {
            return true;
        }
        char top = symbolStack.peek();
        if (top == '(') {
            return true;
        }
        switch (symbol) {
            case '(':
                return true;
            case '*': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '÷': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '+':
                return false;
            case '-':
                return false;
            case ')':
                return false;
            case '=':
                return false;
            default:
                break;
        }
        return true;
    }

    String getFinalResult(String str) {
        if (!str.contains("/"))
            return str;
        String[] part = str.split("/");
        int a = Integer.parseInt(part[0]);
        int b = Integer.parseInt(part[1]);
        if (a == b)
            return "1";
        else if (a > b && a % b != 0) {
            return a / b + "’" + a % b + "/" + b;
        } else if (a < b && -a > b && (-a) % b != 0) {
            return "-" + (-a) / b + "’" + (-a) % b + "/" + b;
        } else if (b == 1)
            return a + "";
        else
            return a + "/" + b;
    }
}

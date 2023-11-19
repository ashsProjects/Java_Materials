import java.util.*;

public class ExpressionTree{
    public Node root;

    public class Node {
        public String token;
        public Node left;
        public Node right;

        public Node(String value) {
            this.token = value;
        }
    }

    public List<String> convert(Queue<String> infix) {
    	LinkedList<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        while (!infix.isEmpty()) {
            if (isInteger(infix.peek())) queue.add(infix.poll());
            else if (isOperator(infix.peek())) {
                if (stack.isEmpty()) stack.push(infix.poll());
                else {
                    while(!stack.isEmpty() && !stack.peek().equals("(") && precedence(infix.peek()) >= precedence(stack.peek())) {
                        queue.add(stack.pop());
                    } 
                    stack.push(infix.poll());
                }
            }
            else if (infix.peek().equals("(")) stack.push(infix.poll());
            else {
                while (!stack.peek().equals("(")) queue.add(stack.pop());
                stack.pop();
                infix.poll();
            }
        }
        while (!stack.isEmpty()) queue.add(stack.pop());   
        return queue;
	}
    public void build(List<String> postfix) {
        Collections.reverse(postfix);
        for (String token : postfix)
            buildRecursive(root, token);
    }

    public boolean buildRecursive(Node current, String token) {
        if (root == null) {
            root = new Node(token);
            return true;
        }
        if (current.right == null) {
            current.right = new Node(token);
            return true;
        }
        if (isOperator(current.right.token)) {
            if (buildRecursive(current.right, token) == false);
            else return true;
        }
        if (current.left == null) {
            current.left = new Node(token);
            return true;
        }
        else if (isOperator(current.left.token)) {
            if (buildRecursive(current.left, token) == false);
            else return true;
        }
    	return false;
	}

    public Queue<String> parse(java.lang.String expression) {
        Queue<java.lang.String> infix = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "(?<=[-+*()%/])|(?=[-+*()%/])", true);
        while(tokenizer.hasMoreTokens()){
            java.lang.String token = tokenizer.nextToken();
            if(!token.trim().isEmpty()) {
                infix.add(token.trim());
            }
        }
        return infix;
    }

    public static boolean isOperator(String token) {
        switch (token) {
            case "*":
            case "/":
            case "%":
            case "+":
            case "-":
                return true;
            default:
                return false;
        }
    }

    public static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int valueOf(String token) {
        try {
            return(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
            case "%":
                return 1;
            default:
                return 0;
        }
    }
}

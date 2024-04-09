import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                // Ignore empty components and current directory indicators
                continue;
            } else if (component.equals("..")) {
                // Go up one level by popping from stack (if not at root)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory names onto stack
                stack.push(component);
            }
        }
        
        StringBuilder simplifiedPath = new StringBuilder();
        
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, stack.pop());
            simplifiedPath.insert(0, '/');
        }
        if (simplifiedPath.length() == 0) {
            simplifiedPath.append('/');
        }
        
        return simplifiedPath.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.simplifyPath("/home/")); // Output: "/home"
        System.out.println(solution.simplifyPath("/../")); // Output: "/"
        System.out.println(solution.simplifyPath("/home//foo/")); // Output: "/home/foo"
        System.out.println(solution.simplifyPath("/a/./b/../../c/")); // Output: "/c"
        System.out.println(solution.simplifyPath("/a//b////c/d//././/..")); // Output: "/a/b/c"
    }
}

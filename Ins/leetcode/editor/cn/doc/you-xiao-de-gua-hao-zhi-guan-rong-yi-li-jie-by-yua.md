### 解题思路
此处撰写解题思路

### 代码

```java
import java.util.Stack;
//括号匹配问题(用栈来解决)
class Solution {-
    public static boolean isValid(String s) {
        //思路:遇到左括号就入栈，遇到右括号进行匹配，匹配成功，弹出栈顶
        //一直匹配到栈中没有元素，才算成功
        Stack<Character> stack = new Stack<>();
        //只要再以下过程当中 发现不匹配  直接return false;
        for (int i = 0; i < s.length(); i++) {
            //1、左括号进行入栈
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else{
                //2、判断栈是否为空
                if(stack.isEmpty()) {
                    return false;
                } else{
                    //3、判断栈顶元素的字符左括号和当前的字符 右括号是否匹配
                    char cur = s.charAt(i);
                    char topChar = stack.peek();
                    if(cur == ')' && topChar == '(' ||cur == ']' && topChar == '[' || cur == '}' && topChar == '{') {
                        stack.pop();
                    } else {
    
                        return  false;
                    }
                }
            }
            }
        //4、判断栈是否为空
        if (!stack.isEmpty()){
            return false;
        }
        System.out.println("括号匹配");
        return true;
        }

    }

```
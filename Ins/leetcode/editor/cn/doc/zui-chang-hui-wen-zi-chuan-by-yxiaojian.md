# 一、动态规划
如果i->j的子串为回文串，则有以下情况:
#### 1、只有一个时，i=j
![image.png](https://pic.leetcode-cn.com/1604984713-dGuAQT-image.png)

#### 2、两个字符时，i+1=j && str[i]==str[j]
![image.png](https://pic.leetcode-cn.com/1604984820-grjmHD-image.png)

#### 3、str[i]==str[j] 且i+1->j-1也是回文串
![image.png](https://pic.leetcode-cn.com/1604984597-ASZbUu-image.png)




则可写出动态规划的状态转移方程如下：dp[i][j]表示i->j是回文串
![dp\[i\]\[j\]=\begin{cases}true&\text{i=j||(i+1=jandSi==Sj)}\\(Si=Sj)∧dp\[i+1\]\[j-1\]\end{cases} ](./p__dp_i__j_=begin{cases}__true&_text{i=j_||__i+1=j_and_Si==Sj_}___Si=Sj_∧dp_i+1__j-1___end{cases}_.png) 
```java
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int start=0,end=0;
        for (int i = 0; i <n-1 ; i++) dp[i][i]=true;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <j ; i++) {
                if(s.charAt(i)==s.charAt(j) &&((j==i+1) ||  dp[i+1][j-1]))
                {
                    if(j-i>end-start){
                        start=i;
                        end=j;
                    }
                    dp[i][j]=true;
                }
            }
        }
        return s.substring(start,end+1);
    }
}

```

___

# 二、中心扩散
对于回文串我们都可以找到一个中心，这个中心是i->j都相同的一个子串
我们从回文串的中心出发，往两边扩散
![image.png](https://pic.leetcode-cn.com/1604986223-DdgoQn-image.png)

```java
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int i=0,start=0,end=0;
        while(i<n){
            int j=i;
            while( j+1<n && s.charAt(j)==s.charAt(j+1)) j++;
            int left=i,right=j;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){//扩散
                left--;
                right++;
            }
            if(right-left>end-start){
                start=left;
                end=right;
            }
            i=j+1;//跳过相同的
        }
        return s.substring(start+1,end);
    }
}
```


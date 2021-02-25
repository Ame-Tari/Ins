## 70. 爬楼梯

**题目：**

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

**注意：** 给定 n 是一个正整数。

**示例：**

```md
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

### 动态规划

当前第*i*个台阶的跳法要么是第*i-2*个台阶以下跳2个台阶跳过来，要么就是第*i-1*个台阶跳一步跳过来，因此得到*f(i) = f(i-1) + f(i-2)*，典型的斐波那契数列。

```java
class Solution {
    public int climbStairs(int n) {
        int f0 = 0, f1 = 1, fn = 0;
        for (int i = 0; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f0;
    }
}
```

#### 复杂度分析

* 时间复杂度：*O(n)*
  
    循环*n*次。
* 空间复杂度：*O(1)*

    常数级变量。

我的博客：<https://me.csdn.net/qq_20067165?ref=miniprofile>
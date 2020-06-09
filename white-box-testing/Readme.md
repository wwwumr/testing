# 数据流测试
## 测试代码
```java
public double primary(double val, Token_Stream ts, Error error) {
    Token token = ts.get();
    switch (token.getKind()) {
      case '8':
        val = token.getValue();
        break;
      case '(':
        val = expression(ts, error);
        token = ts.get();
        if (token.getKind() != ')') {
          error.setError(5);
        }
        break;
      case '+':
        val = primary(0, ts, error);
        break;
      case '-':
        val = -primary(0, ts, error);
        break;
      default:
        error.setError(6);
    }
    return val;
}
```
加上行号
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510144350227.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMTE2MTg1,size_16,color_FFFFFF,t_70)
## def/use图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200510150405403.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMTE2MTg1,size_16,color_FFFFFF,t_70)
变量名	| 定义节点	        | 使用节点
val	    | 1,5,8,15,18	    | 23
ts	        | 1,2,8,9,15,18	    | 2,8,9,15,18
error	| 1,8,11,15,18,21 |	
token	| 2,9	                    | 3,5,10

## 路径
val:
  {1, 23}
  {5, 23}
  {8, 23}
  {15, 23}
  {18, 23}
ts:
  {1, 2}


## 覆盖指标
## 测试用例
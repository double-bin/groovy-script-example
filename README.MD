### springboot接口动态执行groovy脚本

1. 打包：项目根目录运行: mvn clean install ,在target目录下生产可执行jar包：groovy-script-example-1.0.0.jar
2. 运行: 以jar包所在目录运行为例： java -jar groovy-script-example-1.0.0.jar, 默认使用8080端口(可自行修改springboot配置文件定义端口号)
3. 脚本执行：
    + url: [http://${ip}:8080/groovy/script/execute](http://localhost:8080/groovy/script/execute)
    + method: post
    + bodytype: Text
    + body: groovy脚本

4. 示例groovy脚本：

+ 调用TestService方法：

    ```
    def query = testService.testQuery(1L)
    query
    ```
    结果返回："Test query success, id is 1".


+ 直接调用scriptBaseClass的方法：

    ```
    def sum = add(1,2)
    sum
    ```
    结果返回: 3.
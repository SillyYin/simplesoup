# 完成一个最基本的soup请求
1. 在pom文件中引入相关依赖和插件
2. 完成一个xsd文档，targetNamespace就是自己这个xsd文档的命名空间
3. 使用maven的install生成代码
4. 随后编写EndPoint，相当于Controller
5. 编写配置类
6. 启动服务，访问http://127.0.0.1:8080/ws/employee.wsdl可以得到wsdl，下载下来就可以使用
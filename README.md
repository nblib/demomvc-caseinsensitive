# springMvc url和请求参数大小写忽略

# 配置
## url大小写忽略
``` 
 <!-- 定义一个Matcher，忽视大小写-->

    <bean id="pathMatcher" class="org.springframework.util.AntPathMatcher">
        <property name="caseSensitive" value="false"/>
    </bean>
    <mvc:annotation-driven enable-matrix-variables="true">
        <!-- 引用Matcher-->
        <mvc:path-matching path-matcher="pathMatcher"/>
    </mvc:annotation-driven>
```

## 参数大小写忽略
自定义filter和request，在web.xml中配置
``` 
<!-- 过滤请求，将参数名封装到忽略大小写中 -->
<filter>
    <filter-name>requestCaseInsensitiveFilter</filter-name>
    <filter-class>com.hewe.demospringmvc.config.CaseInsensitiveFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>requestCaseInsensitiveFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>

```

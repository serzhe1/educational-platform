import React from 'react';
import { Layout } from 'antd';
import ReactMarkdown from 'react-markdown';
import { Footer } from 'antd/es/layout/layout';

const { Content } = Layout;

const LectureContent = () => {
    const content = `
## **Что такое Configuration в Spring Boot?**

Configuration - это механизм, который позволяет определить настройки и свойства вашего приложения. В Spring Boot Configuration может использоваться для задания настроек подключения к базе данных, создания экземпляров бинов и многого другого.

## **Как создать конфигурационный класс в Spring Boot?**

Для создания конфигурационного класса в Spring Boot необходимо выполнить несколько простых шагов:

1. Создать Java-класс и пометить его аннотацией @Configuration.
2. Для определения бинов использовать аннотацию @Bean.
3. Опционально использовать аннотацию @PropertySource для загрузки внешнего файла с настройками.

\`\`\`java
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost/mydb")
                .username("myuser")
                .password("mypassword")
                .build();
    }
}
\`\`\`

## **Как использовать конфигурационный класс в Spring Boot?**

Чтобы использовать конфигурационный класс в Spring Boot, необходимо добавить его в класс приложения с помощью аннотации @Import.

\`\`\`java
@SpringBootApplication
@Import(AppConfig.class)
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
\`\`\`

## **Как использовать настройки из application.properties?**

Чтобы использовать настройки из файла application.properties, можно использовать аннотацию @Value.

\`\`\`java
@Service
public class MyService {

    @Value("\${my.setting}")
    private String setting;

    public void doSomething() {
        System.out.println(setting);
    }
}
\`\`\`

## **Как использовать настройки из application.yml?**

Чтобы использовать настройки из файла application.yml, можно использовать класс ConfigurationProperties.

\`\`\`yaml
my:
  setting: "Hello, World!"
\`\`\`

\`\`\`java
@Service
@ConfigurationProperties(prefix = "my")
public class MyService {

    private String setting;

    public void doSomething() {
        System.out.println(setting);
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }
}
\`\`\`

## **Заключение**

В этом уроке мы рассмотрели, что такое Configuration в Spring Boot и как создать конфигурационный класс для определения бинов и настроек. Мы также узнали, как использовать настройки из файлов application.properties и application.yml.
`;
    return (


        <Layout>
            <Content>
                <ReactMarkdown>{content}</ReactMarkdown>
            </Content>
            <Footer style={{ textAlign: 'center' }}>MyApp ©2023 Created by Me</Footer>
        </Layout>
    );
};

export default LectureContent;
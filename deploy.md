Deploy Java Application on Heroku
--
#### 1. Adding the plugin
To include the plugin in your project, add the following to your `pom.xml` file:
```pom.xml
<project>
  ...
  <build>
    ...
    <plugins>
      <plugin>
        <groupId>com.heroku.sdk</groupId>
        <artifactId>heroku-maven-plugin</artifactId>
        <version>2.0.3</version>
      </plugin>
    </plugins>
  </build>
</project>
```

Add this configuration for plugin `heroku-maven-plugin`

```pom.xml
<configuration>
  <appName>my-identity</appName>
</configuration>
```

#### 2. Add heroku remote for existing repository

`heroku git:remote -a my-identity`

#### 3. Deploying with the plugin

`mvn clean heroku:deploy-war`

Now you can visit your application with this command: `heroku open`

Or view the logs with this command: `heroku logs`


#### Heroku command note

- `heroku apps` - view all apps
- `heroku restart` - restart current app
- `heroku apps:info --app my-identity` - view app `my-identity` application information
- `heroku git:remote -a my-identity` - add the heroku remote for existing repository

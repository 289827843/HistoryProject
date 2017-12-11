#   用户中心
    用户相关后端接口
##  配置信息
    服务名称：sxun-service-ucenter
    服务端口：8302
##  依赖
    sxun-service-center
    sxun-service-config
##  编译
    mvn clean
    mvn package
##  目录结构
    --根目录
        --doc     //文档，包括数据库设计等
        --service-core  //核心服务
            --config_repo  //各服务的配置文件，以服务名-profile.properties 方式存放
        --service-ucenter-interface //rest api 抽象接口 用于服务间调用
        --src/main/java/com.sxun.server.platform.service.ucenter
            --configurer //配置类
            --core  //核心抽象
            --dao   //数据访问层
            --model //数据实体
            --service //服务层
            --web //rest api 或文本
        --src/main/resources
            --mapper //mybaits映射
        